package com.jusethag.emotionrecognition.login.di;

import com.jusethag.emotionrecognition.domain.FirebaseAPI;
import com.jusethag.emotionrecognition.lib.base.EventBus;
import com.jusethag.emotionrecognition.login.LoginInteractor;
import com.jusethag.emotionrecognition.login.LoginInteractorImpl;
import com.jusethag.emotionrecognition.login.LoginPresenter;
import com.jusethag.emotionrecognition.login.LoginPresenterImpl;
import com.jusethag.emotionrecognition.login.LoginRepository;
import com.jusethag.emotionrecognition.login.LoginRepositoryImpl;
import com.jusethag.emotionrecognition.login.SignupInteractor;
import com.jusethag.emotionrecognition.login.SignupInteractorImpl;
import com.jusethag.emotionrecognition.login.ui.LoginView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JusethAg on 7/12/16.
 */

@Module
public class LoginModule {
    LoginView loginView;

    public LoginModule(LoginView loginView){
        this.loginView = loginView;
    }

    @Provides
    @Singleton
    LoginView providesLoginView() {
        return this.loginView;
    }

    @Provides
    @Singleton
    LoginPresenter providesLoginPresenter(EventBus eventBus, LoginView loginView, LoginInteractor loginInteractor,
                                          SignupInteractor signupInteractor) {
        return new LoginPresenterImpl(eventBus, loginView, loginInteractor, signupInteractor);
    }

    @Provides
    @Singleton
    LoginInteractor providesLoginInteractor(LoginRepository loginRepository) {
        return new LoginInteractorImpl(loginRepository);
    }

    @Provides
    @Singleton
    SignupInteractor providesSignupInteractor(LoginRepository loginRepository) {
        return new SignupInteractorImpl(loginRepository);
    }

    @Provides
    @Singleton
    LoginRepository providesLoginRepository(EventBus eventBus, FirebaseAPI firebaseAPI) {
        return new LoginRepositoryImpl(eventBus, firebaseAPI);
    }

}
