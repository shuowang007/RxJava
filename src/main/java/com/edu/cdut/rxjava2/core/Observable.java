package com.edu.cdut.rxjava2.core;

/**
 *被观察者核心抽象类
 * 也是框架的入口
 */
public abstract class Observable<T> implements ObservableSource<T> {

    @Override
    public void subscribe(Observer observer) {
        //和谁建立订阅
        //怎么建立订阅
        //为了保证扩展性，这里只提供抽象的方法，不提供具体实现
        subscribeActual(observer);
    }

    protected abstract void subscribeActual(Observer observer);

    public static<T> Observable<T> create(ObservableOnSubscribe<T> source){
        return new ObservableCreate<>(source);
    }

    public <R> ObservableMap<T, R> map(Function<T, R> function){
        return new ObservableMap<>(this, function);
    }

    public <R> ObservableFlatMap<T, R> flatMap(Function<T, ObservableSource<R>> function){
        return new ObservableFlatMap<>(this, function);
    }
}
