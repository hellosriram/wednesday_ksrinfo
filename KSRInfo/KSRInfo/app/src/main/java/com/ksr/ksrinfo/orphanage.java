package com.ksr.ksrinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class orphanage extends AppCompatActivity
{
    RecyclerView recview;
    Button addorphan;
    orphanAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orphanage);

        addorphan = findViewById(R.id.addmoreorphan);
        addorphan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(orphanage.this, regorhanages.class);
                startActivity(i);
            }
        });


        recview=(RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<orphanlist> options =
                new FirebaseRecyclerOptions.Builder<orphanlist>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("orphanage"), orphanlist.class)
                        .build();

        adapter=new orphanAdapter(options);
        recview.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}