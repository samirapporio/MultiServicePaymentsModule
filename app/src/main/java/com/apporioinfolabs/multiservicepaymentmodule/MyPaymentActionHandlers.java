package com.apporioinfolabs.multiservicepaymentmodule;

import android.app.Activity;
import android.content.Context;

import com.apporioinfolabs.paymentmodule.handlers.PaymentActionHandlers;

public class MyPaymentActionHandlers implements PaymentActionHandlers {
    @Override
    public void onpaymentSuccess(int paymentMode, String data) {

    }

    @Override
    public void onAction(Activity activity, Context context, String screenName, int actionName, String data) {
        // this is where all actions of payment modules will come accordingly
    }
}
