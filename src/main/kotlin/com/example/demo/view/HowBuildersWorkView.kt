package com.example.demo.view

import javafx.scene.control.Button
import javafx.scene.layout.VBox
import tornadofx.*

// 解釋用的 View，不是好的寫法

class HowBuildersWorkView : View("My View") {
    override val root = VBox()

    init {
        with(root) {
            this += Button("Press Me")
        }
    }

}
