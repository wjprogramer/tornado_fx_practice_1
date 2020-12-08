package com.example.demo.view

import com.example.demo.app.Styles
import tornadofx.*

class MainView : View("Hello TornadoFX") {

    // Explicitly retrieve TopView
    private val middleView1 = find(MiddleView1::class)
    // Create a lazy reference to BottomView
    private val middleView2: MiddleView2 by inject()

    override val root = borderpane  {
        top<TopView>()
        middleView1.root
        middleView2.root
        bottom<BottomView>()
    }
}