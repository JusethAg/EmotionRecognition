package com.jusethag.emotionrecognition.lib;


import com.jusethag.emotionrecognition.lib.base.EventBus;

/**
 * Created by JusethAg on 7/12/16.
 */

public class GreenRobotEventBus implements EventBus {

    org.greenrobot.eventbus.EventBus eventBus;

    public GreenRobotEventBus() {
        eventBus = org.greenrobot.eventbus.EventBus.getDefault();
    }

    @Override
    public void register(Object subscriber) {
        eventBus.register(subscriber);
    }

    @Override
    public void unregister(Object subscriber) {
        eventBus.unregister(subscriber);
    }

    @Override
    public void post(Object event) {
        eventBus.post(event);
    }
}
