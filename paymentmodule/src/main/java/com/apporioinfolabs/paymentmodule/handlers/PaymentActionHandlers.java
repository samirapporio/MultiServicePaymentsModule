package com.apporioinfolabs.paymentmodule.handlers;

import android.app.Activity;
import android.content.Context;

public interface PaymentActionHandlers {

    void onpaymentSuccess(int paymentMode, String data);

    void onAction(Activity activity, Context context, String screenName, int actionName, String data);

}
