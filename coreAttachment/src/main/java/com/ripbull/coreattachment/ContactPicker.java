package com.ripbull.coreattachment;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;

public class ContactPicker {

  public static final int PICK_CONTACT = 4;
  protected Activity activity;

  /*
  Can be called to choose contacts from an Activity. Called should inherit the Result interface, the caller must have READ_CONTACTS Permission
   */
  public void startChooseContactsActivity(Activity activity) {
    this.activity = activity;
    Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
    activity.startActivityForResult(i, PICK_CONTACT);
  }
}
