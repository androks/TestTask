package com.example.test.third

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

fun rxTask() {
    Observable.intervalRange(0, Long.MAX_VALUE, 0, 1L, TimeUnit.SECONDS)
        .doOnEach { Log.d("RX", "emit ${it.value}") }
        .filter { it % 3 == 0L || it % 5 == 0L }
        .map { it % 5 == 0L }
        .distinctUntilChanged()
        .switchMap {
            if (it) {
                Observable.just(it)
            } else {
                Observable.just(it)
                    .delay(3500L, TimeUnit.MILLISECONDS)
            }
        }.subscribe {
            Log.d("RX", "connected $it")
        }
}
