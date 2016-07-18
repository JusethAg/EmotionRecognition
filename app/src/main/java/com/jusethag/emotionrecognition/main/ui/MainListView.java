package com.jusethag.emotionrecognition.main.ui;

import com.jusethag.emotionrecognition.entities.Recognition;

/**
 * Created by JusethAg on 7/15/16.
 */

public interface MainListView {
    void showList();
    void hideList();

    void showProgress();
    void hideProgress();

    void onGetPictureError(String error);
}
