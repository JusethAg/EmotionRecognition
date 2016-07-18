package com.jusethag.emotionrecognition.main;

import android.graphics.Bitmap;

import com.jusethag.emotionrecognition.lib.base.EventBus;
import com.jusethag.emotionrecognition.main.events.MainListEvent;
import com.jusethag.emotionrecognition.main.events.MainRecognizeEvent;
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



    public void recognizeEmotion(Bitmap bitmap) {
        mainListInteractor.makeRecognition(bitmap);
    }

    @Override
    @Subscribe
    public void onEventMainListThread(MainListEvent mainListEvent) {
        if (this.mainListView != null) {
            switch (mainListEvent.getType()) {
                case MainListEvent.READ_LIST_EVENT_SUCCESS:
                    mainListView.showList();
                    break;
            }
        }
    }

    @Override
    @Subscribe
    public void onEventMainRecognizeThread(MainRecognizeEvent mainRecognizeEvent) {
        String error = mainRecognizeEvent.getError();

        if (this.mainListView != null) {
            switch (mainRecognizeEvent.getType()) {
                case MainRecognizeEvent.RECOGNIZE_INIT:
                    mainListView.onMakeRecognitionInit();
                    break;
                case MainRecognizeEvent.RECOGNIZE_COMPLETED:
                    mainListView.onMakeRecognitionCompleted();
                    break;
                case MainRecognizeEvent.RECOGNIZE_ERROR:
                    mainListView.onMakeRecognitionError(error);
                    break;
            }
        }
    }

    @Override
    public MainListView getView() {
        return this.mainListView;
    }
}
