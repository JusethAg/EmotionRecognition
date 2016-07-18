package com.jusethag.emotionrecognition.main.events;

import com.jusethag.emotionrecognition.entities.FeelingScores;
import com.jusethag.emotionrecognition.entities.Recognition;

import java.util.List;

/**
 * Created by JusethAg on 7/15/16.
 */

public class MainListEvent {

    public final static int READ_LIST_EVENT_SUCCESS = 0;
    public final static int READ_LIST_EVENT_ERROR = 1;


    private int type;
    private String error;
    private List<Recognition> recognitionList;



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

    public List<Recognition> getRecognitionList() {
        return recognitionList;
    }

    public void setRecognitionList(List<Recognition> recognitionList) {
        this.recognitionList = recognitionList;
    }


}
