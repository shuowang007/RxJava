package com.edu.cdut.rxjava2.core;

/**
 * 事件发输液器
 */
public interface Emitter<T> {

    void onNext(T t);

    void onComplete();

    void onError(Throwable throwable);
}
