package com.apporioinfolabs.paymentmodule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PaymentListingActivity extends BasePaymentActivity  {

    private final static String TAG = "PaymentListingActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_listing);

        findViewById(R.id.paypal_payment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



        findViewById(R.id.stripe_payment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PaymentListingActivity.this, StripePocActivity.class));
            }
        });





        findViewById(R.id.razorpay_payment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });





    }




}
