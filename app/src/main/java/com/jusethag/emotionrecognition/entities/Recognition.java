package com.jusethag.emotionrecognition.entities;

import android.graphics.Bitmap;

import com.jusethag.emotionrecognition.db.RecognitionDatabase;
import com.jusethag.emotionrecognition.entities.FeelingScores;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by JusethAg on 7/15/16.
 */
@Table(database = RecognitionDatabase.class)
public class Recognition extends BaseModel{
    @Column
    @PrimaryKey
    private String id;
    @Column
    private String url;
    private Bitmap bitmap;

    @ForeignKey(saveForeignKeyModel = false)
    @PrimaryKey
    private FeelingScores feelingScores;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public FeelingScores getFeelingScores() {
        return feelingScores;
    }

    public void setFeelingScores(FeelingScores feelingScores) {
        this.feelingScores = feelingScores;
    }
}
