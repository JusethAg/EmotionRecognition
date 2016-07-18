package com.jusethag.emotionrecognition.entities;

import com.jusethag.emotionrecognition.db.RecognitionDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import static android.R.attr.data;

/**
 * Created by JusethAg on 7/15/16.
 */
@Table(database = RecognitionDatabase.class)
public class FeelingScores extends BaseModel{

    @Column
    @PrimaryKey
    private int id;
    @Column
    private double anger;
    @Column
    private double contempt;
    @Column
    private double disgust;
    @Column
    private double fear;
    @Column
    private double happiness;
    @Column
    private double neutral;
    @Column
    private double sadness;
    @Column
    private double surprise;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAnger() {
        return anger;
    }

    public void setAnger(double anger) {
        this.anger = anger;
    }

    public double getContempt() {
        return contempt;
    }

    public void setContempt(double contempt) {
        this.contempt = contempt;
    }

    public double getDisgust() {
        return disgust;
    }

    public void setDisgust(double disgust) {
        this.disgust = disgust;
    }

    public double getFear() {
        return fear;
    }

    public void setFear(double fear) {
        this.fear = fear;
    }

    public double getHappiness() {
        return happiness;
    }

    public void setHappiness(double happiness) {
        this.happiness = happiness;
    }

    public double getNeutral() {
        return neutral;
    }

    public void setNeutral(double neutral) {
        this.neutral = neutral;
    }

    public double getSadness() {
        return sadness;
    }

    public void setSadness(double sadness) {
        this.sadness = sadness;
    }

    public double getSurprise() {
        return surprise;
    }

    public void setSurprise(double surprise) {
        this.surprise = surprise;
    }
}
