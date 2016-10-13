package com.wolfhackers.counsellink;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wolfhackers.counsellink.R;

public class RejectClass extends AppCompatActivity {

    private TextView notificationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reject_class);
        notificationText = (TextView) findViewById(R.id.textView);
        notificationText.setText("Reject");
    }
}