package com.ripbull.coreattachment.audio;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;

public class AudioSelector {

  private static final int CHOOSE_AUDIO = 110;

  public void startChooseAudioActivity(Activity activity) {
    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
    activity.startActivityForResult(intent, CHOOSE_AUDIO);
  }
}
