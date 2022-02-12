package com.edu.cdut.rxjava2.rxtest;

import com.edu.cdut.rxjava2.core.Emitter;
import com.edu.cdut.rxjava2.core.Observable;
import com.edu.cdut.rxjava2.core.ObservableOnSubscribe;
import com.edu.cdut.rxjava2.core.Observer;

public class OperatorDemo {

    public static void main(String[] args) {
        System.out.println("========================");
    }

    private void test1(){
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(Emitter<Object> emitter) {
                emitter.onNext("1");
                emitter.onNext("22");
                emitter.onComplete();
            }
        }).subscribe(new Observer() {
            @Override
            public void onSubscribe() {
                //前置方法
                System.out.println("onsubscribe");
            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
