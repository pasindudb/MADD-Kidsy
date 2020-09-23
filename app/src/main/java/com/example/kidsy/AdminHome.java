package com.example.kidsy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class AdminHome extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle dtoggle;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        drawerLayout = findViewById(R.id.adminhomelayout1);
        dtoggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.hopen,R.string.hclose);
        drawerLayout.addDrawerListener(dtoggle);
        dtoggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView= findViewById(R.id.adminhomenav);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id =item.getItemId();

                    if(id==R.id.dashpayments) {
                        startActivity(new Intent(getApplicationContext(), ReadPaymentinfo.class));
                    }
                    else if(id==R.id.dashdelivers){
                        startActivity(new Intent(getApplicationContext(),Admindeliver.class));
                }
                return true;
            }
        });




/*
        btn = findViewById(R.id.homebtnusers);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUser();
            }
        });

        btn = findViewById(R.id.homebtnbooks);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBook();
            }
        });

        btn = findViewById(R.id.homebtnnewspapers);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewspaper();
            }
        });

        btn = findViewById(R.id.homebtnentertainment);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEntertainment();
            }
        });
*/
        btn = findViewById(R.id.homebtnpayments);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPaymentinfo();
            }
        });

        btn = findViewById(R.id.homebtndelivers);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDeliver();
            }
        });

        btn = findViewById(R.id.pay);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPay();
            }
        });

    }
/*
    public void openUser(){
        Intent intent = new Intent(this,Adminuser.class);
        startActivity(intent);
    }
    public void openBook(){
        Intent intent = new Intent(this,Adminbook.class);
        startActivity(intent);
    }
    public void openNewspaper(){
        Intent intent = new Intent(this,Adminnews.class);
        startActivity(intent);
    }
    public void openEntertainment(){
        Intent intent = new Intent(this,Adminentertainment.class);
        startActivity(intent);
    }
*/
    public void openPaymentinfo(){
        Intent intent = new Intent(this,ReadPaymentinfo.class);
        startActivity(intent);
    }

    public void openDeliver(){
        Intent intent = new Intent(this,Admindeliver.class);
        startActivity(intent);
    }
    public void openPay(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(dtoggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}