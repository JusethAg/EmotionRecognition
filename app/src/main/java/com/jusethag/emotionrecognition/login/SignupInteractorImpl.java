package com.jusethag.emotionrecognition.login;

/**
 * Created by JusethAg on 7/12/16.
 */

public class SignupInteractorImpl implements SignupInteractor {

    private LoginRepository loginRepository;

    public SignupInteractorImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void execute(String email, String password) {
        loginRepository.signUp(email, password);
    }
}
