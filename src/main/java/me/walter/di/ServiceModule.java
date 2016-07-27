package me.walter.di;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import me.walter.config.PropertiesCache;
import me.walter.service.WebHookService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chenshuwang on 2016/7/27.
 */
public class ServiceModule extends AbstractModule {

    private final PropertiesCache propertiesCache;
    WebHookService service;

    public ServiceModule(PropertiesCache propertiesCache) {
        this.propertiesCache = propertiesCache;
    }

    @Override
    protected void configure() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(propertiesCache.getProperty("baseUrl"))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        service = retrofit.create(WebHookService.class);
        bind(WebHookService.class).toInstance(service);
    }
}
