package com.ksr.ksrinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class hospitalhome extends AppCompatActivity {

    Button hospitals, appointment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitalhome);

        hospitals = findViewById(R.id.hospitals);
        appointment = findViewById(R.id.appointment);

        hospitals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(hospitalhome.this, "Not available yet..", Toast.LENGTH_SHORT).show();
            }
        });

        appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(hospitalhome.this, "Not available yet..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}