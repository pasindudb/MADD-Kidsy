package com.example.kidsy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Deliver extends AppCompatActivity {

   private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle dtoggle;

    private FirebaseDatabase database;
    private DatabaseReference payref;
    private Button btn;
    EditText ddelid,dorderid,ddelfirst,ddeladdress,ddelqty,ddeldate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver);

        drawerLayout = findViewById(R.id.deliverlay);
        dtoggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.hopen, R.string.hclose);
        dtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ddelid=findViewById(R.id.delid);
        dorderid=findViewById(R.id.orderid);
        ddelfirst=findViewById(R.id.delfirst);
        ddeladdress=findViewById(R.id.deladdress);
        ddelqty=findViewById(R.id.delqty);
        ddeldate=findViewById(R.id.deldate);


        btn = findViewById(R.id.btndeliver);
        addDeliver();

    }

    private void addDeliver() {
        database = FirebaseDatabase.getInstance();
        payref = database.getReference("DeliverData");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String delid = ddelid.getText().toString();
                String orderid = dorderid.getText().toString() ;
                String delfirst = ddelfirst.getText().toString();
                String deladdress = ddeladdress.getText().toString();
                String delqty = ddelqty.getText().toString();
                String deldate = ddeldate.getText().toString();

                if(TextUtils.isEmpty(delid)){
                    ddelid.setError("Please Enter the Deliver ID");
                    return;
                }
                if(TextUtils.isEmpty(orderid)){
                    dorderid.setError("Please Enter the Order ID");
                    return;
                }
                if(TextUtils.isEmpty(delfirst)){
                    ddelfirst.setError("First Name can not be empty");
                    return;
                }

                if(TextUtils.isEmpty(deladdress)){
                    ddeladdress.setError("Please Enter the Postal Address");
                    return;
                }


                if(TextUtils.isEmpty(delqty)){
                    ddelqty.setError("Please enter nunmber of books");
                    return;
                }
                if(TextUtils.isEmpty(deldate)){
                    ddeldate.setError("Please enter order delivered date");
                    return;
                }

                long mDateTime = 9999999999999L - System.currentTimeMillis();
                String mOrderTime = String.valueOf(mDateTime);

                DeliverData deliverData = new DeliverData(delid,orderid,delfirst,deladdress,delqty,deldate);
                payref.child(mOrderTime).setValue(deliverData).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(),"Order Delivered Successfully",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Cannot Complete the Order. Try again Later.",Toast.LENGTH_SHORT).show();
                    }
                });
            }


        });
    }


    public void openDeliver(){
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