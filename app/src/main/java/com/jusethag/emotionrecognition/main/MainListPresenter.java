package com.jusethag.emotionrecognition.main;

import android.graphics.Bitmap;

import com.jusethag.emotionrecognition.entities.Recognition;
import com.jusethag.emotionrecognition.main.events.MainListEvent;
import com.jusethag.emotionrecognition.main.ui.MainListView;

/**
 * Created by JusethAg on 7/15/16.
 */

public interface MainListPresenter {
    void onCreate();
    void onDestroy();

    void getListRecognitions();

    void logout();
    //void recognizeEmotion(Recognition recognition);
    void recognizeEmotion(Bitmap bitmap);


    void onEventMainThread(MainListEvent mainListEvent);

    MainListView getView();


}
