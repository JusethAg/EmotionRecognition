package com.jusethag.emotionrecognition.login.di;

import com.jusethag.emotionrecognition.EmotionRecognitionAppModule;
import com.jusethag.emotionrecognition.domain.di.DomainModule;
import com.jusethag.emotionrecognition.lib.di.LibsModule;
import com.jusethag.emotionrecognition.login.ui.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by JusethAg on 7/12/16.
 */

@Singleton
@Component(modules = {LoginModule.class, LibsModule.class, /*EmotionRecognitionAppModule.class,*/
        DomainModule.class})
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
