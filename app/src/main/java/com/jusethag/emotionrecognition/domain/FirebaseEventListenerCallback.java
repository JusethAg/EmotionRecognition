package com.jusethag.emotionrecognition.domain;

import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;

/**
 * Created by JusethAg on 7/13/16.
 */
public interface FirebaseEventListenerCallback {
    void onChildAdded(DataSnapshot dataSnapshot);
    void onChildRemoved(DataSnapshot dataSnapshot);
    void onCancelled(FirebaseError error);
}
