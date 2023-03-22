package com.ksr.ksrinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class policehome extends AppCompatActivity {

    Button stations, newcom, registered;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policehome);

            stations = findViewById(R.id.stations);
           newcom=findViewById(R.id.newcomplaint);
           registered=findViewById(R.id.reg_complaints);

           stations.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent= new Intent(policehome.this, policedetails.class);
                   startActivity(intent);
               }
           });

        newcom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(policehome.this,police.class);
                startActivity(intent);
            }

        });
        registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(policehome.this, "No complaints available!", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(policehome.this, police_status.class);
                //startActivity(intent);
            }
        });

    }
}