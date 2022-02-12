package com.edu.cdut.rxjava2.core;

public class ObservableCreate<T> extends Observable<T>{

    final ObservableOnSubscribe<T> source;

    public ObservableCreate(ObservableOnSubscribe<T> source) {
        this.source = source;
    }

    @Override
    protected void subscribeActual(Observer observer) {
        observer.onSubscribe();
        CrateEmitter<T> emitter = new CrateEmitter<T>(observer);
        source.subscribe(emitter);
    }

    static class CrateEmitter<T> implements Emitter<T>{

        Observer<T> observer;
        boolean done = false;

        public CrateEmitter(Observer<T> observer) {
            this.observer = observer;
        }

        @Override
        public void onNext(T t) {
            if (done) return;
            observer.onNext(t);
        }

        @Override
        public void onComplete() {
            if (done) return;
            observer.onComplete();
            done = true;
        }

        @Override
        public void onError(Throwable throwable) {
            if (done) return;
            observer.onError(throwable);
            done = true;
        }
    }
}
