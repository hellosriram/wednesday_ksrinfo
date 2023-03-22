package com.ksr.ksrinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class orphanagehome extends AppCompatActivity {

    Button orphans, register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orphanagehome);

        orphans = findViewById(R.id.orphanages);
        register = findViewById(R.id.reg_orphanage);

        orphans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(orphanagehome.this, orphanage.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(orphanagehome.this, regorhanages.class);
                startActivity(intent);
            }
        });
    }
}