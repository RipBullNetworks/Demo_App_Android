package com.ripbull.coreattachment.compressor.image.constraint

import android.graphics.BitmapFactory
import com.ripbull.coreattachment.compressor.calculateInSampleSize
import com.ripbull.coreattachment.compressor.decodeSampledBitmapFromFile
import com.ripbull.coreattachment.compressor.determineImageRotation
import com.ripbull.coreattachment.compressor.overWrite
import java.io.File

class ResolutionConstraint(private val width: Int, private val height: Int) : Constraint {

  override fun isSatisfied(imageFile: File): Boolean {
    return BitmapFactory.Options().run {
      inJustDecodeBounds = true
      BitmapFactory.decodeFile(imageFile.absolutePath, this)
      calculateInSampleSize(this, width, height) <= 1
    }
  }

  override fun satisfy(imageFile: File): File {
    return decodeSampledBitmapFromFile(imageFile, width, height).run {
      determineImageRotation(imageFile, this).run {
        overWrite(imageFile, this)
      }
    }
  }
}

fun Compression.resolution(width: Int, height: Int) {
  constraint(ResolutionConstraint(width, height))
}