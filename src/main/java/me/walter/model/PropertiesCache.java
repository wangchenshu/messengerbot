package me.walter.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * Created by chenshuwang on 2016/7/21.
 */
public class PropertiesCache {
    private final Properties configProp = new Properties();
    Logger logger = Logger.getLogger(PropertiesCache.class);

    private PropertiesCache() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.properties");
        logger.debug("Read all files");

        try {
            configProp.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class LazyHolder {
        private static final PropertiesCache INSTANCE = new PropertiesCache();
    }

    public static PropertiesCache getInstance() {
        return LazyHolder.INSTANCE;
    }

    public String getProperty(String key) {
        return configProp.getProperty(key);
    }

    public Set<String> getAllPropertyNames() {
        return configProp.stringPropertyNames();
    }

    public boolean containsKey(String key) {
        return configProp.containsKey(key);
    }
}
