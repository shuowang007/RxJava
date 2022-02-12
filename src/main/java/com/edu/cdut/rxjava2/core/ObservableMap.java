package com.edu.cdut.rxjava2.core;

public class ObservableMap<T, U> extends AbstractObservableUpStream<T, U>{

    Function<T, U> function;

    protected ObservableMap(ObservableSource<T> source, Function<T, U> function) {
        super(source);
        this.function = function;
    }

    @Override
    protected void subscribeActual(Observer observer) {
        source.subscribe(new MapObserver(observer, function));
    }

    static class MapObserver<T, U> implements Observer<T>{

        final Observer<U> downStream;

        final Function<T, U> mapper;

        MapObserver(Observer<U> downStream, Function<T, U> mapper) {
            this.downStream = downStream;
            this.mapper = mapper;
        }

        @Override
        public void onSubscribe() {
            downStream.onSubscribe();
        }

        @Override
        public void onNext(T t) {
            U apply = mapper.apply(t);
            downStream.onNext(apply);
        }

        @Override
        public void onComplete() {
            downStream.onComplete();
        }

        @Override
        public void onError(Throwable throwable) {
            downStream.onError(throwable);
        }
    }
}
