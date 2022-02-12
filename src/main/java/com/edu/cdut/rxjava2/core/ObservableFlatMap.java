package com.edu.cdut.rxjava2.core;

public class ObservableFlatMap<T, U> extends AbstractObservableUpStream<T, U>{

    Function<T, ObservableSource<U>> function;

    protected ObservableFlatMap(ObservableSource<T> source, Function<T, ObservableSource<U>> function) {
        super(source);
        this.function = function;
    }

    @Override
    protected void subscribeActual(Observer observer) {
        source.subscribe(new MergeObserver(observer, function));
    }

    static class MergeObserver<T, U> implements Observer<T>{

        final Observer<U> downStream;

         final Function<T, ObservableSource<U>> mapper;

        MergeObserver(Observer<U> downStream, Function<T, ObservableSource<U>> mapper) {
            this.downStream = downStream;
            this.mapper = mapper;
        }


        @Override
        public void onSubscribe() {
            downStream.onSubscribe();
        }

        @Override
        public void onNext(T t) {
            ObservableSource<U> observable = mapper.apply(t);
            observable.subscribe(new Observer<U>() {
                @Override
                public void onSubscribe() {

                }

                @Override
                public void onNext(U u) {
                    downStream.onNext(u);
                }

                @Override
                public void onComplete() {

                }

                @Override
                public void onError(Throwable throwable) {

                }
            });
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
