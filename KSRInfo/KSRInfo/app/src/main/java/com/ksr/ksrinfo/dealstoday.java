package com.ksr.ksrinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dealstoday extends AppCompatActivity {

    Button deals, regstore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealstoday);

        deals = findViewById(R.id.deals);
        regstore = findViewById(R.id.reg_store);

        deals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dealstoday.this, offer.class);
                startActivity(intent);
            }
        });
        regstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dealstoday.this, regoffers.class);
                startActivity(intent);
            }
        });
    }
}