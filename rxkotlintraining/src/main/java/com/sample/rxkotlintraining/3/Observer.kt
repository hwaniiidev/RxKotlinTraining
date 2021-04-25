package com.sample.rxkotlintraining.`3`

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

fun main() {
    // observer를 구독 중에 중단 시키기
    val observale: Observable<Long> = Observable.interval(100,TimeUnit.MILLISECONDS)
    val observer: Observer<Long> = object : Observer<Long> {
        lateinit var disposable: Disposable

        override fun onComplete() {
            println("onComplete")
        }

        override fun onSubscribe(d: Disposable) {
            disposable = d
        }

        override fun onNext(t: Long) {
            println("onNext $t")
            if (t >= 10 && !disposable.isDisposed) {
                disposable.dispose()
                println("disposed")
            }
        }

        override fun onError(e: Throwable) {
            println("onError ${e.message}")
        }
    }

    observale.subscribe(observer)
    Thread.sleep(1500)
}