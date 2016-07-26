package me.walter.factory;

import me.walter.operation.ImageOperation;

/**
 * Created by chenshuwang on 2016/7/26.
 */
public interface OperationFactory {
    public ImageOperation createImageOperation();
}
