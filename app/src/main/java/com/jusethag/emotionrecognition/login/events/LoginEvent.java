package com.jusethag.emotionrecognition.login.events;

/**
 * Created by JusethAg on 7/12/16.
 */
public class LoginEvent {
    public final static int onSignInError = 0;
    public final static int onSignUpError = 1;
    public final static int onSignInSuccess = 2;
    public final static int onSignUpSuccess = 3;
    public final static int onFailedToRecoverSession = 4;
    public final static int onEmptyEmailInput = 5;
    public final static int onEmptyPasswordInput = 6;


    private int eventType;
    private String errorMesage;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getErrorMesage() {
        return errorMesage;
    }

    public void setErrorMesage(String errorMesage) {
        this.errorMesage = errorMesage;
    }
}
