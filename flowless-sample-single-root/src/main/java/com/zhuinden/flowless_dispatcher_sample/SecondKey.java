package com.zhuinden.flowless_dispatcher_sample;

import com.google.auto.value.AutoValue;
import com.zhuinden.flowless_dispatcher_sample.extracted.FlowAnimation;
import com.zhuinden.flowless_dispatcher_sample.extracted.LayoutKey;

/**
 * Created by Zhuinden on 2016.06.28..
 */
@AutoValue
public abstract class SecondKey
        implements LayoutKey {
    public static SecondKey create() {
        return new AutoValue_SecondKey(R.layout.path_second, FlowAnimation.SEGUE);
    }
}
