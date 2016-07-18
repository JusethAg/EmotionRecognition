package com.jusethag.emotionrecognition.main;

import android.graphics.Bitmap;

import com.jusethag.emotionrecognition.entities.Recognition;

/**
 * Created by JusethAg on 7/15/16.
 */

public interface MainListInteractor {
    void getListRecognitions();
    //void makeRecognition(Recognition recognition);
    void makeRecognition(Bitmap bitmap);

    void logout();
}
