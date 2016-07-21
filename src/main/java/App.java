/**
 * Created by chenshuwang on 2016/7/19.
 */
import me.walter.model.PropertiesCache;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        System.out.println("port: " + PropertiesCache.getInstance().getProperty("port"));
        System.out.println("messengerUrl: " + PropertiesCache.getInstance().getProperty("messengerUrl"));
        System.out.println("names: " + PropertiesCache.getInstance().getAllPropertyNames());

        before((request, response) -> {
            boolean authenticated;
            // ... check if authenticated
            if (!true) {
                halt(401, "You are not welcome here");
            }
        });

        get("/hello/:name", (request, response) -> {
            return "Hello: " + request.params(":name");
        });
    }
}
