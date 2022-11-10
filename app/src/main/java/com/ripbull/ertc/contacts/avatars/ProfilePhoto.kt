package com.ripbull.ertc.contacts.avatars

import android.content.Context
import android.net.Uri
import com.ripbull.ertc.contacts.Address
import java.io.IOException
import java.io.InputStream
import java.security.MessageDigest

class ProfilePhoto(
  private val address: Address,
  private val avatarObject: String
) : Photo {

  override val isProfilePhoto: Boolean
    get() = true

  @Throws(IOException::class) override fun openInputStream(context: Context): InputStream {
    return AvatarHelper.getInputStreamFor(context, address)
  }

  override fun getUri(context: Context): Uri? {
    return Uri.fromFile(AvatarHelper.getAvatarFile(context, address))
  }

  override fun updateDiskCacheKey(messageDigest: MessageDigest) {
    messageDigest.update(address.serialize().toByteArray())
    messageDigest.update(avatarObject.toByteArray())
  }

  override fun equals(other: Any?): Boolean {
    if (other == null || other !is ProfilePhoto) return false

    val that = other as ProfilePhoto?

    return this.address == that!!.address && this.avatarObject == that.avatarObject
  }

  override fun hashCode(): Int {
    return address.hashCode() xor avatarObject.hashCode()
  }
}
