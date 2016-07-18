package com.jusethag.emotionrecognition.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by JusethAg on 7/15/16.
 */
@Database(name = RecognitionDatabase.NAME, version = RecognitionDatabase.VERSION)
public class RecognitionDatabase {
    public static final int VERSION = 1;
    public static final String NAME = "EmotionRecognition";
}
