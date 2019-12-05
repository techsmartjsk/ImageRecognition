package com.example.enablor.LetsGo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.enablor.R;

public class Apis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apis);
        onClick();
        onClick1();
        onClick2();
        onClick3();
    }
    public void onClick() {
        ImageView imageView;
        imageView = (ImageView) findViewById(R.id.link);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ubereats.com"));
                Apis.this.startActivity(mainIntent);
            }
        });
    }
    public void onClick1() {
        ImageView imageView;
        imageView = (ImageView) findViewById(R.id.link2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.zomato.com"));
                Apis.this.startActivity(mainIntent);
            }
        });
    }public void onClick2() {
        ImageView imageView;
        imageView = (ImageView) findViewById(R.id.link3);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.foodpanda.com"));
                Apis.this.startActivity(mainIntent);
            }
        });
    }public void onClick3() {
       ImageView imageView;
        imageView = (ImageView) findViewById(R.id.link4);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.swiggy.com"));
                Apis.this.startActivity(mainIntent);
            }
        });
    }


}
