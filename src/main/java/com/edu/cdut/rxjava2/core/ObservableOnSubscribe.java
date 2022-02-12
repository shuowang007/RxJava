package com.edu.cdut.rxjava2.core;

/**
 * 被观察者和事件发射器建立联系
 */
public interface ObservableOnSubscribe<T> {

    void subscribe(Emitter<T> emitter);

}
