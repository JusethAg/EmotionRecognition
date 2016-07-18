package com.jusethag.emotionrecognition.main;

import android.graphics.Bitmap;

import com.jusethag.emotionrecognition.entities.Recognition;

/**
 * Created by JusethAg on 7/15/16.
 */

public class MainListInteractorImpl implements MainListInteractor {
    private MainListRepository mainListRepository;

    public MainListInteractorImpl(MainListRepository mainListRepository) {
        this.mainListRepository = mainListRepository;
    }

    @Override
    public void getListRecognitions() {
        mainListRepository.getSavedRecognitions();
    }

    /*@Override
    public void makeRecognition(Recognition recognition) {
        mainListRepository.makeRecognizePhoto(recognition);
    }*/

    public void makeRecognition(Bitmap bitmap) {
        mainListRepository.makeRecognizePhoto(bitmap);
    }


    @Override
    public void logout() {
        mainListRepository.logout();
    }
}
