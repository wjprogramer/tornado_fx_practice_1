package com.example.demo.view

import javafx.scene.control.Button
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import tornadofx.*

// 解釋用的 View，不是好的寫法

class HowBuildersWorkView : View("My View") {
    override val root = VBox()

    init {
        /** 1. */
//        with(root) {
//            this += Button("Press Me")
//
//            button("Press Me") {
//                textFill = Color.RED
//                action { println("Button pressed!") }
//            }
//        }

        /** 2. */
        root.apply {
            this += Button("Press Me")

            this += Button("Press Me").apply {
                textFill = Color.RED
                action { println("Button pressed!") }
            }
        }
    }

}
