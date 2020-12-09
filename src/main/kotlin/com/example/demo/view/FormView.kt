package com.example.demo.view

import com.example.demo.controller.MyController
import com.example.demo.fragment.MyFragment
import javafx.beans.property.SimpleStringProperty
import javafx.stage.StageStyle
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

            button("Commit") {
                action {
                    // 其他: runAsyncWithProgress
                    runAsync {
                        controller.writeToDb(input.value)
                    } ui { msg ->
                        input.value = msg
                    }
                }
            }

            button("Open Modal") {
                action {
                    find<MyFragment>().openModal(stageStyle = StageStyle.UTILITY)
                }
            }
        }
    }
}