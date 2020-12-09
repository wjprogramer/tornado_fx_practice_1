package com.example.demo.view

import javafx.scene.media.AudioClip
import tornadofx.*

class View1 : View("My View") {

    init {
        // `View` has a property called `primaryStage`
        // that allows you to manipulate properties of the Stage backing it,
        primaryStage
    }

    override val root = borderpane {

    }
}
