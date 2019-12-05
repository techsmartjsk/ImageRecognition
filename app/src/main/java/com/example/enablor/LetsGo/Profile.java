package com.example.enablor.LetsGo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.enablor.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;

public class Profile extends AppCompatActivity {
FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
EditText naam;
EditText food ;
EditText travel ;
EditText movie;
EditText total ;
Button submit;
EditText person;
DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bills);
        databaseReference = firebaseDatabase.getReference("users");
        naam = (EditText) findViewById(R.id.editText);
         food = (EditText) findViewById(R.id.Food);
         travel = (EditText) findViewById(R.id.Travel);
         movie = (EditText) findViewById(R.id.Movie);
        person = (EditText) findViewById(R.id.Friends);
         submit = (Button) findViewById(R.id.submit);
         total = (EditText) findViewById(R.id.Total);
         submit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                       user();
             }
         });

    }
    private void user(){
        String khana = food.getText().toString().trim();
        String name = naam.getText().toString().trim();
        String jana = travel.getText().toString().trim();
        String film= movie.getText().toString().trim();
        String bande = person.getText().toString().trim();
       String sum =  total.getText().toString().trim();
        String id = databaseReference.push().getKey();
       Users user = new Users(id,jana,sum,khana,bande);
       databaseReference.child(name).child(id).setValue(user);
        Toast.makeText(this,"User Added",Toast.LENGTH_SHORT);

    }
}
