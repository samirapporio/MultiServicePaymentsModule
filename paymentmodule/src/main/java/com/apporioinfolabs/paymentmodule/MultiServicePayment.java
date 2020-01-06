package com.apporioinfolabs.paymentmodule;

import android.app.Application;

import com.apporioinfolabs.paymentmodule.handlers.PaymentHandler;
import com.apporioinfolabs.paymentmodule.handlers.PaymentScreenLifeCycleHandlers;
import com.stripe.android.PaymentConfiguration;

public class MultiServicePayment {

    public static MultiServicePayment.Builder mBuilder = null ;
    private static final String TAG = "TaxiSegment_TaxiSegment";

    public static MultiServicePayment.Builder startInit(Application application){
        return new MultiServicePayment.Builder(application) ;
    }

    private static void init(MultiServicePayment.Builder inBuilder) {
        // here comes the final builder object
        mBuilder = inBuilder ;
    }


    public static class Builder {
        Application mApplication;
        String mBaseUrl ;
        String mFontpath = "";
        int logo_for_paymen = 0;

        PaymentHandler mPaymentHandler;
        PaymentScreenLifeCycleHandlers mPaymentScreenLifeCycleHandlers;


        private Builder() {}

        private Builder(Application application) {
            PaymentConfiguration.init(application, "pk_test_l9snd5NmjJe7k9juheIRZh7P00y2oQcTk7");
            mApplication = application;
        }

        public Builder setBaseUrl(String baseUrl){
            mBaseUrl = baseUrl ;
            return this ;
        }

        public Builder setFontStyle(String fontpath){
            mFontpath  = fontpath ;
            return this ;
        }


        public Builder setpaymentLogo(int logo){
            logo_for_paymen = logo ;
            return this;
        }


        public Builder setonElementClickHandler(PaymentHandler paymentHandler){
            mPaymentHandler = paymentHandler;
            return this;
        }



        public Builder setScreenLifeCyclehandler(PaymentScreenLifeCycleHandlers paymentScreenLifeCycleHandlers ){
            mPaymentScreenLifeCycleHandlers = paymentScreenLifeCycleHandlers;
            return this ;
        }





        public void init() {
            MultiServicePayment.init(this);
        }

    }



}