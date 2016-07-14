package com.jusethag.emotionrecognition.login;

import com.jusethag.emotionrecognition.login.events.LoginEvent;

/**
 * Created by JusethAg on 7/12/16.
 */

public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(LoginEvent event);
    void logIn(String email, String password);
    void signUp(String email, String password);
}
