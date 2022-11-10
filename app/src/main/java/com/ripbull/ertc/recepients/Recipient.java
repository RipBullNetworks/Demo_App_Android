package com.ripbull.ertc.recepients;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ripbull.ertc.R;
import com.ripbull.ertc.contacts.MaterialColor;
import com.ripbull.ertc.contacts.avatars.UserColors;
import com.ripbull.ertc.contacts.avatars.Photo;
import com.ripbull.ertc.contacts.avatars.FallbackPhoto;
import com.ripbull.ertc.contacts.avatars.GeneratedPhoto;
import com.ripbull.ertc.contacts.avatars.ProfilePhoto;
import com.ripbull.ertc.contacts.avatars.ResourcePhoto;

/**
 * Created by DK on 31/01/19.
 */
public class Recipient implements RecipientModifiedListener {

  private String name;
  private MaterialColor color;
  private @Nullable String profileAvatar;
  //private final @NonNull Address address;

  public Recipient(String name, MaterialColor color,
      @Nullable
          String profileAvatar) {
    this.name = name;
    this.color = color;
    this.profileAvatar = profileAvatar;
    //this.address = address;
  }

  public synchronized @NonNull Drawable getFallbackContactPhotoDrawable(Context context, boolean inverted) {
    return getFallbackContactPhoto().asDrawable(context, UserColors.INSTANCE.generateFor(name).toAvatarColor(context),
        inverted);
  }

  public synchronized @NonNull
  FallbackPhoto getFallbackContactPhoto() {
    if (isGroupRecipient()) {
      return new ResourcePhoto(R.drawable.ic_group_white_24dp, R.drawable.ic_group_large);
    } else if (!TextUtils.isEmpty(name)) {
      return new GeneratedPhoto(name, R.drawable.ic_person_default_24dp);
    } else {
      return new ResourcePhoto(R.drawable.ic_person_default_24dp, R.drawable.ic_person_large);
    }
  }

  public synchronized @Nullable
  Photo getContactPhoto() {
    if (profileAvatar != null) {
      return new ProfilePhoto(null, profileAvatar);
    } else {
      return null;
    }
  }

  public boolean isGroupRecipient() {
    return false;
  }

  public synchronized @NonNull
  MaterialColor getColor() {
    if (isGroupRecipient()) {
      return MaterialColor.GROUP;
    } else if (color != null) {
      return color;
    } else if (name != null) {
      return UserColors.INSTANCE.generateFor(name);
    } else {
      return UserColors.INSTANCE.getUNKNOWN_COLOR();
    }
  }

  @Override
  public void onModified(Recipient recipient) {

  }


}
