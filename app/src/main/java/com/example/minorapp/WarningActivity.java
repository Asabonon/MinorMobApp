package com.example.minorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WarningActivity extends AppCompatActivity {

    Button switchToInfo;
    Button switchToChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning);

        switchToChat = findViewById(R.id.buttonChat);
        switchToChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivitiesToChat();
                finish();
            }
        });

        switchToInfo = findViewById(R.id.buttonInfo);
        switchToInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivitiesToInfo();
                finish();
            }
        });
    }

    private void switchActivitiesToInfo() {
        Intent switchActivityIntent = new Intent(this, InfoActivity.class);
        startActivity(switchActivityIntent);
    }

    private void switchActivitiesToChat() {
        Intent switchActivityIntent = new Intent(this, ChatActivity.class);
        startActivity(switchActivityIntent);
    }

}
