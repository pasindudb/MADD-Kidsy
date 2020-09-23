package com.example.kidsy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
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
import com.example.kidsy.PaymentData;
public class Paymentinfo extends AppCompatActivity {

        private FirebaseDatabase database;
        private DatabaseReference payref;

    EditText epayid,epayfirstname,epayemail,epayaddress,epaycardnumber,epaycardowner,epaycardexpiredate,epaybookname,epayqty,epaytotalprice,epaydate;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle dtoggle;

    private Button btn,updatepay;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentinfo);

        drawerLayout = findViewById(R.id.paylay);
        dtoggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.hopen, R.string.hclose);
        dtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        epayid = findViewById(R.id.payid);
        epayfirstname = findViewById(R.id.payfirstname);
        epayemail = findViewById(R.id.payemail);
        epayaddress = findViewById(R.id.payaddress);
        epaycardnumber = findViewById(R.id.paycardnumber);
        epaycardowner = findViewById(R.id.paycardowner);
        epaycardexpiredate = findViewById(R.id.paycardexpiredate);
        epaybookname = findViewById(R.id.paybookname);
        epayqty = findViewById(R.id.payqty);
        epaytotalprice = findViewById(R.id.paytotalprice);
        epaydate = findViewById(R.id.paydate);

        btn = findViewById(R.id.btnpaycomplete);
        addPayment();

        updatepay = findViewById(R.id.btneditpay);


        btn = findViewById(R.id.btnpaycancel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCancel();
            }
        });
    }



    private void addPayment() {
        database = FirebaseDatabase.getInstance();
        payref = database.getReference("PaymentData");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String payid = epayid.getText().toString();
                String payfirstname = epayfirstname.getText().toString();
                String payemail = epayemail.getText().toString();
                String payaddress = epayaddress.getText().toString();
                String paycardnumber = epaycardnumber.getText().toString();
                String paycardowner = epaycardowner.getText().toString();
                String paycardexpiredate = epaycardexpiredate.getText().toString();
                String paybookname = epaybookname.getText().toString();
                String payqty = epayqty.getText().toString();
                String paytotalprice = epaytotalprice.getText().toString();
                String paydate = epaydate.getText().toString();

                if(TextUtils.isEmpty(payfirstname)){
                    epayfirstname.setError("First Name can not be empty");
                    return;
                }

                if(TextUtils.isEmpty(payemail)){
                    epayemail.setError("Please enter the Email");
                    return;
                }

                if(TextUtils.isEmpty(payaddress)){
                    epayaddress.setError("Address Field can not be empty");
                    return;
                }

                if(TextUtils.isEmpty(paycardnumber)){
                    epaycardnumber.setError("You must enter the Credit Card Number");
                    return;
                }
                if(TextUtils.isEmpty(paycardowner)){
                    epaycardowner.setError("Please enter the card owners name");
                    return;
                }

                if(TextUtils.isEmpty(paycardexpiredate)){
                    epaycardexpiredate.setError("Please enter Credit card expire date");
                    return;
                }
                if(TextUtils.isEmpty(paybookname)){
                    epaybookname.setError("Please enter the book name");
                    return;
                }
                if(TextUtils.isEmpty(payqty)){
                    epayqty.setError("Please enter number of books");
                    return;
                }
                if(TextUtils.isEmpty(paytotalprice)){
                    epaytotalprice.setError("Please enter total payment correctly");
                    return;
                }
                if(TextUtils.isEmpty(paydate)){
                    epaydate.setError("Select the Payment date");
                    return;
                }


                long mDateTime = 9999999999999L - System.currentTimeMillis();
                String mOrderTime = String.valueOf(mDateTime);

                PaymentData paymentData = new PaymentData(payid,payfirstname,payemail,payaddress,paycardnumber,paycardowner,paycardexpiredate,paybookname,payqty,paytotalprice,paydate);
                payref.child(mOrderTime).setValue(paymentData).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(),"Payment Completed Successfully",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Cannot Complete the Payment. Try again Later.",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    public void openMyorders(){
            Intent intent = new Intent(this,Myorders.class);
            startActivity(intent);
        }

    public void openCancel(){
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

