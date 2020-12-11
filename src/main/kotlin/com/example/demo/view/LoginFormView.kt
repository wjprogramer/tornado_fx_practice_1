package com.example.demo.view

import javafx.scene.control.TextField
import tornadofx.*

class LoginFormView : View("My View") {

    var firstNameField: TextField by singleAssign()
    var lastNameField: TextField by singleAssign()

    override val root = vbox {
        hbox {
            label("First Name")
            firstNameField = textfield()
        }
        hbox {
            label("Last Name")
            lastNameField = textfield()
        }
        button("LOGIN") {
            // The `useMaxWidth` is an extended property for `Node`,
            // and it sets the Node to occupy the maximum width allowed
            useMaxWidth = true
            action {
                println("Logging in as ${firstNameField.text} ${lastNameField.text}")
            }
        }
    }
}
