package com.example.demo.app

import com.example.demo.view.MainView
import tornadofx.App

/** 如果需要帶入 args 的話... */
//fun main(args: Array<String>) {
//    launch<MyApp>(args)
//}

class MyApp: App(MainView::class, Styles::class)