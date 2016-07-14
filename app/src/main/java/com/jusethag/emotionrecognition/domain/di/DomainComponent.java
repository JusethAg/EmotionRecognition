package com.jusethag.emotionrecognition.domain.di;

import com.jusethag.emotionrecognition.EmotionRecognitionAppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by JusethAg on 7/13/16.
 */

@Singleton
@Component(modules = {DomainModule.class /*EmotionRecognitionAppModule.class*/})
public interface DomainComponent {
}
