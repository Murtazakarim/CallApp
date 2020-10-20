package com.example.callapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sinch.android.rtc.Sinch;
import com.sinch.android.rtc.SinchClient;
import com.sinch.android.rtc.calling.CallClient;

public class MainActivity extends AppCompatActivity {

    Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = findViewById(R.id.btnCall);

        // Instantiate a SinchClient using the SinchClientBuilder.
        android.content.Context context = this.getApplicationContext();
        final SinchClient sinchClient = Sinch.getSinchClientBuilder().context(context)
                .applicationKey("c81ad825-2a44-4118-9b0e-edaa1bed7051")
                .applicationSecret("Wq37qKmHUUq/fkbk4Fd71A==")
                .environmentHost("clientapi.sinch.com")
                .userId("149051")
                .build();
        sinchClient.setSupportCalling(true);
        sinchClient.start();

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallClient callClient = sinchClient.getCallClient();
                callClient.callPhoneNumber("+923123865506");
            }
        });
    }
}
