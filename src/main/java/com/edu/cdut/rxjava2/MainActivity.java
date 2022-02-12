package com.edu.cdut.rxjava2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.edu.cdut.rxjava2.core.Emitter;
import com.edu.cdut.rxjava2.core.Observable;
import com.edu.cdut.rxjava2.core.ObservableOnSubscribe;
import com.edu.cdut.rxjava2.core.Observer;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(Emitter<Object> emitter) {
                Log.i(TAG, "subscribe: ");
                emitter.onNext("aaa");
                emitter.onNext("bbb");
                emitter.onNext("111");
                emitter.onNext("222");
                emitter.onError(new Throwable());
                emitter.onComplete();
            }
        }).subscribe(new Observer() {
            @Override
            public void onSubscribe() {
                Log.i(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(Object o) {
                Log.i(TAG, "onNext: " + o);
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: ");
            }

            @Override
            public void onError(Throwable throwable) {
                Log.i(TAG, "onError: " + throwable);
            }
        });
    }
}