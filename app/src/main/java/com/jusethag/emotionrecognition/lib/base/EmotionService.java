package com.jusethag.emotionrecognition.lib.base;

import android.graphics.Bitmap;

import com.jusethag.emotionrecognition.entities.FeelingScores;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by JusethAg on 7/17/16.
 */

public interface EmotionService {
    void recognizeEmotionsOnImage(
            Bitmap bitmap, EmotionServiceFinishedListener emotionServiceFinishedListener);
}
