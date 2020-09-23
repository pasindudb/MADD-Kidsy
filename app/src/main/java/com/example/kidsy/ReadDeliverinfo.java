package com.example.kidsy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ReadDeliverinfo extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle dtoggle;
    ListView dellist;
    List<DeliverData> deliverlist;
    DatabaseReference databasepay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_deliverinfo);

        databasepay = FirebaseDatabase.getInstance().getReference("DeliverData");
        drawerLayout = findViewById(R.id.readdellay);
        dtoggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.hopen,R.string.hclose);
        dtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dellist = (ListView) findViewById(R.id.dellist);
        deliverlist = new ArrayList<DeliverData>();
    }
    @Override
    protected void onStart() {
        super.onStart();

        databasepay.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                deliverlist.clear();

                for(DataSnapshot deliverDataSnapshot: dataSnapshot.getChildren()){
                    DeliverData deliverData = deliverDataSnapshot.getValue(DeliverData.class);

                    deliverlist.add(deliverData);

                }
                DeliverList adapter = new DeliverList(ReadDeliverinfo.this,deliverlist);
                dellist.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });



        dellist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DeliverData deliverData=deliverlist.get(i);
                showUpdateDialog(deliverData.getDelid(),deliverData.getOrderid(),deliverData.getDelfirst(),deliverData.getDellast(),deliverData.getDeladdress(),deliverData.getDelzip(),deliverData.getDelemail(),deliverData.getDelqty(),deliverData.getDeldate());
            }
        });
    }
    public void showUpdateDialog(final String delid,String orderid,String delfirst,String dellast, String deladdress,String delzip, String delemail, String delqty,String deldate) {
        AlertDialog.Builder dialogBuilder= new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        final View dialogView= inflater.inflate(R.layout.update_deliver,null);
        dialogBuilder.setView(dialogView);

        final EditText eorderid = (EditText) dialogView.findViewById(R.id.edorderid);
        final EditText efirst = (EditText) dialogView.findViewById(R.id.edfirstname);
        final EditText elast= (EditText) dialogView.findViewById(R.id.edlastname);
        final EditText eaddress = (EditText) dialogView.findViewById(R.id.edaddress);
        final EditText ezipcode = (EditText) dialogView.findViewById(R.id.edzipcode);
        final EditText eemail= (EditText) dialogView.findViewById(R.id.edemail);
        final EditText edate = (EditText) dialogView.findViewById(R.id.eddate);
        final EditText eqty = (EditText) dialogView.findViewById(R.id.edqty);
        final Button ebtn = (Button) dialogView.findViewById(R.id.btneditdel);
        final Button dbtn = (Button) dialogView.findViewById(R.id.btndltdel);

        dbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteDelivertData(delid);
            }
        });

        dialogBuilder.setTitle("Updating Deliver Details of Deliver ID : "+delid);

        final AlertDialog alertDialog=dialogBuilder.create();
        alertDialog.show();

        ebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String delorderid=eorderid.getText().toString().trim();
                String delfirst=efirst.getText().toString().trim();
                String dellast =elast.getText().toString().trim();
                String deladdress =eaddress.getText().toString().trim();
                String delzip =ezipcode.getText().toString().trim();
                String delemail =eemail.getText().toString().trim();
                String delqty =eqty.getText().toString().trim();
                String deldate =edate.getText().toString().trim();


           if(TextUtils.isEmpty(delorderid)){
                eorderid.setError("Please Enter the Order ID");
                return;
            }
                if(TextUtils.isEmpty(delfirst)){
                efirst.setError("First Name can not be empty");
                return;
            }
                if(TextUtils.isEmpty(dellast)){
                elast.setError("Last Name can not be empty");
                return;
            }
                if(TextUtils.isEmpty(deladdress)){
                eaddress.setError("Please Enter the Postal Address");
                return;
            }
                if(TextUtils.isEmpty(delzip)){
                ezipcode.setError("Please Enter postal ZIP code");
                return;
            }
                if(TextUtils.isEmpty(delemail)){
                eemail.setError("Please enter customer Email");
                return;
            }
                if(TextUtils.isEmpty(delqty)){
                    eqty.setError("Please enter Number of books");
                    return;
                }
                if(TextUtils.isEmpty(deldate)){
                edate.setError("Please enter order delivered date");
                return;
            }
            updateDeliver(delid,delorderid,delfirst,dellast,deladdress,delzip,delemail,delqty,deldate);
                alertDialog.dismiss();

        }

    });
}

    private void deleteDelivertData(String delid) {
        DatabaseReference dref=FirebaseDatabase.getInstance().getReference("DeliverData").child(delid);
        dref.removeValue();

        Toast.makeText(this,"Deliver Data Deleted",Toast.LENGTH_LONG).show();
    }

    private boolean updateDeliver(String delid, String orderid, String delfirst, String dellast,String deladdress, String delzip,String delemail,String delqty, String deldate){
            DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("DeliverData").child(delid);
            DeliverData deliverData= new DeliverData(delid,orderid,delfirst,dellast,deladdress,delzip,delemail,delqty,deldate);
            databaseReference.setValue(deliverData);
            Toast.makeText(this,"Deliver Data Updated Successfully",Toast.LENGTH_LONG).show();
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