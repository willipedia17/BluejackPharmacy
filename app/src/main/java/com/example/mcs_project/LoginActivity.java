package com.example.mcs_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.mcs_project.data.Data;
import com.example.mcs_project.data.Medicine;
import com.example.mcs_project.data.UserData;

import java.util.Objects;
import java.util.Vector;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmailAddress;
    EditText edtPassword;
    Button loginButton;
    Button signUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        Objects.requireNonNull(getSupportActionBar()).hide();

        edtEmailAddress = findViewById(R.id.edtEmailAddress);
        edtPassword = findViewById(R.id.edtTextPassword);

        loginButton = findViewById(R.id.loginButton);
        signUpButton = findViewById(R.id.goToRegPage);



        loginButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if(edtEmailAddress.getText().toString().equals("admin")&&edtPassword.getText().toString().equals("admin")){
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
//
//                if (Data.userDataList.isEmpty()) {
//                    Toast.makeText(getApplicationContext(), "No account registered", Toast.LENGTH_SHORT).show();
//                    return;
//                } else{
//                    for(UserData userData : Data.userDataList){
//                        if(userData.email.matches(edtEmailAddress.getText().toString())){
//                            if(userData.password.matches(edtPassword.getText().toString())){
//                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//                                Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
//                                startActivity(intent);
//                                return;
//                            }
//                        } break;
//                    }
//                    Toast.makeText(getApplicationContext(), "Invalid Credenials", Toast.LENGTH_SHORT).show();
//                }


            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }



}