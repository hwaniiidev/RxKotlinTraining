package com.sample.rxkotlintraining

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.lang.Exception


fun main() {
    /* 테스트용
    val list: List<Any> = listOf("One", 2, "Three", "Four", 4.5, "Five", 6.0f)
    val observable: Observable<Any> = list.toObservable()

    observable.subscribeBy(
            onNext = { println(it) },
            onError = { it.printStackTrace() },
            onComplete = { println("Done!") }
    )*/

    /* 옵저버블 기초
    val observer: Observer<Any> = object : Observer<Any> {
        override fun onComplete() {
            // 구독 완료
            println("onComplete")
        }

        override fun onSubscribe(d: Disposable) {
            // 구독 시작
            println("onSubscribe $d")
        }

        override fun onNext(t: Any) {
            // 옵저버블이 내보내는 각 아이템 호출
            println("onNext $t")
        }

        override fun onError(e: Throwable) {
            // 오류 발생
            println("onError $e")
        }
    }

    val observable: Observable<Any> =
            listOf("One", 2, "Three", "Four", 4.5, "Five", 6.0f).toObservable()

    observable.subscribe(observer)  //todo safeSubscribe() ??, sorted()??, skip()??, sample()?? 등등

    val observableOnList: Observable<List<Any>> =
            Observable.just(listOf("One", 2, "Three", "Four", 4.5, "Five", 6.0f),
            listOf("List with Single Item"),
            listOf(1,2,3,4,5,6))
    observableOnList.subscribe(observer)*/

    // Observable.create 의 이해
    val observer: Observer<String> = object : Observer<String> {
        override fun onComplete() {
            println("onComplete")
        }

        override fun onSubscribe(d: Disposable) {
            println("onSubscribe")
        }

        override fun onNext(t: String) {
            println("onNext $t")
        }

        override fun onError(e: Throwable) {
            println("onError ${e.message}")
        }
    }

    val observable:Observable<String> = Observable.create<String> {
        it.onNext("Emit 1")
        it.onNext("Emit 2")
        it.onNext("Emit 3")
        it.onError(Exception("Custom Exception"))
        it.onNext("Emit 4")
        it.onComplete()
    }

    observable.subscribe(observer)
    /*Observable 계약에는 Obsevable이 observers에게 연속적으로 (병렬이 아닌)알림을 보내야함이
    명시돼 있음. 다른 스레드에서 이런 알림이 발행할 수 있지만 공식적으로 알림 간에는 전후 관계가
    있다. */
}
