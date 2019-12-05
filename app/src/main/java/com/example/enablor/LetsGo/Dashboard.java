package com.example.enablor.LetsGo;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enablor.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class Dashboard extends AppCompatActivity {

    ArrayList<DashModel> dashModelArrayList;
    private RecyclerView recyclerView;
    DashAdapter dashAdapter;
 FirebaseDatabase firebasedatabase = FirebaseDatabase.getInstance();
 DatabaseReference myref = firebasedatabase.getReference("message");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_items);
        final FirebaseAuth firebaseauth;
        firebaseauth = FirebaseAuth.getInstance();
        onClick();
        onClick1();
        onClick2();
        onClick3();
        onClick4();
        onClick5();
        Button out = (Button) findViewById(R.id.out);
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseauth.signOut();
                Intent mainIntent = new Intent(Dashboard.this,SecondPage.class);
                Dashboard.this.startActivity(mainIntent);
            }
        });

//        recyclerView = findViewById(R.id.rv1);
//
//        dashModelArrayList = new ArrayList<>();
//        String heads[] = {"Jobs", "My Profile", "Messages", "Applied Jobs", "Resume", "Settings"};
//
//        String subs[] = {"12 new jobs found", "75% complete", "2 new messages", "3 applies jobs", "Edit resume", "Set preferences"};
//
//        int images[] = {R.drawable.find_jobs, R.drawable.profile, R.drawable.messages, R.drawable.applied_jobs,
//                R.drawable.resume,R.drawable.settings};
//
//        for(int count = 0 ; count < heads.length ; count++)
//        {
//            DashModel dashModel = new DashModel();
//            dashModel.setHead(heads[count]);
//            dashModel.setSub(subs[count]);
//            dashModel.setImage(images[count]);
//            dashModelArrayList.add(dashModel);
//            //this should be retrieved in our adapter
//        }
//        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
//        dashAdapter = new DashAdapter(dashModelArrayList);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setAdapter(dashAdapter);
//    }
    }
    public void onClick() {
        ImageView imageView;
        imageView = (ImageView) findViewById(R.id.link);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Dashboard.this, Profile.class);
                Dashboard.this.startActivity(mainIntent);
            }
        });
    }
    public void onClick1() {
        ImageView imageView;
        imageView = (ImageView) findViewById(R.id.link2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Dashboard.this, Travel.class);
                Dashboard.this.startActivity(mainIntent);
            }
        });
    } public void onClick2() {
        ImageView imageView;
        imageView = (ImageView) findViewById(R.id.link3);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Dashboard.this, Apis.class);
                Dashboard.this.startActivity(mainIntent);
            }
        });
    } public void onClick3() {
        ImageView imageView;
        imageView = (ImageView) findViewById(R.id.link4);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri location = Uri.parse("http://www.paytm.com");
                Intent mainIntent = new Intent(Intent.ACTION_VIEW,location);
                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(mainIntent,PackageManager.MATCH_DEFAULT_ONLY);
                boolean isIntentSafe = activities.size()>0;
                if(isIntentSafe){
                    Dashboard.this.startActivity(mainIntent);
                }

            }
        });
    } public void onClick4() {
        ImageView imageView;
        imageView = (ImageView) findViewById(R.id.link5);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri location = Uri.parse("http://www.googemaps.com");
                Intent mainIntent = new Intent(Intent.ACTION_VIEW,location);
                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(mainIntent,PackageManager.MATCH_DEFAULT_ONLY);
                boolean isIntentSafe = activities.size()>0;
                if(isIntentSafe){
                    Dashboard.this.startActivity(mainIntent);
                }

            }
        });
    }
    public void onClick5() {
        ImageView imageView;
        imageView = (ImageView) findViewById(R.id.link6);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Dashboard.this, Memories.class);
                Dashboard.this.startActivity(mainIntent);
            }
        });
    }






}

