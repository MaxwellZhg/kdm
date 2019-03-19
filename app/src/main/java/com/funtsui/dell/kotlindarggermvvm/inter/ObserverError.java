package com.funtsui.dell.kotlindarggermvvm.inter;

import com.funtsui.dell.kotlindarggermvvm.event.ErroeLiveData;
import org.jetbrains.annotations.NotNull;

public interface ObserverError {
    Boolean onChangedNeedIntercept(@NotNull ErroeLiveData.Error error);
}
