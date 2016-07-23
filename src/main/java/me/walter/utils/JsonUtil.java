package me.walter.utils;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Created by chenshuwang on 2016/7/21.
 */
public class JsonUtil {
    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static ResponseTransformer json() {
        return JsonUtil::toJson;
    }
}
