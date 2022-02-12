package com.edu.cdut.rxjava2.core;

/*
被观察者的顶级接口
 */
public interface ObservableSource<T> {

    /**
     * addObserver
     * @param observer
     */
    void subscribe(Observer observer);
}
