package com.jusethag.emotionrecognition.login.ui;

/**
 * Created by JusethAg on 7/12/16.
 */

public interface LoginView {
    void enableUIElements();
    void disableUIElements();
    void showProgress();
    void hideProgress();
    void shakeEmailInput();
    void shakePasswordInput();

    void handleSignUp();
    void handleSignIn();

    void navigateToMainScreen();
    void loginError(String error);

    void signUpSuccess();
    void signUpError(String error);
}
