package com.sample.rxkotlintraining.`3`

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.toObservable
import java.util.concurrent.TimeUnit

fun main() {
    /*// observer를 구독 중에 중단 시키기
    val observable: Observable<Long> = Observable.interval(100,TimeUnit.MILLISECONDS)
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

    observable.subscribe(observer)
    Thread.sleep(1500)*/

    /*COLD / HOT observable
    COLD는 CD/DVD 레코딩으로 컨텐츠를 본다면 HOT 은 TV채널과 비슷 시청자가 시청하는지 여부에 관계없이 콘텐츠 계속 배출.
     *//*
    val connectableObservable =
        listOf("String1","String2","String3","String4","String5").toObservable().publish()
    connectableObservable.subscribe({println("Subscription1: $it")})
    connectableObservable.map(String::reversed).subscribe({println("Subscription2: $it")})
    // connect 이전에 구독했던 observable 에게만 배출
    connectableObservable.connect()
    connectableObservable.subscribe({println("Subscription3: $it")})
    connectableObservable.connect()*/

    var connectableObservable =
        Observable.interval(100, TimeUnit.MILLISECONDS).publish()
    val disposable = connectableObservable.subscribe({ println("Subscription1: $it") })
    connectableObservable.subscribe({ println("Subscription2: $it") })
    connectableObservable.connect()
    Thread.sleep(500)
    println("sleep")
    disposable.dispose()

    // subscribe로 반환되는 disposable를 dispose 하기 전까진 이미 connect된 observable은 해지 안됨?
    connectableObservable =
        listOf(11L, 22L, 33L, 44L, 55L).toObservable().publish()
    connectableObservable.subscribe({ println("Subscription3: $it") })
    connectableObservable.connect()
    Thread.sleep(500)
}