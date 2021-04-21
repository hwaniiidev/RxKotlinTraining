package com.sample.rxkotlintraining.`3`

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.lang.Exception
import java.util.concurrent.Callable
import java.util.concurrent.TimeUnit


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


    val observer: Observer<Any> = object : Observer<Any> {
        override fun onComplete() {
            println("onComplete")
        }

        override fun onSubscribe(d: Disposable) {
            println("onSubscribe")
        }

        override fun onNext(t: Any) {
            println("onNext $t")
        }

        override fun onError(e: Throwable) {
            println("onError ${e.message}")
        }
    }

    /* Observable.create 의 이해
    val observable:Observable<String> = Observable.create<String> {
        it.onNext("Emit 1")
        it.onNext("Emit 2")
        it.onNext("Emit 3")
        it.onError(Exception("Custom Exception"))
        it.onNext("Emit 4")
        it.onComplete()
    }

    observable.subscribe(observer)*/
    /*Observable 계약에는 Obsevable이 observers에게 연속적으로 (병렬이 아닌)알림을 보내야함이
    명시돼 있음. 다른 스레드에서 이런 알림이 발행할 수 있지만 공식적으로 알림 간에는 전후 관계가
    있다. */

    /*// Iterable
    val list = listOf("String1","String2","String3","String4")
    val observableFromIterable: Observable<String> = Observable.fromIterable(list)
    observableFromIterable.subscribe(observer)

    // Callable
    val callable = object : Callable<String> {
        override fun call(): String {
            return "From Callable"
        }
    }
    val observableFromCallable:Observable<String> = Observable.fromCallable(callable)
    observableFromCallable.subscribe(observer)*/

    /* Observable.just
    just는 리스트나 맵도 단일 아이템으로 취급.
    아이템(인자)를 여럿 입력하면 별개의 아이템으로 취급
     */
    /*Observable.just("A String").subscribe(observer)
    Observable.just(54).subscribe(observer)
    Observable.just(
            listOf("String 1","String 2",3,true)
    ).subscribe(observer)
    Observable.just(1,2,3).subscribe(observer)*/

    /* observable의 여러 factory method
    todo factory method : observable 객체를 생성하는 성격의 메서드들?
     */
    Observable.range(1,10).subscribe(observer)
    Observable.empty<String>().subscribe(observer)

    // 구독 취소나, 프로그램 종료까지 정해진 간격만큼 0부터 출력
    Observable.interval(300,TimeUnit.MILLISECONDS).subscribe(observer)
    Thread.sleep(900)

    // 구독 취소나, 프로그램 종료까지 정해진 시간 경과 후 한 번만 출력
    Observable.timer(400,TimeUnit.MICROSECONDS).subscribe(observer)
    Thread.sleep(1000)

}
