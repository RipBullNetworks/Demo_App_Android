package com.ripbull.coreattachment.compressor.image.constraint

import android.graphics.Bitmap
import com.ripbull.coreattachment.compressor.compressFormat
import com.ripbull.coreattachment.compressor.loadBitmap
import com.ripbull.coreattachment.compressor.overWrite
import java.io.File

class FormatConstraint(private val format: Bitmap.CompressFormat) : Constraint {

  override fun isSatisfied(imageFile: File): Boolean {
    return format == imageFile.compressFormat()
  }

  override fun satisfy(imageFile: File): File {
    return overWrite(imageFile, loadBitmap(imageFile), format)
  }
}

fun Compression.format(format: Bitmap.CompressFormat) {
  constraint(FormatConstraint(format))
}