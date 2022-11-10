package com.ripbull.ertc.contacts.avatars

import android.content.Context
import android.net.Uri
import com.bumptech.glide.load.Key
import java.io.IOException
import java.io.InputStream

interface Photo : Key {

  val isProfilePhoto: Boolean

  @Throws(IOException::class) fun openInputStream(context: Context): InputStream

  fun getUri(context: Context): Uri?

}
