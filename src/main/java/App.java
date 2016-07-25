/**
 * Created by chenshuwang on 2016/7/19.
 */
import com.google.inject.Guice;
import com.google.inject.Injector;
import me.walter.config.PropertiesCache;
import me.walter.controller.MessageController;
import me.walter.di.ConfigModule;
import spark.Response;

import static spark.Spark.*;

import static java.lang.System.out;

public class App {
    public static void main(String[] args) {
        port(3000);

        //Injector injector = Guice.createInjector(new ConfigModule());
        //injector.getInstance(MessageController.class);

        get("/webhook", (req, res) -> {
            String verifyToken = PropertiesCache.getInstance().getProperty("verifyToken2");
            String hubVerifyToken = req.queryParams("hub.verify_token");

            if (verifyToken.equals(hubVerifyToken)) {
                res.status(200);
                return req.queryParams("hub.challenge");
            } else {
                res.status(403);
                out.println("Error, wrong validation token");
            }
            return "";
        });

        post("/webhook", (req, res) -> {
            int resStatus = new MessageController().process(req);
            res.status(resStatus);
            return "";
        });
    }
}
