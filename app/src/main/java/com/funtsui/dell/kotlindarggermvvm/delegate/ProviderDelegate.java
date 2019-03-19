package com.funtsui.dell.kotlindarggermvvm.delegate;

import android.util.SparseArray;
import com.funtsui.dell.kotlindarggermvvm.base.BaseItemProvider;

public class ProviderDelegate {
    //处理多布局代理逻辑
    private SparseArray<BaseItemProvider> mItemProviders = new SparseArray<>();

    public ProviderDelegate() {
    }
     //可变长度参数列表，可以多参数，也可数组
    public ProviderDelegate(BaseItemProvider... providers) {
        registerProvider(providers);
    }

    public void registerProvider(BaseItemProvider... providers) {
        for (BaseItemProvider provider : providers) {
            if (provider == null) {
                throw new NullPointerException("ItemProvider can not be null");
            }

            int viewType = provider.layout();

            if (mItemProviders.get(viewType) == null) {
                mItemProviders.put(viewType, provider);
            }
        }
    }

    public SparseArray<BaseItemProvider> getItemProviders() {
        return mItemProviders;
    }
}
