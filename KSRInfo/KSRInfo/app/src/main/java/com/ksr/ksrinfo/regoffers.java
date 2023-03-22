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

public class regoffers extends AppCompatActivity {

    private EditText stallName, stallEmail, stallOffer;
    private Button regStall;

    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;

    // creating a variable for
    // our object class
    offerInfo offerinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regoffers);

        stallName = findViewById(R.id.stall_name);
        stallEmail = findViewById(R.id.stall_email);
        stallOffer = findViewById(R.id.stall_offer);

        // below line is used to get the
        // instance of our FIrebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference("reg_offers");

        // initializing our object
        // class variable.
        offerinfo = new offerInfo();

        regStall = findViewById(R.id.reg_offers);

        // adding on click listener for our button.
        regStall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting text from our edittext fields.
                String name = stallName.getText().toString();
                String email = stallEmail.getText().toString();
                String offer = stallOffer.getText().toString();

                // below line is for checking whether the
                // edittext fields are empty or not.
                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(email) && TextUtils.isEmpty(offer)) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(regoffers.this, "Please fill all data", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to our database.
                    addDatatoFirebase(name, email, offer);
                }
            }
        });
    }

    private void addDatatoFirebase(String name, String phone, String offer) {
        // below 3 lines of code is used to set
        // data in our object class.
        offerinfo.setStallName(name);
        offerinfo.setStallEmail(phone);
        offerinfo.setStallOffer(offer);

        // we are use add value event listener method
        // which is called with database reference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                databaseReference.setValue(offerinfo);

                // after adding this data we are showing toast message.
                Toast.makeText(regoffers.this, "Successfully added!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(regoffers.this, registered.class);
                startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(regoffers.this, "Something went wrong! Try again later.." + error, Toast.LENGTH_SHORT).show();
            }
        });


    }
}