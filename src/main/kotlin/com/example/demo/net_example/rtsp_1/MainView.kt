package com.example.demo.net_example.rtsp_1

import javafx.application.Platform
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.image.ImageView
import javafx.scene.layout.AnchorPane
import javafx.stage.Stage
import org.freedesktop.gstreamer.*
import org.freedesktop.gstreamer.Bus.ERROR
import org.freedesktop.gstreamer.Element.PAD_ADDED
import org.freedesktop.gstreamer.elements.AppSink
import tornadofx.*
import java.lang.StringBuilder
import java.nio.ByteOrder
import java.util.ArrayList

class MainView : View("My View") {

    var myController: Controller? = null
    private val imageViews: ArrayList<ImageView>? = null
    private var imageView: ImageView? = null
    private var videosink: AppSink? = null
    private var pipe: Pipeline? = null
    private var caps: StringBuilder? = null
    private var imageContainer: ImageContainer? = null
    private var imageContainer_two: ImageContainer? = null

    private var prefWidth = 0.0
    private var prefHeight = 0.0

    init {
        pipe = Pipeline()
        val source = ElementFactory.make("rtspsrc", "source")
        val decodebin = ElementFactory.make("decodebin", "decoder")
        val depay = ElementFactory.make("rtph264depay", "depay")
        val converter = ElementFactory.make("autovideoconvert", "converter")
        videosink = AppSink("sink")
        videosink!!["emit-signals"] = true
        videosink!!["name"] = "sinkexample"
        val gstListener = AppSinkListener()
        videosink!!.connect(gstListener)
        caps = StringBuilder("video/x-raw, ")
        if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            caps!!.append("format=BGRx")
        } else {
            caps!!.append("format=xRGB")
        }
        videosink!!.caps = Caps(caps.toString())
        videosink!!["max-buffers"] = 10000
        videosink!!["drop"] = true
        imageView = ImageView()
        imageContainer = gstListener.imageContainer
        imageContainer!!.addListener(javafx.beans.value.ChangeListener { observable, oldValue, newValue ->
            Platform.runLater {
                imageView!!.image = newValue
            }
        })
        source["location"] = "rtsp://184.72.239.149/vod/mp4:BigBuckBunny_175k.mov"
        source["latency"] = 1000
        pipe!!.bus.connect(ERROR { source2, code, message -> println("$source2 $code $message") })
        pipe!!.addMany(source, depay, decodebin, converter, videosink)
        source.connect(PAD_ADDED { element, pad ->
            try {
                println(pad)
                print(Element.linkMany(element, depay, decodebin))
            } catch (ex: PadLinkException) {
                ex.printStackTrace()
            }
        })
        decodebin.connect(PAD_ADDED { element, pad ->
            element.setCaps(Caps(caps.toString()))
            println(element.link(converter))
        })
        pipe!!.state = State.PLAYING
        converter.link(videosink)
        Pipeline.linkMany(converter, videosink)
        pipe!!.play()


        //        val root = FXMLLoader(javaClass.getResource("sample.fxml"))
//        myController = Controller()
//        root.location = javaClass.getResource("sample.fxml").toURI().toURL()
//        root.setController(myController)
//        val p = root.load<AnchorPane>()
//        myController!!.main_to_controller(imageView)
//        primaryStage.title = "Real Time Streaming"
//        val myScene = Scene(p, p.prefWidth, p.prefHeight)
//        primaryStage.isResizable = false
//        primaryStage.scene = myScene
//        primaryStage.show()
    }

    override val root: Parent = vbox {
        prefHeight = 200.0
        prefWidth = 200.0
        imageView
    }

    override fun onCreate() {
        super.onCreate()
    }

    fun get_pipeline(): Pipeline? {
        return pipe
    }

}
