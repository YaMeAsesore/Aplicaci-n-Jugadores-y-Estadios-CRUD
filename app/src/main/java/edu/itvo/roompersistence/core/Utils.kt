package edu.itvo.roompersistence.core

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream

private fun getImagesDir(
    context: Context
): File {

    val imagesDir = File(
        context.filesDir,
        "images"
    )

    if (!imagesDir.exists()) {

        imagesDir.mkdirs()
    }

    return imagesDir
}

fun createImageUri(
    context: Context
): Uri {

    val imageFile = File(
        getImagesDir(context),
        "player_${System.currentTimeMillis()}.jpg"
    )

    return FileProvider.getUriForFile(
        context,
        "${context.packageName}.provider",
        imageFile
    )
}

fun copyImageToPersistentStorage(
    context: Context,
    sourceUri: Uri
): String? {

    return try {

        val inputStream = context.contentResolver.openInputStream(sourceUri)

        if (inputStream != null) {

            val outputFile = File(
                getImagesDir(context),
                "img_${System.currentTimeMillis()}.jpg"
            )

            val outputStream = FileOutputStream(outputFile)

            inputStream.copyTo(outputStream)

            inputStream.close()
            outputStream.close()

            FileProvider.getUriForFile(
                context,
                "${context.packageName}.provider",
                outputFile
            ).toString()

        } else {

            sourceUri.toString()
        }

    } catch (_: Exception) {

        sourceUri.toString()
    }
}