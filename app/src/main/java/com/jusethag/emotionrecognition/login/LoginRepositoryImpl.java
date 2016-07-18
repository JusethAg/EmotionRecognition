package com.jusethag.emotionrecognition.login;

import com.firebase.client.FirebaseError;
import com.jusethag.emotionrecognition.domain.FirebaseAPI;
import com.jusethag.emotionrecognition.domain.FirebaseActionListenerCallback;
import com.jusethag.emotionrecognition.lib.base.EventBus;
import com.jusethag.emotionrecognition.login.events.LoginEvent;

/**
 * Created by JusethAg on 7/12/16.
 */

public class LoginRepositoryImpl implements LoginRepository {

    private EventBus eventBus;
    private FirebaseAPI firebaseAPI;

    public LoginRepositoryImpl(EventBus eventBus, FirebaseAPI firebaseAPI) {
        this.eventBus = eventBus;
        this.firebaseAPI = firebaseAPI;
    }

    @Override
    public void signUp(final String email, final String password) {

        if (!isInputEmpty(email, password)) {

            firebaseAPI.signUp(email, password, new FirebaseActionListenerCallback() {
                @Override
                public void onSuccess() {
                    post(LoginEvent.onSignUpSuccess);
                    signIn(email, password);
                }

                @Override
                public void onError(FirebaseError error) {
                    post(LoginEvent.onSignUpError, error.getMessage());
                }
            });
        }
    }

    @Override
    public void signIn(String email, String password) {

        if (email != null && password != null) {
            if(!isInputEmpty(email, password)){
                firebaseAPI.login(email, password, new FirebaseActionListenerCallback() {
                    @Override
                    public void onSuccess() {
                        String email = firebaseAPI.getAuthEmail();
                        post(LoginEvent.onSignInSuccess, null);
                    }

                    @Override
                    public void onError(FirebaseError error) {
                        post(LoginEvent.onSignInError, error.getMessage());
                    }
                });
            }
        } else {
            firebaseAPI.checkForSession(new FirebaseActionListenerCallback() {
                @Override
                public void onSuccess() {
                    String email = firebaseAPI.getAuthEmail();
                    post(LoginEvent.onSignInSuccess, null);
                }

                @Override
                public void onError(FirebaseError error) {
                    post(LoginEvent.onFailedToRecoverSession);
                }
            });
        }
    }

    private void post(int type) {
        post(type, null);
    }

    private void post(int type, String errorMessage) {
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setType(type);
        loginEvent.setErrorMesage(errorMessage);
        eventBus.post(loginEvent);
    }

    private boolean isInputEmpty(String email, String password){
        if (email.equals("")) {
            post(LoginEvent.onEmptyEmailInput, null);
            return true;
        } else if (password.equals("")) {
            post(LoginEvent.onEmptyPasswordInput, null);
            return true;
        }
        return false;
    }

}
