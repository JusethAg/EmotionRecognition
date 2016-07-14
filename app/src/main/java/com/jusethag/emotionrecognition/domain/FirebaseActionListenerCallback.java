package com.jusethag.emotionrecognition.domain;

import com.firebase.client.FirebaseError;

/**
 * Created by JusethAg on 7/13/16.
 */
public interface FirebaseActionListenerCallback {
    void onSuccess();
    void onError(FirebaseError error);
}
