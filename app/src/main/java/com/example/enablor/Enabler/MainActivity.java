package com.example.enablor.Enabler;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.view.View;

import com.example.enablor.R;
import com.example.enablor.Util.NetworkClient;
import com.example.enablor.Util.UploadAPIs;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final int IMAGE_CAPTURE_CODE =1001 ;
    private static final int PERMISSION_CODE = 1001;
    FloatingActionButton mbt;
    ImageView mvw;
    Uri image_uri;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onWindowFocusChanged(true);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        openCamera();
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Authenticating your information from our database...");
        progressDialog.setTitle("Processing");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        progressDialog.setCancelable(false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(9000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                progressDialog.dismiss();


            }
        }).start();

        mvw = findViewById(R.id.image_view);
     onClick();
        
    }



    public void openCamera(){

        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE,"New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION,"Camera");
        image_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        // Intent
        Intent CameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        CameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri);
        startActivityForResult(CameraIntent, IMAGE_CAPTURE_CODE);

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_name) {
//            Toast.makeText(this, "Tapped Name", Toast.LENGTH_SHORT).show();
//        }
//        if (id == R.id.action_photo) {
//            Toast.makeText(this, "Tapped Photo", Toast.LENGTH_SHORT).show();
//        }
//        if (id == R.id.action_signout) {
//            Toast.makeText(this, "Sign Out?", Toast.LENGTH_SHORT).show();
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK) {
//            mvw.setImageURI(image_uri);
//            Toast.makeText(getApplicationContext(),String.valueOf(image_uri),Toast.LENGTH_LONG).show();
//            uploadToServer(image_uri.getPath());
//
//        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode){
            case (int) PERMISSION_CODE:{
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    openCamera();

                }
                    else{
                    int text;
                    Toast.makeText(this,"Permission denied",Toast.LENGTH_SHORT).show();

                }
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + requestCode);
        }
    }
    private void uploadToServer(String  filePath) {
        Retrofit retrofit = NetworkClient.getRetrofitClient(this);

        UploadAPIs uploadAPIs = retrofit.create(UploadAPIs.class);
//        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
//        File directory = contextWrapper.getDir(folderName, Context.MODE_PRIVATE);

        //Create a file object using file path
        File file = new File(filePath);

        // Create a request body with file and image media type
        RequestBody fileReqBody = RequestBody.create(MediaType.parse("image/*"), file);

        // Create MultipartBody.Part using file request-body,file name and part name
        MultipartBody.Part part = MultipartBody.Part.createFormData("upload", file.getName(), fileReqBody);

        //Create request body with text description and text media type
        RequestBody description = RequestBody.create(MediaType.parse("text/plain"), "image-type");

        //
        Call call = uploadAPIs.uploadImage(part, description);

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
//               Intent here
                Intent mainIntent = new Intent(MainActivity.this,Main3Activity.class);
                MainActivity.this.startActivity(mainIntent);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("MainActivity","Status Code="+t.getMessage());
            }
        });

    }

    private void show() {
    }
    public void onClick() {
        TextView textView;
        textView = (TextView) findViewById(R.id.link);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(MainActivity.this, MainActivity4.class);
                MainActivity.this.startActivity(mainIntent);
            }
        });

    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}