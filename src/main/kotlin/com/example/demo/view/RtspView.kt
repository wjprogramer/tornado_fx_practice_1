package com.example.demo.view

import com.example.demo.core.MyPlayer
import com.example.demo.core.OnMyPlayerStop
import javafx.beans.value.ObservableValue
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.paint.Color
import tornadofx.*
import java.util.concurrent.TimeUnit

class RtspView : View("RTSP") {

    private val videoImageView: ImageView = ImageView("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2GwqBXHprkAUZymp3GfRWrISki8wX47wTpg&usqp=CAU")

    private var myPlayer: MyPlayer? = null

    override val root = vbox {
        this += videoImageView
        button("Back Home") {
            action {
                replaceWith(HomeView::class)
            }
        }
        imageview {
            image = Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2GwqBXHprkAUZymp3GfRWrISki8wX47wTpg&usqp=CAU", 200.0, 200.0, false, true)
        }
    }

    override fun onDock() {
        super.onDock()
        println("[RTSP View] onDock")

        videoImageView.fitWidthProperty().bind(root.widthProperty())
        videoImageView.fitHeightProperty().bind(root.heightProperty())
        videoImageView.isPreserveRatio = true

        root.widthProperty()
            .addListener { observableValue: ObservableValue<out Number?>?, oldValue: Number?, newValue: Number? -> }

        root.heightProperty()
            .addListener { observableValue: ObservableValue<out Number?>?, oldValue: Number?, newValue: Number? -> }

        updatePlayer()
    }

    override fun onUndock() {
        println("[RTSP View] onUndock")
        dispose()
        super.onUndock()
    }

    private fun updatePlayer() {
        if (myPlayer == null)
            myPlayer = MyPlayer(object: OnMyPlayerStop {
                override fun onPlayerStop() {
                    println("onPlayerStop!!")
//                    dispose()
//                    updatePlayer()
                }
            })

//        myPlayer?.init(this.videoImageView)
        myPlayer?.play()

    }

    private fun dispose() {
        myPlayer?.stop()
        myPlayer?.dispose()
        myPlayer = null
    }

}