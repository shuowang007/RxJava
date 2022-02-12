package com.edu.cdut.rxjava2.core;

public abstract class AbstractObservableUpStream<T, U> extends Observable<U> {

    protected final ObservableSource<T> source;

    protected AbstractObservableUpStream(ObservableSource<T> source) {
        this.source = source;
    }
}
