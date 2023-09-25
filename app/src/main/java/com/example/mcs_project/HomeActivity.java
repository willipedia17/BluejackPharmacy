package com.example.mcs_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mcs_project.fragment.HomeFragment;
import com.example.mcs_project.fragment.TransactionFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends FragmentActivity {

    BottomNavigationView navBar;
    Button logOut, abtUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navBar = findViewById(R.id.navBar);
        navBar.setOnItemSelectedListener(item -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            switch (item.getItemId()){
                case R.id.myHome:
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, HomeFragment.class, null).commit();
                    return true;
                case R.id.transaction:
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, TransactionFragment.class, null).commit();
                    return true;
                default:
                    return false;
            }
        });

        logOut = findViewById(R.id.logOut);

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        abtUs = findViewById(R.id.aboutUs_home);
        abtUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AboutUsActivity.class));
            }
        });



    }



}