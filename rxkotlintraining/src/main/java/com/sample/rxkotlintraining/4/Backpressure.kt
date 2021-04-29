package com.sample.rxkotlintraining.`4`

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

fun main() {
    /*val observable = Observable.just(1,2,3,4,5,6,7,8,9)
    val subject = BehaviorSubject.create<Int>()
    subject.observeOn(Schedulers.computation())
        .subscribe({
            println("Subs 1 Received $it")
            Thread.sleep(200)
        })

    subject.observeOn(Schedulers.computation())
        .subscribe({
            println("Subs 2 Received $it")
        })
    observable.subscribe(subject)
    Thread.sleep(2000)*/

    val observable = Observable.just(1,2,3,4,5,6,7,8,9)
    observable
        .map { MyItem(it) }
        .observeOn(Schedulers.computation())
        .subscribe({
            println("Received $it")
            Thread.sleep(200)
        })
    Thread.sleep(2000)
}

data class MyItem(val id: Int) {
    init {
        println("MyItem Created $ id")
    }
}