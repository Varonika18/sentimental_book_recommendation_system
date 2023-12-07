package com.example.sentimental_book_recommendation_system;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.*;

public class MainActivity3 extends AppCompatActivity{

     LinearLayout layouthome,layoutbook,layoutmore;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        LinearLayout layouthome=findViewById(R.id.faghome);
        LinearLayout layoutbook=findViewById(R.id.fagmy);
        LinearLayout layoutmore=findViewById(R.id.fagmore);

        loadFragment(new FirstFragment(),0);

        layouthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              loadFragment(new FirstFragment(),1);
            }
        });

        layoutbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new SecondFragment(),1);
            }
        });

        layoutmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.add(R.id.container,new ThirdFragment());
                ft.commit();

            }
        });


    }

    private void loadFragment(Fragment fragment,int flag) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(flag==0){
            ft.add(R.id.container,fragment);
        }
        else{
            ft.replace(R.id.container,fragment);
        }
        ft.commit();
    }


}
