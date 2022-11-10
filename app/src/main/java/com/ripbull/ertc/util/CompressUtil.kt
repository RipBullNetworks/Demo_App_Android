package com.ripbull.ertc.util

import android.app.Application
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class CompressUtil {

  companion object {

    @Suppress("DEPRECATION")
    fun saveVideoFile(filePath: String?, context: Context, application: Application): File? {
      filePath?.let {
        val videoFile = File(filePath)
        val videoFileName = "${System.currentTimeMillis()}_${videoFile.name}"
        val folderName = Environment.DIRECTORY_MOVIES
        if (Build.VERSION.SDK_INT >= 30) {

          val values = ContentValues().apply {

            put(
              MediaStore.Images.Media.DISPLAY_NAME,
              videoFileName
            )
            put(MediaStore.Images.Media.MIME_TYPE, "video/mp4")
            put(MediaStore.Images.Media.RELATIVE_PATH, folderName)
            put(MediaStore.Images.Media.IS_PENDING, 1)
          }

          val collection =
            MediaStore.Video.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)

          val fileUri = context.contentResolver.insert(collection, values)

          fileUri?.let {
            application.contentResolver.openFileDescriptor(fileUri, "rw")
              .use { descriptor ->
                descriptor?.let {
                  FileOutputStream(descriptor.fileDescriptor).use { out ->
                    FileInputStream(videoFile).use { inputStream ->
                      val buf = ByteArray(4096)
                      while (true) {
                        val sz = inputStream.read(buf)
                        if (sz <= 0) break
                        out.write(buf, 0, sz)
                      }
                    }
                  }
                }
              }

            values.clear()
            values.put(MediaStore.Video.Media.IS_PENDING, 0)
            context.contentResolver.update(fileUri, values, null, null)

            return File(getMediaPath(context, fileUri))
          }
        } else {
          val downloadsPath =
            context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
          val desFile = File(downloadsPath, videoFileName)

          if (desFile.exists())
            desFile.delete()

          try {
            desFile.createNewFile()
          } catch (e: IOException) {
            e.printStackTrace()
          }

          return desFile
        }
      }
      return null
    }

    fun getMediaPath(context: Context, uri: Uri): String {

      val resolver = context.contentResolver
      val projection = arrayOf(MediaStore.Video.Media.DATA)
      var cursor: Cursor? = null
      try {
        cursor = resolver.query(uri, projection, null, null, null)
        return if (cursor != null) {
          val columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA)
          cursor.moveToFirst()
          cursor.getString(columnIndex)

        } else ""

      } catch (e: Exception) {
        resolver.let {
          val filePath = (context.applicationInfo.dataDir + File.separator
              + System.currentTimeMillis())
          val file = File(filePath)

          resolver.openInputStream(uri)?.use { inputStream ->
            FileOutputStream(file).use { outputStream ->
              val buf = ByteArray(4096)
              var len: Int
              while (inputStream.read(buf).also { len = it } > 0) outputStream.write(
                buf,
                0,
                len
              )
            }
          }
          return file.absolutePath
        }
      } finally {
        cursor?.close()
      }
    }
  }
}