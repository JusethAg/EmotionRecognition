package com.jusethag.emotionrecognition.main.events;

import com.jusethag.emotionrecognition.entities.FeelingScores;
import com.jusethag.emotionrecognition.entities.Recognition;

import java.util.List;

/**
 * Created by JusethAg on 7/15/16.
 */

public class MainListEvent {

    public final static int READ_EVENT = 0;
    public final static int RECOGNIZE_EVENT = 1;
    public final static int RECOGNIZE_ERROR = 2;

    private int type;
    private List<Recognition> recognitionList;
    private List<FeelingScores> feelingScoresList;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Recognition> getRecognitionList() {
        return recognitionList;
    }

    public void setRecognitionList(List<Recognition> recognitionList) {
        this.recognitionList = recognitionList;
    }

    public List<FeelingScores> getFeelingScoresList() {
        return feelingScoresList;
    }

    public void setFeelingScoresList(List<FeelingScores> feelingScoresList) {
        this.feelingScoresList = feelingScoresList;
    }
}
