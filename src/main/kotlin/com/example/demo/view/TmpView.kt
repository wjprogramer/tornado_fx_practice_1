package com.example.demo.view

import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView
import tornadofx.*
import uk.co.caprica.vlcj.component.DirectMediaPlayerComponent
import uk.co.caprica.vlcj.player.direct.BufferFormat
import uk.co.caprica.vlcj.player.direct.BufferFormatCallback

class TmpView : View("My View") {

    init {
//        val media = Media("rtsp://admin:winsonic16350755@59.120.179.81:5540/chID=1&streamType=sub&linkType=tcp")
//        val player = MediaPlayer(media)
//        mediaView = MediaView(player)
        val component = DirectMediaPlayerComponent { p0, p1 ->
            null
        }
    }

    override val root = borderpane {
    }
}
