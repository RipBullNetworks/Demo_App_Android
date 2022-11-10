package com.ripbull.ertc.contacts.avatars

import android.content.Context
import com.ripbull.ertc.contacts.Address
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream

object AvatarHelper {

  private const val AVATAR_DIRECTORY = "avatars"

  @Throws(IOException::class)
  fun getInputStreamFor(
    context: Context, address: Address
  ): InputStream {
    return FileInputStream(getAvatarFile(context, address))
  }

  private fun delete(
    context: Context, address: Address
  ) {
    getAvatarFile(context, address).delete()
  }

  fun getAvatarFile(
    context: Context, address: Address
  ): File {
    val avatarDirectory = File(context.filesDir, AVATAR_DIRECTORY)
    avatarDirectory.mkdirs()

    return File(avatarDirectory, File(address.serialize()).name)
  }

  @Throws(IOException::class)
  fun setAvatar(
    context: Context, address: Address, data: ByteArray?
  ) {
    if (data == null) {
      delete(context, address)
    } else {
      val out = FileOutputStream(getAvatarFile(context, address))
      out.write(data)
      out.close()
    }
  }
}