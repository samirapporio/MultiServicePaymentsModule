package com.apporioinfolabs.paymentmodule.handlers;

import android.app.Activity;
import android.content.Context;

public interface PaymentScreenLifeCycleHandlers {
    void onScreenLifeCycle(Activity activity, Context context, String screenName, String lifeCycleMethod );
}
