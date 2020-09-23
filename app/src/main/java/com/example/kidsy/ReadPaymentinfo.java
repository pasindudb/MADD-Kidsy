
package com.example.kidsy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ReadPaymentinfo extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle dtoggle;
    ListView paylist;
    List<PaymentData> paymentlist;
    DatabaseReference databasepay;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_paymentinfo);

        databasepay = FirebaseDatabase.getInstance().getReference("PaymentData");

        drawerLayout = findViewById(R.id.readpaylay);
        dtoggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.hopen,R.string.hclose);
        drawerLayout.addDrawerListener(dtoggle);
        dtoggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        paylist = (ListView) findViewById(R.id.paylist);
        paymentlist = new ArrayList<>();



    }
    @Override
    protected void onStart() {
        super.onStart();

        databasepay.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                paymentlist.clear();

                for(DataSnapshot paymentDataSnapshot: dataSnapshot.getChildren()){
                    PaymentData paymentData = paymentDataSnapshot.getValue(PaymentData.class);

                    paymentlist.add(paymentData);

                }
                PaymentList adapter = new PaymentList(ReadPaymentinfo.this,paymentlist);
                paylist.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        paylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PaymentData paymentData=paymentlist.get(i);
                showUpdateDialog(paymentData.getPayid(),paymentData.getPayfirstname(),paymentData.getPayemail(),paymentData.getPayaddress(),paymentData.getPaycardnumber(),paymentData.getPaycardowner(),paymentData.getPaycardexpiredate(),paymentData.getPaybookname(),paymentData.getPayqty(),paymentData.getPaytotalprice(),paymentData.getPaydate());
            }
        });

    }

    public void showUpdateDialog(final String payid, String payfirstname,String payemail,String payaddress,String paycardnumber, String paycardowner,String paycardexpiredate, String paybookname,String qty,String paytotalprice, String paydate) {
        AlertDialog.Builder dialogBuilder= new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        final View dialogView= inflater.inflate(R.layout.update_dialog,null);
        dialogBuilder.setView(dialogView);

        final EditText efirst = (EditText) dialogView.findViewById(R.id.epfirstname);
        final EditText eemail= (EditText) dialogView.findViewById(R.id.epemail);
        final EditText eaddress = (EditText) dialogView.findViewById(R.id.epaddress);
        final EditText ecardnumber = (EditText) dialogView.findViewById(R.id.epcardnumber);
        final EditText ecardowner = (EditText) dialogView.findViewById(R.id.epcardowner);
        final EditText ecardexpiredate = (EditText) dialogView.findViewById(R.id.epcardexpiredate);
        final EditText ebookname = (EditText) dialogView.findViewById(R.id.epbookname);
        final EditText eqty= (EditText) dialogView.findViewById(R.id.epqty);
        final EditText etotalprice = (EditText) dialogView.findViewById(R.id.eptotalprice);
        final EditText edate = (EditText) dialogView.findViewById(R.id.epdate);
        final Button ebtn = (Button) dialogView.findViewById(R.id.btneditpay);
        final Button dbtn = (Button) dialogView.findViewById(R.id.btndltpay);

        dialogBuilder.setTitle("Updating Payment Details of Payment ID : "+payid);
        dbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletePaymentData(payid);
            }
        });


        final AlertDialog alertDialog=dialogBuilder.create();
        alertDialog.show();

        ebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String payfirst=efirst.getText().toString().trim();
                String payemail =eemail.getText().toString().trim();
                String payaddress =eaddress.getText().toString().trim();
                String paycardnumber =ecardnumber.getText().toString().trim();
                String paycardowner =ecardowner.getText().toString().trim();
                String paycardexpiredate =ecardexpiredate.getText().toString().trim();
                String paybookname =ebookname.getText().toString().trim();
                String payqty =eqty.getText().toString().trim();
                String paytotal =etotalprice.getText().toString().trim();
                String paydate =edate.getText().toString().trim();

                if(TextUtils.isEmpty(payfirst)){
                    efirst.setError("First Name can not be empty");
                    return;
                }

                if(TextUtils.isEmpty(payemail)){
                        eemail.setError("Please enter the Email");
                        return;
                }

                if(TextUtils.isEmpty(payaddress)){
                    eaddress.setError("Address Field can not be empty");
                    return;
                }

                if(TextUtils.isEmpty(paycardnumber)){
                    ecardnumber.setError("You must enter the Credit Card Number");
                    return;
                }
                if(TextUtils.isEmpty(paycardowner)){
                    ecardowner.setError("Please enter the card owners name");
                    return;
                }

                if(TextUtils.isEmpty(paycardexpiredate)){
                    ecardexpiredate.setError("Please enter Credit card expire date");
                    return;
                }
                if(TextUtils.isEmpty(paybookname)){
                    ebookname.setError("Please enter the book name");
                    return;
                }
                if(TextUtils.isEmpty(payqty)){
                    eqty.setError("Please enter number of books");
                    return;
                }
                if(TextUtils.isEmpty(paytotal)){
                    etotalprice.setError("Please enter total payment correctly");
                    return;
                }
                if(TextUtils.isEmpty(paydate)){
                    edate.setError("Select the Payment date");
                    return;
                }
                updatePayment(payid,payfirst,payemail,payaddress,paycardnumber,paycardowner,paycardexpiredate,paybookname,payqty,paytotal,paydate);
                alertDialog.dismiss();
            }
        });


    }

    private void deletePaymentData(String payid) {
        DatabaseReference dref=FirebaseDatabase.getInstance().getReference("PaymentData").child(payid);
        dref.removeValue();

        Toast.makeText(this,"Payment Data Deleted",Toast.LENGTH_LONG).show();
    }

    private boolean updatePayment(String payid, String payfirstname,String payemail,String payaddress,String paycardnumber, String paycardowner,String paycardexpiredate, String paybookname,String payqty, String paytotalprice, String paydate){
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("PaymentData").child(payid);
        PaymentData paymentData= new PaymentData(payid,payfirstname,payemail,payaddress,paycardnumber,paycardowner,paycardexpiredate,paybookname,payqty,paytotalprice,paydate);
        databaseReference.setValue(paymentData);
        Toast.makeText(this,"Payment Data Updated Successfully",Toast.LENGTH_LONG).show();
        return true;
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

