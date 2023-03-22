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

public class policedetails extends AppCompatActivity
{
    RecyclerView recview;
    Button addorphan;
    policedetailsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policedetails);

        addorphan = findViewById(R.id.addmoreorphan);
        addorphan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(policedetails.this, web.class);
                i.putExtra("browserlink","https://docs.google.com/forms/d/e/1FAIpQLSeGc-yVYE6wJBE0OVxzIoLf5MNc7cWsz39cBQYhL_6WPIyjUg/viewform?usp=sf_link");
                startActivity(i);
            }
        });


        recview=(RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<policelist> options =
                new FirebaseRecyclerOptions.Builder<policelist>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("police/stations"), policelist.class)
                        .build();

        adapter=new policedetailsAdapter(options);
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