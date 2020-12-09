package com.example.demo.view.rtsp

import java.nio.ByteBuffer;

import org.freedesktop.gstreamer.Buffer;
import org.freedesktop.gstreamer.FlowReturn;
import org.freedesktop.gstreamer.Sample;
import org.freedesktop.gstreamer.Structure;
import org.freedesktop.gstreamer.elements.AppSink;

import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

class RtspSinkListener: AppSink.NEW_SAMPLE {

    private var lastWidth = 0
    private var lastHeight = 0

    var imageContainer = ImageContainer()
        private set

    override fun newSample(appSink: AppSink?): FlowReturn {
        // Try to get a sample
        if (appSink == null) {
            return FlowReturn.ERROR
        }

        val sample = appSink.pullSample()
        val buffer = sample.buffer
        val byteBuffer = buffer.map(false)
        var byteArray = ByteArray(0)
        if (byteBuffer != null) {
            val capsStruct = sample.caps.getStructure(0)
            val width = capsStruct.getInteger("width")
            val height = capsStruct.getInteger("height")
            if (width != lastWidth || height != lastHeight) {
                lastWidth = width
                lastHeight = height
                byteArray = ByteArray(width * height * 4)
            }
            byteBuffer.get(byteArray)
            val actualFrame = convertBytesToImage(byteArray, width, height)
            imageContainer.setImage(actualFrame)
            buffer.unmap()
        }
        sample.dispose()
        return FlowReturn.OK
    }

    private fun convertBytesToImage(pixels: ByteArray, width: Int, height: Int): Image {
        val img = WritableImage(width, height)
        val pw = img.pixelWriter
        pw.setPixels(0, 0, width, height, PixelFormat.getByteBgraInstance(), pixels, 0, width * 4)
        return img
    }

}