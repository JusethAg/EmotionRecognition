package com.jusethag.emotionrecognition.main;

import android.graphics.Bitmap;
import android.util.Log;


import com.jusethag.emotionrecognition.entities.FeelingScores;
import com.jusethag.emotionrecognition.lib.base.EmotionService;
import com.jusethag.emotionrecognition.lib.base.EmotionServiceFinishedListener;
import com.microsoft.projectoxford.emotion.EmotionServiceClient;



import com.jusethag.emotionrecognition.domain.FirebaseAPI;
import com.jusethag.emotionrecognition.entities.Recognition;
import com.jusethag.emotionrecognition.lib.base.EventBus;
import com.jusethag.emotionrecognition.main.events.MainListEvent;
import com.raizlabs.android.dbflow.list.FlowCursorList;
import com.raizlabs.android.dbflow.sql.language.SQLite;


import java.util.List;

/**
 * Created by JusethAg on 7/15/16.
 */

public class MainListRepositoryImpl implements MainListRepository {

    private EventBus eventBus;
    private FirebaseAPI firebaseAPI;
    private EmotionService emotionService;

    private EmotionServiceClient client;
    private Bitmap mBitmap;

    public MainListRepositoryImpl(EventBus eventBus, FirebaseAPI firebaseAPI,
                                  EmotionService emotionService) {
        this.eventBus = eventBus;
        this.firebaseAPI = firebaseAPI;
        this.emotionService = emotionService;
    }

    @Override
    public void getSavedRecognitions() {
        FlowCursorList<Recognition> storedRecognitions = SQLite.select()
                .from(Recognition.class)
                .cursorList();
        postRecognition(MainListEvent.READ_EVENT, storedRecognitions.getAll());
        storedRecognitions.close();
    }

    public void makeRecognizePhoto(Bitmap bitmap) {
        emotionService.recognizeEmotionsOnImage(bitmap, new EmotionServiceFinishedListener() {
            @Override
            public void onSuccess(List<FeelingScores> feelingScoresList) {
                Log.e(getClass().getName(), String.valueOf(feelingScoresList.get(0).getAnger()));
                postFeelingScores(MainListEvent.RECOGNIZE_EVENT, feelingScoresList);
            }

            @Override
            public void onError(String error) {
                post(MainListEvent.RECOGNIZE_ERROR);
            }
        });
    }

    @Override
    public void logout() {
        firebaseAPI.logout();
    }


    private void postRecognition(int type, List<Recognition> recognitionList) {
        MainListEvent event = new MainListEvent();
        event.setRecognitionList(recognitionList);
        event.setType(type);
        eventBus.post(event);
    }

    private void postFeelingScores(int type, List<FeelingScores> feelingScoresList) {
        MainListEvent event = new MainListEvent();
        event.setFeelingScoresList(feelingScoresList);
        event.setType(type);
        eventBus.post(event);
    }

    private void post(int type){
        MainListEvent event = new MainListEvent();
        event.setType(type);
        eventBus.post(event);
    }
}
