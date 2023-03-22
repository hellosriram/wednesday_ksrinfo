package com.ksr.ksrinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class regorhanages extends AppCompatActivity {

    private EditText orphanName, orphanEmail, orphanAddress;
    private Button regorphan;

    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;

    // creating a variable for
    // our object class
    orphanInfo orphaninfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regorhanages);

        orphanName = findViewById(R.id.orphan_name);
        orphanEmail = findViewById(R.id.orphan_email);
        orphanAddress = findViewById(R.id.orphan_address);

        // below line is used to get the
        // instance of our FIrebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference("reg_orphanages");

        // initializing our object
        // class variable.
        orphaninfo = new orphanInfo();

        regorphan = findViewById(R.id.reg_orphan);

        // adding on click listener for our button.
        regorphan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting text from our edittext fields.
                String name = orphanName.getText().toString();
                String email = orphanEmail.getText().toString();
                String address = orphanAddress.getText().toString();

                // below line is for checking whether the
                // edittext fields are empty or not.
                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(email) && TextUtils.isEmpty(address)) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(regorhanages.this, "Please fill all data", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to our database.
                    addDatatoFirebase(name, email, address);
                }
            }
        });
    }

    private void addDatatoFirebase(String name, String phone, String address) {
        // below 3 lines of code is used to set
        // data in our object class.
        orphaninfo.setOrphanName(name);
        orphaninfo.setOrphanEmail(phone);
        orphaninfo.setOrphanAddress(address);

        // we are use add value event listener method
        // which is called with database reference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                databaseReference.setValue(orphaninfo);

                // after adding this data we are showing toast message.
                Toast.makeText(regorhanages.this, "Successfully added!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(regorhanages.this, registered.class);
                startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(regorhanages.this, "Something went wrong! Try again later.." + error, Toast.LENGTH_SHORT).show();
            }
        });


    }
}