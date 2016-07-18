package com.jusethag.emotionrecognition.lib;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.jusethag.emotionrecognition.R;
import com.jusethag.emotionrecognition.entities.FeelingScores;
import com.jusethag.emotionrecognition.lib.base.EmotionService;
import com.jusethag.emotionrecognition.lib.base.EmotionServiceFinishedListener;
import com.jusethag.emotionrecognition.lib.base.EventBus;
import com.microsoft.projectoxford.emotion.EmotionServiceClient;
import com.microsoft.projectoxford.emotion.EmotionServiceRestClient;
import com.microsoft.projectoxford.emotion.contract.RecognizeResult;
import com.microsoft.projectoxford.emotion.rest.EmotionServiceException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by JusethAg on 7/17/16.
 */

public class RecognitionServiceClient implements EmotionService {

    private EmotionServiceClient emotionServiceClient;


    public RecognitionServiceClient(EmotionServiceRestClient emotionServiceRestClient) {
        this.emotionServiceClient = emotionServiceRestClient;
    }

    @Override
    public void recognizeEmotionsOnImage(
            final Bitmap bitmap, final EmotionServiceFinishedListener emotionServiceFinishedListener) {

        new AsyncTask<Void, Void, List<RecognizeResult>>() {
            ArrayList<FeelingScores> listFeelingScores = new ArrayList<>();
            boolean success;

            @Override
            protected List<RecognizeResult> doInBackground(Void... voids) {

                ByteArrayOutputStream output = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, output);
                ByteArrayInputStream inputStream = new ByteArrayInputStream(output.toByteArray());


                List<RecognizeResult> result = null;

                try {
                    result = emotionServiceClient.recognizeImage(inputStream);
                    success = true;
                } catch (EmotionServiceException e) {
                    emotionServiceFinishedListener.onError(e.getMessage());
                } catch (IOException e) {
                    emotionServiceFinishedListener.onError(e.getMessage());
                }

                return result;
            }

            @Override
            protected void onPostExecute(List<RecognizeResult> result) {
                super.onPostExecute(result);



                if (success && result.size() > 0) {
                    for (RecognizeResult r : result) {
                        FeelingScores feelingScores = new FeelingScores();

                        feelingScores.setAnger(r.scores.anger);
                        feelingScores.setContempt(r.scores.contempt);
                        feelingScores.setDisgust(r.scores.disgust);
                        feelingScores.setFear(r.scores.fear);
                        feelingScores.setHappiness(r.scores.happiness);
                        feelingScores.setNeutral(r.scores.neutral);
                        feelingScores.setSadness(r.scores.sadness);
                        feelingScores.setSurprise(r.scores.surprise);
                        feelingScores.setNeutral(r.scores.neutral);

                        listFeelingScores.add(feelingScores);
                    }

                    emotionServiceFinishedListener.onSuccess(listFeelingScores);

                } else {
                    emotionServiceFinishedListener.onError(
                            Resources.getSystem().getString(R.string.lib_emotion_error_notdetected));
                }
            }
        }.execute();
    }
}
