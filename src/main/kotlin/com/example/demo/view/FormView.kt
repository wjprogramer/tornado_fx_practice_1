package com.example.demo.view

import com.example.demo.controller.MyController
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class FormView: View() {

    private val controller: MyController by inject()
    private val input = SimpleStringProperty()

    init {
        input.value = "Hi"
    }

    override val root = form {
        fieldset {
            field("Input") {
                textfield(input)
            }

            label("My items")
            listview(controller.values)

            button("Commit") {
                action {
                    controller.writeToDb(input.value)
                    input.value = ""
                }
            }
        }
    }
}