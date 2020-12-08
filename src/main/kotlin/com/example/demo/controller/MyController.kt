package com.example.demo.controller

import javafx.collections.FXCollections
import tornadofx.Controller

class MyController: Controller() {

    val values = FXCollections.observableArrayList("Alpha","Beta","Gamma","Delta")

    fun writeToDb(inputValue: String) {
        println("Writing $inputValue to database!")
    }
}