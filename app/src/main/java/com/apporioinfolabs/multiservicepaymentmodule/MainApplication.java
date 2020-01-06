package com.apporioinfolabs.multiservicepaymentmodule;

import android.app.Application;
import com.apporioinfolabs.paymentmodule.MultiServicePayment;

public class MainApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        MultiServicePayment.startInit(this)
                .setBaseUrl("Some base url goes here ")
                .setFontStyle("")
                .setpaymentLogo(R.drawable.logo_multiservice_payment_circular)
                .setonElementClickHandler(new MyPaymentActionHandlers())
                .setScreenLifeCyclehandler(new MyPaymentLifeCycleHandler())
                .init();
    }
}
