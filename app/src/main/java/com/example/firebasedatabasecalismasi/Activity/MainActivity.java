package com.example.firebasedatabasecalismasi.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.firebasedatabasecalismasi.Adapter.HaberAdapter;
import com.example.firebasedatabasecalismasi.Model.Haber;
import com.example.firebasedatabasecalismasi.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    ArrayList<Haber> haberler= new ArrayList<>();
    HaberAdapter haberAdapter;


    FirebaseDatabase database;
    DatabaseReference myRef;

    public void haberEkle(Haber haber){
    //firebase veritabanına veri eklemek için gerekli metot.
        DatabaseReference dbRef =FirebaseDatabase.getInstance().getReference().child("haberler");

        dbRef.push().setValue(
                new Haber(
                        haber.getHaberBaslik(),
                        haber.getHaberIcerik(),
                        haber.getHaberResim()
        ));
    }



    //
    public ArrayList<Haber> haberGetir(){
        final ArrayList<Haber> haberler= new ArrayList<>();

        myRef.child("haberler").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                haberler.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    Haber haber = snapshot.getValue(Haber.class);
                    haberler.add(
                            new Haber(
                                    haber.getHaberBaslik(),
                                    haber.getHaberIcerik(),
                                    haber.getHaberResim()
                            )
                    );
                }

                haberAdapter= new HaberAdapter(haberler,getApplicationContext());
                listView.setAdapter(haberAdapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {}

        });
        return haberler;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);


        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();


        Haber haber2= new Haber();
        haber2.setHaberBaslik("Ülke Gündemi");
        haber2.setHaberIcerik("Ekonomik kriz hangi ülkeleri vurdu?");
       // haber1.setHaberResim(R.drawable.ic_launcher_background);
        haberEkle(haber2);

        haberler= haberGetir();

        // Write a message to the database

       /*FirebaseDatabase database = FirebaseDatabase.getInstance();
       DatabaseReference myRef = database.getReference("message2");

       myRef.setValue("Hello, Worldoo!");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //satır verisinin
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("DILARA", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("DILARA", "Failed to read value.", error.toException());
            }
        });*/

    }
}
