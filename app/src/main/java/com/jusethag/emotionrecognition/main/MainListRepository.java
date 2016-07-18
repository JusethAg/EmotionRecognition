package com.jusethag.emotionrecognition.main;

import android.graphics.Bitmap;

import com.jusethag.emotionrecognition.entities.Recognition;

/**
 * Created by JusethAg on 7/15/16.
 */

public interface MainListRepository {
    void getSavedRecognitions();
    //void makeRecognizePhoto(Recognition recognition);
    void makeRecognizePhoto(Bitmap bitmap);

    void logout();
}
