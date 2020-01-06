package com.apporioinfolabs.paymentmodule;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.apporioinfolabs.paymentmodule.utils.PaymentModuleActions;
import com.apporioinfolabs.paymentmodule.utils.PaymentModuleScreens;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stripe.android.ApiResultCallback;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.PaymentIntentResult;
import com.stripe.android.Stripe;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.view.CardInputWidget;

import org.json.JSONObject;

import java.lang.ref.WeakReference;

public class StripePocActivity extends BasePaymentActivity {


    private Stripe stripe ;
    private CardInputWidget cardInputWidget ;
    private Button payButton   ;
    private LinearLayout pryment_processing_layout ;
    private static final String TAG  = "StripePocActivity";
    private EditText amount ;
    private Gson gson ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stripe_poc);
        cardInputWidget = findViewById(R.id.cardInputWidget);
        payButton = findViewById(R.id.payButton);
        amount = findViewById(R.id.amount);
        pryment_processing_layout = findViewById(R.id.pryment_processing_layout);

        gson = new GsonBuilder().create();

        findViewById(R.id.show_publishable_key).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StripePocActivity.this, ""+PaymentConfiguration.getInstance(StripePocActivity.this.getApplicationContext()).getPublishableKey(), Toast.LENGTH_LONG).show();
            }
        });


        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(amount.getText().toString().equals("")){
                    Toast.makeText(StripePocActivity.this, "No Amount", Toast.LENGTH_SHORT).show();
                }else{
                    try{
                        fetchTokenFromServer( (Integer.parseInt(""+amount.getText().toString()) * 100));
                    }catch (Exception e){
                        Toast.makeText(StripePocActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });



    }

//
//    public void startCheckOut(){
//        new OkHttpClient().newCall(request)
//                .enqueue(new PayCallback(this));
//    }


    private void fetchTokenFromServer(Integer amount) throws Exception{
        pryment_processing_layout.setVisibility(View.VISIBLE);
        payButton.setVisibility(View.GONE);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("amount",""+amount);
        jsonObject.put("currency","INR");
        Toast.makeText(this, ""+jsonObject, Toast.LENGTH_SHORT).show();

        AndroidNetworking.post("http://api.gentleguest.net/api/v1/app/util")
                .addJSONObjectBody(jsonObject)
                .setPriority(Priority.LOW).build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        pryment_processing_layout.setVisibility(View.GONE);
                        payButton.setVisibility(View.VISIBLE);
                        ModelSecret modelSecret = gson.fromJson(response, ModelSecret.class);
                        try{
                            startpaymentFromCard(""+modelSecret.getClient_secret());
                        }catch (Exception e){
                            Toast.makeText(StripePocActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }


                    }
                    @Override
                    public void onError(ANError anError) {
                        pryment_processing_layout.setVisibility(View.GONE);
                        payButton.setVisibility(View.VISIBLE);
                        Toast.makeText(StripePocActivity.this, ""+anError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
        });
    }

    private void startpaymentFromCard(String payment_client_secret) throws Exception{
        PaymentMethodCreateParams params = cardInputWidget.getPaymentMethodCreateParams();
        if (params != null) {
            ConfirmPaymentIntentParams confirmParams = ConfirmPaymentIntentParams
                    .createWithPaymentMethodCreateParams(params, payment_client_secret);
            stripe = new Stripe(StripePocActivity.this, PaymentConfiguration.getInstance(StripePocActivity.this).getPublishableKey());
            stripe.confirmPayment(StripePocActivity.this, confirmParams);
        }else {
            Toast.makeText(StripePocActivity.this, "payment params are null. ", Toast.LENGTH_SHORT).show();
        }
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Handle the result of stripe.confirmPayment
        stripe.onPaymentResult(requestCode, data, new PaymentResultCallback(this));
    }

    // ...

    private final class PaymentResultCallback
            implements ApiResultCallback<PaymentIntentResult> {
        @NonNull private final WeakReference<StripePocActivity> activityRef;

        PaymentResultCallback(@NonNull StripePocActivity activity) {
            activityRef = new WeakReference<>(activity);
        }

        @SuppressLint("LongLogTag")
        @Override
        public void onSuccess(@NonNull PaymentIntentResult result) {
            final StripePocActivity activity = activityRef.get();
            if (activity == null) {
                return;
            }

            PaymentIntent paymentIntent = result.getIntent();
            PaymentIntent.Status status = paymentIntent.getStatus();
            if (status == PaymentIntent.Status.Succeeded) {
                Log.d("**********"+TAG , "payment completed successfully now parse data from it ");
                MultiServicePayment.mBuilder.mPaymentActionHandlers.onAction(StripePocActivity.this, StripePocActivity.this, PaymentModuleScreens.StripePocActivity, PaymentModuleActions.StripCardPayment_Success, "SUCCESS RESPONSE");
//                // Payment completed successfully
//                Gson gson = new GsonBuilder().setPrettyPrinting().create();
//                activity.displayAlert(
//                        "Payment completed",
//                        gson.toJson(paymentIntent),
//                        true
//                );
            } else if (status == PaymentIntent.Status.RequiresPaymentMethod) {
//                // Payment failed
//                activity.displayAlert(
//                        "Payment failed",
//                        Objects.requireNonNull(paymentIntent.getLastPaymentError()).message,
//                        false
//                );

                Log.d("**********"+TAG , "Payment failed due to some reason , that will be find in coming object");
                MultiServicePayment.mBuilder.mPaymentActionHandlers.onAction(StripePocActivity.this, StripePocActivity.this, PaymentModuleScreens.StripePocActivity, PaymentModuleActions.StripCardPayment_Success, "SUCCESS FAILED");

            }
        }

        @Override
        public void onError(@NonNull Exception e) {
            PaymentModuleLogs.e("**********"+TAG , "Exception caught "+e.getMessage());
            MultiServicePayment.mBuilder.mPaymentActionHandlers.onAction(StripePocActivity.this, StripePocActivity.this, PaymentModuleScreens.StripePocActivity, PaymentModuleActions.StripCardPayment_ERROR, "SUCCESS ERROR");
//            final StripePocActivity activity = activityRef.get();
//            if (activity == null) {
//                return;
//            }
//
//            // Payment request failed – allow retrying using the same payment method
//            activity.displayAlert("Error", e.toString(), false);
        }
    }
    

}
