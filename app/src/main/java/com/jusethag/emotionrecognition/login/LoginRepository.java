package com.jusethag.emotionrecognition.login;

/**
 * Created by JusethAg on 7/12/16.
 */

public interface LoginRepository {
    void signUp(final String email, final String password);
    void signIn(String email, String password);
}
