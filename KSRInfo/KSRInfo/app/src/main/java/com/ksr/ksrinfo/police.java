package com.ksr.ksrinfo;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;


public class police extends AppCompatActivity {

    private EditText phoneNumberEditText;
    private Button reg;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police);

        phoneNumberEditText = findViewById(R.id.phone_number_edit_text);
        reg = findViewById(R.id.button_submit);

        mAuth = FirebaseAuth.getInstance();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneNumberEditText.getText().toString();
                if (TextUtils.isEmpty(phoneNumber)) {
                    Toast.makeText(police.this, "Please enter a phone number", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(police.this, "Complaint registered.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(police.this, registered.class);
                    startActivity(intent);
                }

            }
            });
        }
}