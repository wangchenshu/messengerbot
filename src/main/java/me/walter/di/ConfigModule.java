package me.walter.di;

import com.google.inject.AbstractModule;
import me.walter.config.PropertiesCache;

/**
 * Created by chenshuwang on 2016/7/25.
 */
public class ConfigModule extends AbstractModule {
    PropertiesCache propertiesCache = PropertiesCache.getInstance();
    @Override
    protected void configure() {
        bind(PropertiesCache.class).toInstance(propertiesCache);
    }
}
