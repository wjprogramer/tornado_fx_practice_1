package com.example.demo.view

import tornadofx.*

class HomeView : View("Home View") {
    override val root = vbox {
        label("HomeView")
    }

    // View 的 root 與 Parent connected 的時候
    override fun onDock() {
        super.onDock()
        println("Docking HomeView!")
    }

    // ... disconnected ...
    override fun onUndock() {
        super.onUndock()
        println("Undocking HomeView!")
    }
}
