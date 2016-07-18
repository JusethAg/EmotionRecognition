package com.jusethag.emotionrecognition.login;

import com.jusethag.emotionrecognition.lib.base.EventBus;
import com.jusethag.emotionrecognition.login.events.LoginEvent;
import com.jusethag.emotionrecognition.login.ui.LoginView;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by JusethAg on 7/12/16.
 */

public class LoginPresenterImpl implements LoginPresenter {
    private EventBus eventBus;
    private LoginView loginView;
    private LoginInteractor loginInteractor;
    private SignupInteractor signupInteractor;

    public LoginPresenterImpl(EventBus eventBus, LoginView loginView, LoginInteractor loginInteractor,
                              SignupInteractor signupInteractor) {
        this.eventBus = eventBus;
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
        this.signupInteractor = signupInteractor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
        eventBus.unregister(this);
    }

    @Subscribe
    @Override
    public void onEventMainThread(LoginEvent event) {

        switch (event.getType()){
            case LoginEvent.onSignInError:
                onSignInError(event.getErrorMesage());
                break;
            case LoginEvent.onSignUpError:
                onSignUpError(event.getErrorMesage());
                break;
            case LoginEvent.onSignInSuccess:
                onSignInSuccess(event.getErrorMesage());
                break;
            case LoginEvent.onSignUpSuccess:
                onSignUpSuccess(event.getErrorMesage());
                break;
            case LoginEvent.onFailedToRecoverSession:
                onFailedToRecoverSession(event.getErrorMesage());
                break;
            case LoginEvent.onEmptyEmailInput:
                onEmptyEmailInput();
                break;
            case LoginEvent.onEmptyPasswordInput:
                onEmptyPasswordInput();
                break;
        }
    }



    @Override
    public void logIn(String email, String password) {
        if (loginView != null) {
            loginView.disableUIElements();
            loginView.showProgress();
        }
        loginInteractor.execute(email, password);
    }

    @Override
    public void signUp(String email, String password) {
        if (loginView != null) {
            loginView.disableUIElements();
            loginView.showProgress();
        }

        signupInteractor.execute(email, password);
    }

    private void onSignInError(String error) {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.enableUIElements();
            loginView.loginError(error);
        }
    }

    private void onSignUpError(String error) {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.enableUIElements();
            loginView.signUpError(error);
        }
    }

    private void onSignInSuccess(String error) {
        if (loginView != null) {
            loginView.navigateToMainScreen();
        }
    }

    private void onSignUpSuccess(String error) {
        if (loginView != null) {
            loginView.signUpSuccess();
            loginView.enableUIElements();
        }
    }

    private void onFailedToRecoverSession(String error) {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.enableUIElements();
        }
    }

    private void onEmptyEmailInput(){
        if (loginView != null) {
            loginView.shakeEmailInput();
            loginView.enableUIElements();
        }
    }

    private void onEmptyPasswordInput() {
        if (loginView != null) {
            loginView.shakePasswordInput();
            loginView.enableUIElements();
        }
    }

}
