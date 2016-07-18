package com.jusethag.emotionrecognition.main;

import android.graphics.Bitmap;

import com.jusethag.emotionrecognition.entities.Recognition;
import com.jusethag.emotionrecognition.lib.base.EventBus;
import com.jusethag.emotionrecognition.main.events.MainListEvent;
import com.jusethag.emotionrecognition.main.ui.MainListView;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by JusethAg on 7/15/16.
 */

public class MainListPresenterImpl implements MainListPresenter {

    private EventBus eventBus;
    private MainListView mainListView;
    private MainListInteractor mainListInteractor;

    public MainListPresenterImpl(EventBus eventBus, MainListView mainListView, MainListInteractor mainListInteractor) {
        this.eventBus = eventBus;
        this.mainListView = mainListView;
        this.mainListInteractor = mainListInteractor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        this.mainListView = null;
    }

    @Override
    public void getListRecognitions() {
        mainListInteractor.getListRecognitions();
    }

    @Override
    public void logout() {
        mainListInteractor.logout();
    }

    /*@Override
    public void recognizeEmotion(Recognition recognition) {
        mainListInteractor.makeRecognition(recognition);
    }*/

    public void recognizeEmotion(Bitmap bitmap) {
        mainListInteractor.makeRecognition(bitmap);
    }

    @Override
    @Subscribe
    public void onEventMainThread(MainListEvent mainListEvent) {
        if (this.mainListView != null) {
            switch (mainListEvent.getType()) {
                case MainListEvent.READ_EVENT:
                    mainListView.showList();
                    break;
            }
        }
    }

    @Override
    public MainListView getView() {
        return this.mainListView;
    }
}
