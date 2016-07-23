package me.walter.model;

import rx.Observable;
import rx.Observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenshuwang on 2016/7/23.
 */
public class MessageMatch {
    private Observable<String> regOb = Observable.just("register", "報到", "簽到");
    private Observable<String> baoOb = Observable.just("baobao", "抱抱");
    private Observable<String> contactOb = Observable.just("contact", "找", "聯絡", "連絡");
    private Observable<String> beginOb = Observable.just("由來", "beginning", "開始");
    private Observable<String> goOb = Observable.just("go", "to", "去", "走");
    private Observable<String> doOb = Observable.just("do", "做");
    private Observable<String> whatOb = Observable.just("這啥", "這是什");
    private Observable<String> fbOb = Observable.just("fb", "臉書");
    private Observable<String> webOb = Observable.just("web", "網站");
    private Observable<String> meetupOb = Observable.just("meetup");

    public MessageMatch() {
    }

    public Observable<Boolean> findReg(String text) {
        return regOb.flatMap(it -> Observable.just(text.contains(it))).filter(it -> it == true);
    }

    public Observable<Boolean> findBao(String text) {
        return baoOb.flatMap(it -> Observable.just(text.contains(it))).filter(it -> it == true);
    }

    public Observable<Boolean> findContact(String text) {
        return contactOb.flatMap(it -> Observable.just(text.contains(it))).filter(it -> it == true);
    }

    public Observable<Boolean> findBegin(String text) {
        return beginOb.flatMap(it -> Observable.just(text.contains(it))).filter(it -> it == true);
    }

    public Observable<Boolean> findGo(String text) {
        return goOb.flatMap(it -> Observable.just(text.contains(it))).filter(it -> it == true);
    }

    public Observable<Boolean> findDo(String text) {
        return doOb.flatMap(it -> Observable.just(text.contains(it))).filter(it -> it == true);
    }

    public Observable<Boolean> findWhat(String text) {
        return whatOb.flatMap(it -> Observable.just(text.contains(it))).filter(it -> it == true);
    }

    public Observable<Boolean> findFb(String text) {
        return fbOb.flatMap(it -> Observable.just(text.contains(it))).filter(it -> it == true);
    }

    public Observable<Boolean> findWeb(String text) {
        return webOb.flatMap(it -> Observable.just(text.contains(it))).filter(it -> it == true);
    }

    public Observable<Boolean> findMeetup(String text) {
        return meetupOb.flatMap(it -> Observable.just(text.contains(it))).filter(it -> it == true);
    }
}
