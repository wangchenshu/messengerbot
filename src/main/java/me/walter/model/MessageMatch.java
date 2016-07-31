package me.walter.model;

import rx.Observable;

/**
 * Created by chenshuwang on 2016/7/23.
 */
public class MessageMatch {
    private static Observable<String> regOb = Observable.just("register", "報到", "簽到");
    private static Observable<String> baoOb = Observable.just("baobao", "抱抱");
    private static Observable<String> contactOb = Observable.just("contact", "聯絡", "連絡");
    private static Observable<String> beginOb = Observable.just("由來", "beginning", "開始");
    private static Observable<String> goOb = Observable.just("go", "去", "走");
    private static Observable<String> doOb = Observable.just("do", "做");
    private static Observable<String> h4RealDoOb = Observable.just("閒聊");
    private static Observable<String> whatOb = Observable.just("這啥", "這是什");
    private static Observable<String> fbOb = Observable.just("fb", "臉書");
    private static Observable<String> webOb = Observable.just("web", "網站");
    private static Observable<String> meetupOb = Observable.just("meetup");
    private static Observable<String> thanksOb = Observable.just("thanks", "thank you", "謝謝");
    private static Observable<String> bmwOb = Observable.just("bmw", "米漿");
    private static Observable<String> benzOb = Observable.just("benz", "賓士");
    private static Observable<String> mazdaOb = Observable.just("mazda", "馬自達");
    private static Observable<String> carOb = Observable.just("find car", "找車");

    private MessageMatch() {
    }

    public static Observable<Boolean> findReg(String text) {
        return find(text, regOb);
    }

    public static Observable<Boolean> findBao(String text) {
        return find(text, baoOb);
    }

    public static Observable<Boolean> findContact(String text) {
        return find(text, contactOb);
    }

    public static Observable<Boolean> findBegin(String text) {
        return find(text, beginOb);
    }

    public static Observable<Boolean> findGo(String text) {
        return find(text, goOb);
    }

    public static Observable<Boolean> findDo(String text) {
        return find(text, doOb);
    }

    public static Observable<Boolean> findWhat(String text) {
        return find(text, whatOb);
    }

    public static Observable<Boolean> findFb(String text) {
        return find(text, fbOb);
    }

    public static Observable<Boolean> findWeb(String text) {
        return find(text, webOb);
    }

    public static Observable<Boolean> findMeetup(String text) {
        return find(text, meetupOb);
    }

    public static Observable<Boolean> findThanks(String text) {
        return find(text, thanksOb);
    }

    public static Observable<Boolean> findBmw(String text) {
        return find(text, bmwOb);
    }

    public static Observable<Boolean> findBenz(String text) {
        return find(text, benzOb);
    }

    public static Observable<Boolean> findMazda(String text) {
        return find(text, mazdaOb);
    }

    public static Observable<Boolean> findCar(String text) {
        return find(text, carOb);
    }

    public static Observable<Boolean> findH4RealDoOb(String text) {
        return findWithoutFilter(text, h4RealDoOb);
    }

    private static Observable<Boolean> find(String text, Observable<String> ob) {
        return ob.map(s -> text.contains(s)).filter(it -> it == true).take(1);
    }

    private static Observable<Boolean> findWithoutFilter(String text, Observable<String> ob) {
        return ob.map(s -> text.contains(s));
    }
}
