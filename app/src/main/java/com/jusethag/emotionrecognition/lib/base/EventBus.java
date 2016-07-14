package com.jusethag.emotionrecognition.lib.base;

/**
 * Created by JusethAg on 7/12/16.
 */

public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
