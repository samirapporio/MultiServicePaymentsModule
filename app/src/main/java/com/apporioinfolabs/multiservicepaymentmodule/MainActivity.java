package com.apporioinfolabs.multiservicepaymentmodule;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.apporioinfolabs.paymentmodule.PaymentListingActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.payment_module).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this , PaymentListingActivity.class));
            }
        });
    }
}
