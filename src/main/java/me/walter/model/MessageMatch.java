package me.walter.model;

import rx.Observable;
import rx.Observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by chenshuwang on 2016/7/23.
 */
public class MessageMatch {
    private List<String> regOb = Arrays.asList("register", "報到", "簽到");
    private List<String> baoOb = Arrays.asList("baobao", "抱抱");
    private List<String> contactOb = Arrays.asList("contact", "找", "聯絡", "連絡");
    private List<String> beginOb = Arrays.asList("由來", "beginning", "開始");
    private List<String> goOb = Arrays.asList("go", "to", "去", "走");
    private List<String> doOb = Arrays.asList("do", "做");
    private List<String> whatOb = Arrays.asList("這啥", "這是什");
    private List<String> fbOb = Arrays.asList("fb", "臉書");
    private List<String> webOb = Arrays.asList("web", "網站");
    private List<String> meetupOb = Arrays.asList("meetup");
    private List<String> thanksOb = Arrays.asList("thanks", "thank you", "謝謝");
    private List<String> bmwOb = Arrays.asList("bmw", "米漿");

    public MessageMatch() {
    }

    public Boolean findReg(String text) {
        return find(text, regOb);
    }

    public Boolean findBao(String text) {
        return find(text, baoOb);
    }

    public Boolean findContact(String text) {
        return find(text, contactOb);
    }

    public Boolean findBegin(String text) {
        return find(text, beginOb);
    }

    public Boolean findGo(String text) {
        return find(text, goOb);
    }

    public Boolean findDo(String text) {
        return find(text, doOb);
    }

    public Boolean findWhat(String text) {
        return find(text, whatOb);
    }

    public Boolean findFb(String text) {
        return find(text, fbOb);
    }

    public Boolean findWeb(String text) {
        return find(text, webOb);
    }

    public Boolean findMeetup(String text) {
        return find(text, meetupOb);
    }

    public Boolean findThanks(String text) {
        return find(text, thanksOb);
    }

    public Boolean findBmw(String text) {
        return find(text, bmwOb);
    }

    private Boolean find(String text, List<String> list) {
        final Boolean[] isFind = new Boolean[]{false};

        for (String s : list) {
            if (text.contains(s)) {
                isFind[0] = true;
                break;
            }
        }

        return isFind[0];
    }
}
