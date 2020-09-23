package com.example.kidsy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle dtoggle;

    private Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.homelayout1);
        dtoggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.hopen,R.string.hclose);
        dtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        btn = findViewById(R.id.homebtnbooks);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBuybook();
            }
        });

        btn = findViewById(R.id.homebtnnewspapers);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPaymentinfo();
            }
        });

        btn = findViewById(R.id.homebtnentertainment);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDeliver();
            }
        });

        btn = findViewById(R.id.homebtnorders);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyorders();
            }
        });

    }
    public void openBuybook(){
        Intent intent = new Intent(this,ReadPaymentinfo.class);
        startActivity(intent);
    }
    public void openPaymentinfo(){
        Intent intent = new Intent(this,Paymentinfo.class);
        startActivity(intent);
    }

    public void openDeliver(){
        Intent intent = new Intent(this,Deliver.class);
        startActivity(intent);
    }

    public void openMyorders(){
        Intent intent = new Intent(this,ReadDeliverinfo.class);
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
    /* private void moveTo(){
        Intent intent=new Intent(MainActivity.this,Myorders.class);
        startActivity(intent);
    }*/


