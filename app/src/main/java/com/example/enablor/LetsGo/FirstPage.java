package com.example.enablor.LetsGo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.enablor.R;

public class FirstPage extends AppCompatActivity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 3000;
    private static final int IMAGE_CAPTURE_CODE =1001 ;
    private static final int PERMISSION_CODE = 1001;
    Uri image_uri;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_first_page);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */


                        Intent mainIntent = new Intent(FirstPage.this,SecondPage.class);
                        FirstPage.this.startActivity(mainIntent);


                FirstPage.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }


}