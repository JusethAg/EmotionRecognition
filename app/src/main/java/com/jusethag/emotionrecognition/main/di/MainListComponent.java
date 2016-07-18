package com.jusethag.emotionrecognition.main.di;

import com.jusethag.emotionrecognition.domain.di.DomainModule;
import com.jusethag.emotionrecognition.lib.di.LibsModule;
import com.jusethag.emotionrecognition.main.ui.MainListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by JusethAg on 7/15/16.
 */

@Singleton
@Component(modules = {MainListModule.class, LibsModule.class, DomainModule.class})
public interface MainListComponent {
    void inject(MainListActivity mainListActivity);
}
