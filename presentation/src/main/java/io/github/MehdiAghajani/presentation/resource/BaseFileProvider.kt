package io.github.MehdiAghajani.presentation.resource

import android.graphics.Bitmap
import android.net.Uri
import java.io.File
import java.io.InputStream

interface BaseFileProvider
{
    fun makeShareCacheDirectory() : File

    fun makeCacheFile(fileName: String): File

    fun writeBitmapToFile(parent: File, bitmap: Bitmap, fileName: String) : File

    fun getByteArrayFromInputStream(inputStream: InputStream): ByteArray

    fun getUriForFile(authority: String, file: File): Uri

    fun getByteArrayFromFile(file: File): ByteArray

    fun writeInputStreamToFile(fileName: String, inputStream: InputStream): File

    fun writeByteArrayToFile(fileName: String, byteArray: ByteArray): File
}