package com.example.enablor.LetsGo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.enablor.R;

public class SecondPage extends AppCompatActivity {
TextView textview;
TextView textview2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        textview = (TextView) findViewById(R.id.button);
            textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(SecondPage.this,Signup.class);
                SecondPage.this.startActivity(mainIntent);
            }
        });
        textview2 = (TextView) findViewById(R.id.login);
        textview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(SecondPage.this,Login.class);
                SecondPage.this.startActivity(mainIntent);
            }
        });
    }

}
