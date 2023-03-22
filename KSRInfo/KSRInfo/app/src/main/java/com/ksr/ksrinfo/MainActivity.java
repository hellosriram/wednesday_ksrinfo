package com.ksr.ksrinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.VideoView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private VideoView videoView;
    private Button continuebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        continuebtn = findViewById(R.id.continuebtn);

        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseUser currentUser = mAuth.getCurrentUser();
                if (currentUser != null) {
                    Intent i = new Intent(MainActivity.this, home.class);
                    startActivity(i);
                    finish();
                }

                else {
                    Intent intent
                            = new Intent(MainActivity.this, login.class);
                    startActivity(intent);
                }
            }
        });

    }
}