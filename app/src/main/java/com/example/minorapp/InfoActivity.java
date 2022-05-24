package com.example.minorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoActivity extends AppCompatActivity {

    Button switchToChat;
    Button switchToWarning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        switchToChat = findViewById(R.id.buttonChat);
        switchToChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivitiesToChat();
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
    }

    private void switchActivitiesToChat() {
        Intent switchActivityIntent = new Intent(this, ChatActivity.class);
        startActivity(switchActivityIntent);
    }
}