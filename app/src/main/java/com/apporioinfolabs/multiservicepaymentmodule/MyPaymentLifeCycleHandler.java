package com.apporioinfolabs.multiservicepaymentmodule;

import android.util.Log;

import com.apporioinfolabs.paymentmodule.handlers.PaymentScreenLifeCycleHandlers;

public class MyPaymentLifeCycleHandler implements PaymentScreenLifeCycleHandlers {


    @Override
    public void onScreenLifeCycle(String screenName, String lifeCycleMethod) {
        Log.d("&&&&&&&&&", ""+screenName+": "+lifeCycleMethod);
    }
}
