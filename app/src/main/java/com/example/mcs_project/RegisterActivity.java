package com.example.mcs_project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mcs_project.data.Data;
import com.example.mcs_project.data.UserData;

import java.util.Objects;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity{
    EditText edtFullName, edtTextPhone, edtEmailAddress, edtPassword, edtConfirmPassword;
    Button registerButton, signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Log.i("Register Activity", "onCreate");
        Objects.requireNonNull(getSupportActionBar()).hide();

        edtFullName = findViewById(R.id.edtFullName);
        edtTextPhone = findViewById(R.id.edtTextPhone);
        edtEmailAddress = findViewById(R.id.edtEmailAddress);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        registerButton = findViewById(R.id.registerButton);
        signInButton = findViewById(R.id.goToLoginPage);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtFullName.getText().toString().length()<5){
                    Toast.makeText(getApplicationContext(),
                            "Name must be filled by at least 5 characters", Toast.LENGTH_SHORT).show();
                    return;
                } else if (edtTextPhone.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "Phone number must be filled", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!edtEmailAddress.getText().toString().endsWith(".com")) {
                    Toast.makeText(getApplicationContext(),
                            "Invalid email address", Toast.LENGTH_SHORT).show();
                    return;
                } else if (isValidPassword(edtPassword.getText().toString()) == null) {
                    Toast.makeText(getApplicationContext(),
                            "Password must be alphanumeric\nMin 6 characters", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!edtPassword.getText().toString().equals(edtConfirmPassword.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_SHORT).show();
                    return;
                }
                Data.userDataList.
                        add(new UserData
                                (Data.userDataList.size(), edtFullName.getText().toString(),
                                        edtTextPhone.getText().toString(),
                                        edtEmailAddress.getText().toString(),
                                        edtPassword.getText().toString()));

//                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                Toast.makeText(getApplicationContext(), "Account succesfully registered", Toast.LENGTH_SHORT).show();
//                startActivity(intent);
                finish();
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    String isValidPassword(String password) {

        Pattern regex;
        boolean matcher;

        regex = Pattern.compile("^(?=.*[0-9])((?=.*[a-z])|(?=.*[A-Z])).{4,}$");
        matcher = regex.matcher(password).matches();

        if(matcher){
            return password;
        }
        return null;
    }
}