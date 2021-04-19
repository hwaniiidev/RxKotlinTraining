package com.sample.rxkotlintraining


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
}
