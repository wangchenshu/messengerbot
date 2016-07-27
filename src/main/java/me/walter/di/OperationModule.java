package me.walter.di;

import com.google.inject.AbstractModule;
import me.walter.operation.ImageOperation;

/**
 * Created by chenshuwang on 2016/7/26.
 */
public class OperationModule extends AbstractModule {
    private ImageOperation imageOperation = new ImageOperation();
    @Override
    protected void configure() {
        bind(ImageOperation.class).toInstance(imageOperation);
    }
}
