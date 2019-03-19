package com.funtsui.dell.kotlindarggermvvm.base;

import com.funtsui.dell.kotlindarggermvvm.inter.ViewModelEvent;
import com.trello.rxlifecycle2.LifecycleTransformer;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

import static com.trello.rxlifecycle2.RxLifecycle.bind;

public class RxLifecycleViewModel {
    public static <T> LifecycleTransformer<T> bindViewModel(final Observable<ViewModelEvent> lifecycle) {
        return bind(lifecycle, VIEW_LIFECYCLE);
    }

    private static final Function<ViewModelEvent, ViewModelEvent> VIEW_LIFECYCLE =
            lastEvent -> {
                switch (lastEvent) {
                    case CLEAR:
                        throw new UnsupportedOperationException("Cannot bind to Fragment lifecycle when outside of it.");

                    default:
                        throw new UnsupportedOperationException("Binding to " + lastEvent + " not yet implemented");
                }
            };
}


