package com.example.demo.view

import com.example.demo.app.Styles
import javafx.scene.Parent
import tornadofx.*

class BottomView: View() {
    override val root = hbox {
        label(title) {
            addClass(Styles.heading)
        }
        button("Press me")
        label("Waiting")
    }
}