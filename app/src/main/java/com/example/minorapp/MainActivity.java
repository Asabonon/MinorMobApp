package com.example.minorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity {

    Button btnEnter;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;

    RelativeLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnter = findViewById(R.id.btnEnter);

        root = findViewById(R.id.root_element);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                showEnter();
            }
        } );
    }

    private void showEnter() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        LayoutInflater inflater = LayoutInflater.from(this);
        View activity_main = inflater.inflate(R.layout.activity_main, null);
        dialog.setView(activity_main);

        final MaterialEditText username = activity_main.findViewById(R.id.activity_main_usernameEditText);
        final MaterialEditText pass = activity_main.findViewById(R.id.activity_main_passwordEditText);

        dialog.setPositiveButton("Войти", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(TextUtils.isEmpty(username.getText().toString())) {
                    Snackbar.make(root, "Введите вашу почту", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(pass.getText().toString())) {
                    Snackbar.make(root, "Введите ваш пароль", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(username.getText().toString(), pass.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            startActivity(new Intent(MainActivity.this, MapActivity.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Snackbar.make(root, "Ошибка авторизации", Snackbar.LENGTH_SHORT).show();
                            }
                        });
            }
        });


    }
       /* EditText username = (EditText) findViewById(R.id.activity_main_usernameEditText);
        EditText password = (EditText) findViewById(R.id.activity_main_passwordEditText);

        public void login (View view){
            if (username.getText().toString().equals("admin")
                    && password.getText().toString().equals("admin")
            ) {

                //correcct password
            } else {
                //wrong password
            }*/


}