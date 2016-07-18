package com.jusethag.emotionrecognition.domain.di;

import com.firebase.client.Firebase;
import com.jusethag.emotionrecognition.domain.FirebaseAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JusethAg on 7/13/16.
 */
@Module
public class DomainModule {
    private final static String FIREBASE_URL = "URL_FIREBASE";

    @Provides
    @Singleton
    FirebaseAPI providesFirebaseAPI(Firebase firebase){
        return new FirebaseAPI(firebase);
    }

    @Provides
    @Singleton
    Firebase providesFirebase() {
        return new Firebase(FIREBASE_URL);
    }

}
