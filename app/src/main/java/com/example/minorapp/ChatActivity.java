package com.example.minorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChatActivity extends AppCompatActivity {

    Button switchToInfo;
    Button switchToWarning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        switchToInfo = findViewById(R.id.buttonInfo);
        switchToInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivitiesToInfo();
                finish();
            }
        });

        switchToWarning = findViewById(R.id.buttonWarning);
        switchToWarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivitiesToWarning();
                finish();
            }
        });
    }

    private void switchActivitiesToWarning() {
        Intent switchActivityIntent = new Intent(this, WarningActivity.class);
        startActivity(switchActivityIntent);
        finish();
    }

    private void switchActivitiesToInfo() {
        Intent switchActivityIntent = new Intent(this, InfoActivity.class);
        startActivity(switchActivityIntent);
        finish();
    }


}
