package com.ripbull.ertc.attachment

import android.Manifest
import android.app.Activity
import android.content.Context

import com.google.android.libraries.places.api.model.PlaceLikelihood
import com.ripbull.coreattachment.ContactPicker
import com.ripbull.coreattachment.LocationSelector
import com.ripbull.coreattachment.MediaSelector
import com.ripbull.coreattachment.audio.AudioSelector
import com.ripbull.coreattachment.audio.Recording
import com.ripbull.coreattachment.location.ErtcLocation
import com.ripbull.coreattachment.location.LocationGooglePlayServicesProvider
import com.ripbull.ertc.R
import com.ripbull.permissions.Permissions
import io.reactivex.android.schedulers.AndroidSchedulers
import java.io.File

/**
 * Created by DK on 10/02/19.
 */
class AttachmentManager(
  activity: Activity
) {
  private val context: Context
  private val recording = Recording()


  enum class MediaType {
    IMAGE,
    GIF,
    AUDIO,
    VIDEO,
    FILE,
    GIPHY,
    STICKER
  }

  init {
    this.context = activity
  }

  fun capturePhoto(activity: Activity, file: File) {
    Permissions.with(activity).request(Manifest.permission.CAMERA).ifNecessary()
      .withPermanentDenialDialog(activity.getString(R.string.attachment_take_photos_denied))
      .onAllGranted {
        val mediaSelector = MediaSelector()
        mediaSelector.startTakePhotoActivity(activity, file)

      }.execute()
  }

  fun captureVideo(activity: Activity) {
    Permissions.with(activity).request(Manifest.permission.CAMERA).ifNecessary()
      .withPermanentDenialDialog(activity.getString(R.string.attachment_take_videos_denied))
      .onAllGranted {
        val mediaSelector = MediaSelector()
        mediaSelector.startTakeVideoActivity(activity)

      }.execute()
  }

  fun startRecordAudio(activity: Activity) {
    Permissions.with(activity).request(Manifest.permission.RECORD_AUDIO).ifNecessary()
      .withPermanentDenialDialog(activity.getString(R.string.attachment_record_audio_denied))
      .onAllGranted {
        recording.start().subscribe { }
      }.execute()
  }

  fun getPhotoImageFile(activity: Activity): File {
    var cameraImage: File? = null
    val mediaSelector = MediaSelector()
    cameraImage = mediaSelector.getPictureFile(activity)
    return cameraImage
  }

  fun getRecordedAudio(): File? {
    recording.stop()
    if (recording.durationMillis < 1000) {
      deleteRecordedAudio()
      return null
    }
    return recording.file
  }

  fun deleteRecordedAudio() {
    recording.delete()
  }

  companion object {

    fun selectGallery(activity: Activity) {
      Permissions.with(activity).request(Manifest.permission.WRITE_EXTERNAL_STORAGE).ifNecessary()
        .withPermanentDenialDialog(activity.getString(R.string.attachment_photos_videos_or_audio_denied))
        .onAllGranted {
          val mediaSelector = MediaSelector()
          mediaSelector.startChooseImageActivity(activity)
        }.execute()
    }

    fun selectVideo(activity: Activity) {
      Permissions.with(activity).request(Manifest.permission.WRITE_EXTERNAL_STORAGE).ifNecessary()
        .withPermanentDenialDialog(activity.getString(R.string.attachment_photos_videos_or_audio_denied))
        .onAllGranted {
          val mediaSelector = MediaSelector()
          mediaSelector.startChooseVideoActivity(activity)
        }.execute()
    }

    fun selectAudio(activity: Activity) {
      Permissions.with(activity).request(Manifest.permission.WRITE_EXTERNAL_STORAGE).ifNecessary()
        .withPermanentDenialDialog(activity.getString(R.string.attachment_photos_videos_or_audio_denied))
        .onAllGranted {
          val audioSelector = AudioSelector()
          audioSelector.startChooseAudioActivity(activity)
        }.execute()
    }

    fun selectContactInfo(activity: Activity) {
      Permissions.with(activity).request(Manifest.permission.READ_CONTACTS).ifNecessary()
        .withPermanentDenialDialog(activity.getString(R.string.attachment_contact_denied))
        .onAllGranted {
          val contactProvider = ContactPicker()
          contactProvider.startChooseContactsActivity(activity)
        }.execute()
    }

    private fun onLocationSyncSuccess(list: List<PlaceLikelihood>) {
      println(list)
    }

    private fun onLocationSyncFailure(throwable: Throwable) {

    }

    fun startLocation(activity: Activity) {
      val provider = LocationGooglePlayServicesProvider()
      provider.setCheckLocationSettings(false)
      val ertcLocation = ErtcLocation.Builder(activity).build()
      ertcLocation.location(provider).start {
        print("" + it.toString()) //return current location
      }
    }

    fun selectDocument(activity: Activity) {
      Permissions.with(activity).request(Manifest.permission.WRITE_EXTERNAL_STORAGE).ifNecessary()
        .withPermanentDenialDialog(activity.getString(R.string.attachment_document_denied))
        .onAllGranted {
          val mediaSelector = MediaSelector()
          mediaSelector.startChooseFileActivity(activity)
        }.execute()
    }

    const val TAKE_PHOTO = 100
    const val PICK_PHOTO = 101
    const val TAKE_VIDEO = 102
    const val PICK_VIDEO = 103
    const val PICK_AUDIO = 110
    const val RECORD_AUDIO = 111
    const val PICK_FILE = 104
    const val PICK_CONTACT = 4
    const val PICK_LOCATION = 9
    const val PICK_GIF = 10
  }

}
