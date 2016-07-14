package com.jusethag.emotionrecognition.login;

/**
 * Created by JusethAg on 7/12/16.
 */

public class LoginInteractorImpl implements LoginInteractor {

    private LoginRepository loginRepository;

    public LoginInteractorImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void execute(String email, String password) {
        loginRepository.signIn(email, password);
    }
}

