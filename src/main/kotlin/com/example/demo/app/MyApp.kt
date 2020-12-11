package com.example.demo.app

import com.example.demo.view.MainView
import com.sun.jna.NativeLibrary
import javafx.stage.Stage
import tornadofx.App
import tornadofx.launch
import uk.co.caprica.vlcj.factory.MediaPlayerFactory

/**
 * 如果不需要傳入 args，可以註解 `fun main` 以及 `launch`
 * 只需要 T extends App 即可
 * */
fun main(args: Array<String>) {
    NativeLibrary.addSearchPath("libvlc", "C:/Program Files/VideoLAN/VLC")

    launch<MyApp>(args)
}

class MyApp: App(MainView::class, Styles::class) {

    // Global Variables
    companion object {
        val mediaPlayerFactory: MediaPlayerFactory = MediaPlayerFactory()
    }

    override fun start(stage: Stage) {
        super.start(stage)
    }

    override fun stop() {
        mediaPlayerFactory.release()
        super.stop()
    }
}