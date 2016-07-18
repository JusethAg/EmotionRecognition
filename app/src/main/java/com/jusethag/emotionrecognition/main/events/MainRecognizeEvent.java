package com.jusethag.emotionrecognition.main.events;

import com.jusethag.emotionrecognition.entities.FeelingScores;

import java.util.List;

/**
 * Created by JusethAg on 7/18/16.
 */

public class MainRecognizeEvent {
    public final static int RECOGNIZE_INIT = 1;
    public final static int RECOGNIZE_COMPLETED = 2;
    public final static int RECOGNIZE_ERROR = 3;

    private int type;
    private String error;
    private List<FeelingScores> feelingScoresList;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<FeelingScores> getFeelingScoresList() {
        return feelingScoresList;
    }

    public void setFeelingScoresList(List<FeelingScores> feelingScoresList) {
        this.feelingScoresList = feelingScoresList;
    }
}
