package com.example.demo.view.rtsp

import javafx.beans.property.SimpleObjectProperty
import javafx.beans.value.ChangeListener
import javafx.scene.image.Image

class ImageContainer {

    private val _image = SimpleObjectProperty<Image>()

    fun getImage(): Image {
        return _image.get()
    }

    fun setImage(image: Image) {
        _image.value = image
    }

    fun addListener(listener: ChangeListener<Image>) {
        _image.addListener(listener)
    }

}