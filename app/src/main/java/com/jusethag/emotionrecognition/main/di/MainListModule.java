package com.jusethag.emotionrecognition.main.di;

import com.firebase.client.Firebase;
import com.jusethag.emotionrecognition.domain.FirebaseAPI;
import com.jusethag.emotionrecognition.entities.Recognition;
import com.jusethag.emotionrecognition.lib.base.EmotionService;
import com.jusethag.emotionrecognition.lib.base.EventBus;
import com.jusethag.emotionrecognition.main.MainListInteractor;
import com.jusethag.emotionrecognition.main.MainListInteractorImpl;
import com.jusethag.emotionrecognition.main.MainListPresenter;
import com.jusethag.emotionrecognition.main.MainListPresenterImpl;
import com.jusethag.emotionrecognition.main.MainListRepository;
import com.jusethag.emotionrecognition.main.MainListRepositoryImpl;
import com.jusethag.emotionrecognition.main.ui.MainListView;
import com.jusethag.emotionrecognition.main.ui.adapters.MainListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JusethAg on 7/15/16.
 */

@Module
public class MainListModule {
    MainListView mainListView;

    public MainListModule(MainListView mainListView) {
        this.mainListView = mainListView;
    }

    @Provides
    @Singleton
    MainListView providesMainView() {
        return this.mainListView;
    }

    @Provides
    @Singleton
    MainListPresenter providesMainPresenter(EventBus eventBus, MainListView mainListView, MainListInteractor mainListInteractor){
        return new MainListPresenterImpl(eventBus, mainListView, mainListInteractor);
    }

    @Provides
    @Singleton
    MainListInteractor providesMainInteractor(MainListRepository mainListRepository){
        return new MainListInteractorImpl(mainListRepository);
    }

    @Provides
    @Singleton
    MainListRepository providesMainRepository(EventBus eventBus, FirebaseAPI firebaseAPI,
                                              EmotionService emotionService){
        return new MainListRepositoryImpl(eventBus, firebaseAPI, emotionService);
    }

    @Provides
    @Singleton
    MainListAdapter providesMainListAdapter(List<Recognition> recognitions){
        return new MainListAdapter(recognitions);
    }

    @Provides
    @Singleton
    List<Recognition> providesRecognitionList() {
        return new ArrayList<Recognition>();
    }
}
