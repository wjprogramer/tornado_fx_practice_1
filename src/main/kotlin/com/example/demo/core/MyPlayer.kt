package com.example.demo.core

import com.example.demo.app.MyApp
import javafx.animation.Animation
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.event.ActionEvent
import javafx.scene.image.ImageView
import javafx.util.Duration
import uk.co.caprica.vlcj.factory.MediaPlayerFactory
import uk.co.caprica.vlcj.javafx.videosurface.ImageViewVideoSurfaceFactory
import uk.co.caprica.vlcj.media.MediaRef
import uk.co.caprica.vlcj.media.TrackType
import uk.co.caprica.vlcj.player.base.MediaPlayer
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter
import uk.co.caprica.vlcj.player.base.MediaPlayerEventListener
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer

class MyPlayer(private var onMyPlayerStop: OnMyPlayerStop): MediaPlayerEventListener {

    private var mediaPlayerFactory: MediaPlayerFactory = MyApp.mediaPlayerFactory
    private var embeddedMediaPlayer: EmbeddedMediaPlayer = mediaPlayerFactory.mediaPlayers().newEmbeddedMediaPlayer()

    private var timeLine: Timeline

    init {
        timeLine = Timeline(
            KeyFrame(Duration.seconds(10.0),
                { ev: ActionEvent? ->
                    onMyPlayerStop.onPlayerStop()
                })
        )
        timeLine.cycleCount = Animation.INDEFINITE
        timeLine.play()
        embeddedMediaPlayer.events().addMediaPlayerEventListener(this)
//        embeddedMediaPlayer.events().addMediaPlayerEventListener(object : MediaPlayerEventAdapter() {
//            override fun timeChanged(mediaPlayer: MediaPlayer, newTime: Long) {
//            }
//        })
    }

    fun init(imageView: ImageView) {
        embeddedMediaPlayer.videoSurface().set(ImageViewVideoSurfaceFactory.videoSurfaceForImageView(imageView))
    }

    fun play() {
        embeddedMediaPlayer.media()
            .play("rtsp://admin:winsonic16350755@59.120.179.81:5540/chID=1&streamType=sub&linkType=tcp")
        embeddedMediaPlayer
            .controls().setPosition(0.4f)
    }

    fun stop() {
        embeddedMediaPlayer.controls().stop()
    }

    fun dispose() {
        timeLine.stop()
        embeddedMediaPlayer.release()
        embeddedMediaPlayer.events().removeMediaPlayerEventListener(this)
    }

    override fun mediaChanged(p0: MediaPlayer?, p1: MediaRef?) {}

    override fun opening(p0: MediaPlayer?) {}

    override fun buffering(p0: MediaPlayer?, p1: Float) {}

    override fun playing(p0: MediaPlayer?) {}

    override fun paused(p0: MediaPlayer?) {}

    override fun stopped(p0: MediaPlayer?) {}

    override fun forward(p0: MediaPlayer?) {}

    override fun backward(p0: MediaPlayer?) {}

    override fun finished(p0: MediaPlayer?) {}

    override fun timeChanged(p0: MediaPlayer?, p1: Long) {
        timeLine.stop()
        timeLine = Timeline(
            KeyFrame(Duration.seconds(3.0),
                { ev: ActionEvent? ->
                    onMyPlayerStop.onPlayerStop()
                })
        )
        timeLine.play()
    }

    override fun positionChanged(p0: MediaPlayer?, p1: Float) {}

    override fun seekableChanged(p0: MediaPlayer?, p1: Int) {}

    override fun pausableChanged(p0: MediaPlayer?, p1: Int) {}

    override fun titleChanged(p0: MediaPlayer?, p1: Int) {}

    override fun snapshotTaken(p0: MediaPlayer?, p1: String?) {}

    override fun lengthChanged(p0: MediaPlayer?, p1: Long) {}

    override fun videoOutput(p0: MediaPlayer?, p1: Int) {}

    override fun scrambledChanged(p0: MediaPlayer?, p1: Int) {}

    override fun elementaryStreamAdded(p0: MediaPlayer?, p1: TrackType?, p2: Int) {}

    override fun elementaryStreamDeleted(p0: MediaPlayer?, p1: TrackType?, p2: Int) {}

    override fun elementaryStreamSelected(p0: MediaPlayer?, p1: TrackType?, p2: Int) {}

    override fun corked(p0: MediaPlayer?, p1: Boolean) {}

    override fun muted(p0: MediaPlayer?, p1: Boolean) {}

    override fun volumeChanged(p0: MediaPlayer?, p1: Float) {}

    override fun audioDeviceChanged(p0: MediaPlayer?, p1: String?) {}

    override fun chapterChanged(p0: MediaPlayer?, p1: Int) {}

    override fun error(p0: MediaPlayer?) {
        println("[MyPlayer] error")
    }

    override fun mediaPlayerReady(p0: MediaPlayer?) {}

}