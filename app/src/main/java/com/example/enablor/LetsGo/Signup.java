package com.example.enablor.LetsGo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.enablor.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);






        Button btn;
        btn = (Button) findViewById(R.id.link);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validate();
                final EditText Username;
                Username = (EditText) findViewById(R.id.editText);
                final EditText Password;
                Password = (EditText) findViewById(R.id.editText2);
                final EditText Email;
                Email = (EditText) findViewById(R.id.editText3);
                final FirebaseAuth firebaseauth;

                firebaseauth = FirebaseAuth.getInstance();

                final String user_email;

                final String user_password;
                user_password = Password.getText().toString().trim();
                user_email = Email.getText().toString().trim();
                firebaseauth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Signup.this, "Registration Succeed", Toast.LENGTH_SHORT).show();
                            Intent mainIntent = new Intent(Signup.this,Dashboard.class);
                            Signup.this.startActivity(mainIntent);
                        } else {
                            Toast.makeText(Signup.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                            Intent mainIntent = new Intent(Signup.this,SecondPage.class);
                            Signup.this.startActivity(mainIntent);
                        }
                    }

                });
                TextView textView;
                textView = (TextView) findViewById(R.id.link_login);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent mainIntent = new Intent(Signup.this,Login.class);
                        Signup.this.startActivity(mainIntent);
                    }
                });
            }


            public Boolean Validate() {
                Boolean result = false;
                final EditText Username;
                Username = (EditText) findViewById(R.id.editText);
                final EditText Password;
                Password = (EditText) findViewById(R.id.editText2);
                final EditText Email;
                Email = (EditText) findViewById(R.id.editText3);
                String name = Username.getText().toString();
                String password = Password.getText().toString();
                String email = Email.getText().toString();
                if (name.isEmpty() && password.isEmpty() && email.isEmpty()) {
                    Toast.makeText(Signup.this, "Please enter correct details!!", Toast.LENGTH_SHORT);
                } else {
                    result = true;
                }
                return result;
            }


        });


    }

}