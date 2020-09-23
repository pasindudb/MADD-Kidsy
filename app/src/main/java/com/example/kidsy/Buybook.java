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

public class Buybook extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle dtoggle;

    private Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buybook);

        drawerLayout = findViewById(R.id.buynowlay);
        dtoggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.hopen, R.string.hclose);
        dtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

   /*     btn = findViewById(R.id.btnbuynow);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPaymentinfo();
            }
        });
*/
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (dtoggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
 /*   public void openPaymentinfo(){
        Intent intent = new Intent(this,Paymentinfo.class);
        startActivity(intent);
    }
}

  */
}