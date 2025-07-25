package com.jd.textrecognition

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.annotation.NonNull
import com.facebook.react.bridge.*
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizer
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import java.io.IOException
import java.io.InputStream

class TextRecognitionModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    override fun getName(): String = "TextRecognitionModule"

    @ReactMethod
    fun recognize(url: String, promise: Promise) {
        try {
            val uri = Uri.parse(url)
            val inputStream = reactApplicationContext.contentResolver.openInputStream(uri)
            val bitmap = BitmapFactory.decodeStream(inputStream)

            if (bitmap == null) {
                promise.reject("E_IMAGE_NULL", "Bitmap could not be decoded from the provided URL.")
                return
            }

            val image = InputImage.fromBitmap(bitmap, 0)
            val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

            recognizer.process(image)
                .addOnSuccessListener { visionText ->
                    try {
                        val resultMap = Arguments.createMap()
                        resultMap.putString("text", visionText.text)
                        
                        val blocksArray = Arguments.createArray()
                        
                        for (block in visionText.textBlocks) {
                            val blockMap = Arguments.createMap()
                            blockMap.putString("text", block.text)
                            
                            val frameMap = Arguments.createMap()
                            block.boundingBox?.let {
                                frameMap.putInt("left", it.left)
                                frameMap.putInt("top", it.top)
                                frameMap.putInt("width", it.width())
                                frameMap.putInt("height", it.height())
                            }
                            blockMap.putMap("frame", frameMap)
                            
                            val linesArray = Arguments.createArray()
                            for (line in block.lines) {
                                val lineMap = Arguments.createMap()
                                lineMap.putString("text", line.text)
                                linesArray.pushMap(lineMap)
                            }
                            blockMap.putArray("lines", linesArray)
                            
                            blocksArray.pushMap(blockMap)
                        }
                        
                        resultMap.putArray("blocks", blocksArray)
                        promise.resolve(resultMap)
                    } catch (e: Exception) {
                        promise.reject("E_PROCESSING", "Error processing results", e)
                    }
                }
                .addOnFailureListener { e ->
                    promise.reject("E_TEXT_RECOGNITION", "Recognition failed", e)
                }
        } catch (e: Exception) {
            promise.reject("E_UNKNOWN", "Failed to process image", e)
        }
    }
}