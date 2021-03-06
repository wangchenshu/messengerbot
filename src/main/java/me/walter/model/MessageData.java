package me.walter.model;

import java.util.*;

/**
 * Created by chenshuwang on 2016/7/22.
 */
public abstract class MessageData {

    public static final String h4Web = "http://www.hackingthursday.org/";
    public static final String h4Meetup = "http://www.meetup.com/hackingthursday/";
    public static final String h4Fb = "http://www.facebook.com/groups/hackingday/";
    public static final String fields = "first_name,last_name,profile_pic,locale,timezone,gender";
    public static final String urwelcome = "You are welcome. 不用客氣";

    public static final Map<String, String> imageLink = new HashMap<>();
    public static final Map<String, List<String>> sellImageLink = new HashMap<>();
    public static final Map<String, String> sendText = new HashMap<>();
    static {
        // imageLink
        imageLink.put("h4", "https://firebasestorage.googleapis.com/v0/b/walter-bot-a2142.appspot.com/o/line-bot%2Fimage%2Fh4-logo%2F700.jpg?alt=media&token=04ff5f19-2d0c-470f-8581-396085fbb10d");
        imageLink.put("emacs", "https://firebasestorage.googleapis.com/v0/b/walter-bot-a2142.appspot.com/o/line-bot%2Fimage%2Femacs-logo%2Femacs_logo_large.png?alt=media&token=a8a55896-f703-4e10-adce-302a44f792c5");
        imageLink.put("baobao", "https://firebasestorage.googleapis.com/v0/b/walter-bot-a2142.appspot.com/o/line-bot%2Fimage%2Fother%2Fiyiy.jpg?alt=media&token=1d0dfd87-d61a-48d5-8ea0-0bd86c9b9458");
        imageLink.put("fb-good", "https://firebasestorage.googleapis.com/v0/b/walter-bot-a2142.appspot.com/o/line-bot%2Fimage%2Fother%2Ffb-good.png?alt=media&token=52fde993-26a0-4872-bbc7-eb78933cf470");

        imageLink.put("true", "http://www.chinamgt.com/images/article/02A15SU7.jpg");
        imageLink.put("false", "http://s8.z9x9.com/wp-content/uploads/2016/07/9C44B1EAC2.jpg");

        sellImageLink.put("bmw-1", Arrays.asList(
            "https://scontent-tpe1-1.xx.fbcdn.net/v/t1.0-9/13769403_10205405842380304_8743949122007861785_n.jpg?oh=0510dede4eb9bb81ee816994d84c81c1&oe=58336210",
            "https://scontent-tpe1-1.xx.fbcdn.net/v/t1.0-9/13718792_10205405842140298_5820858600731320831_n.jpg?oh=c6563c74d7aedb19421e8d4aed77f724&oe=58303E51",
            "https://scontent-tpe1-1.xx.fbcdn.net/v/t1.0-9/13775433_10205405841820290_1699949512850865065_n.jpg?oh=be7bc4ae3773a751eb2d035eb4c6304d&oe=582625E9",
            "https://scontent-tpe1-1.xx.fbcdn.net/v/t1.0-9/13718678_10205405840020245_8815298939544909893_n.jpg?oh=a979223067428ccf00714527799b344f&oe=581B427A",
            "https://scontent-tpe1-1.xx.fbcdn.net/v/t1.0-9/13776051_10205405839580234_7205627092120717186_n.jpg?oh=297b0a7ca520f17cc72eb374c93dd812&oe=5824560B")
        );

        sellImageLink.put("benz-1", Arrays.asList(
            "https://scontent-tpe1-1.xx.fbcdn.net/v/t1.0-9/13566974_10205319142012849_6806131105853194223_n.jpg?oh=f425bbbf873efa080b547ec4f2c3156e&oe=582C54CC",
            "https://scontent-tpe1-1.xx.fbcdn.net/v/t1.0-9/13494896_10205319141852845_3821363583353147951_n.jpg?oh=7c075d9802b1f888ba6d64fe5bf1e3f4&oe=581DF083",
            "https://scontent-tpe1-1.xx.fbcdn.net/v/t1.0-9/13494986_10205319142292856_2411493770584044249_n.jpg?oh=b81a9fe8ccbf17534c994a092f0cbbf6&oe=582D2885")
        );

        sellImageLink.put("mazda-1", Arrays.asList(
            "https://scontent-tpe1-1.xx.fbcdn.net/v/t1.0-9/13442140_10205230120387364_4096170620213646369_n.jpg?oh=2e8f4a2600bc1197e92018d01bd8840c&oe=57E89AEC",
            "https://scontent-tpe1-1.xx.fbcdn.net/v/t1.0-9/13260096_10205230119987354_4648330322985784364_n.jpg?oh=7d94e564c5c56c14277a2c819024aa34&oe=581C836D",
            "https://scontent-tpe1-1.xx.fbcdn.net/v/t1.0-9/13423779_10205230119587344_4565736651895532685_n.jpg?oh=fc32bea364dfe2edb66e956db970a338&oe=5836DEF7")
        );

        // sendText
        sendText.put("default", "Welcome to h4!");
        sendText.put("h4", "Welcome to h4!");
        sendText.put("h4-helper", "我是 H4 小幫手");
        sendText.put("emacs", "Welcome to Emacs Taiwan!");
        sendText.put("how-are-you-today", "How are you today?");
        sendText.put("i-am-fine", "Fine, how do you do.");
        sendText.put(
            "h4-place",
            "餐廳：田中園光華店\n" +
            "地址：台北市中正區臨沂街 1 號\n" +
            "(捷運忠孝新生站一號出口直走第一個路口右轉)\n" +
            "時間：7:30pm ~ 10:00pm\n" +
            "Restaurant : 田中園 (Tian Jung Yuan)\n\n" +
            "Venue : No. 1, Linyi St, Zhongzheng District, Taipei City\n" +
            "(MRT JungXiao Xingshen Station Exit 1)\n" +
            "Time : 7:30pm ~ 10:00pm"
        );
        sendText.put(
            "h4-people-do",
            "1. 討論 web, network, programming, system, blablah….\n" +
            "2. 交流系統工具 & 使用技巧\n" +
            "3. 八卦"
        );
        sendText.put("h4-beginning",
            "Hacking Thursday 是由幾位居住於台北地區的自由軟體/開放原碼開發者所發起，\n" +
            "每週四晚上會於特定咖啡店聚會。以非會議形式、交換並實做各自提出的想法，\n" +
            "輕鬆的會議過程以禮貌、謙遜與尊重的互信態度接納並鼓勵概念發想、發起新計畫、\n" +
            "並從開發者的協同開發與經驗分享中互相學習。"
        );
        sendText.put("contact-us",
            "除了實體聚會外，我們使用 Google group / Facebook group 做為大家的溝通聯絡管道。\n" +
            "聊天，討論，及聚會通告都會在這裡發佈。如果您對我們的聚會有興趣，隨時都歡迎您加入/訂閱我們的討論區，和我們交流！！\n\n" +
            "FB: http://www.facebook.com/groups/hackingday/\n" +
            "Meetup: https://www.meetup.com/hackingthursday/\n" +
            "Google Group: http://groups.google.com/group/hackingthursday"
        );
        sendText.put("register", "您好, 已完成報到手續, 謝謝。");
        sendText.put("good-d-ya", "好的呀");
        sendText.put("iyiy", "搖搖照騙");
        sendText.put("aa", "@@");
        sendText.put("professional", "你好專業，難道是自已人？");
        sendText.put("other", "假的，都是假的！");
    }
}
