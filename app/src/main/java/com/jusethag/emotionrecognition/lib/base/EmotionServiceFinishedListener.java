package com.jusethag.emotionrecognition.lib.base;

import com.jusethag.emotionrecognition.entities.FeelingScores;

import java.util.List;

/**
 * Created by JusethAg on 7/17/16.
 */

public interface EmotionServiceFinishedListener {
    void onSuccess(List<FeelingScores> feelingScoresList);
    void onError(String error);
}
