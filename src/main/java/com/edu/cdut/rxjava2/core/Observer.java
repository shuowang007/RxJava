package com.edu.cdut.rxjava2.core;

public interface Observer<T> {

    void onSubscribe();

    void onNext(T t);

    void onComplete();

    void onError(Throwable throwable);
}
