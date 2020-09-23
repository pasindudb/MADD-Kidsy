package com.example.kidsy;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PaymentList extends ArrayAdapter<PaymentData> {
    private Activity context;
    private List<PaymentData> paymentlist;

    public PaymentList(Activity context, List<PaymentData> paymentlist){
        super(context,R.layout.payment_list,paymentlist);
        this.context=context;
        this.paymentlist=paymentlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.payment_list,null,true);

        TextView pid =(TextView) listViewItem.findViewById(R.id.rpid);
        TextView pfirstname =(TextView) listViewItem.findViewById(R.id.rpfirstname);
        TextView pemail =(TextView) listViewItem.findViewById(R.id.rpemail);

        TextView paddress =(TextView) listViewItem.findViewById(R.id.rpaddress);

        TextView pcardnumber =(TextView) listViewItem.findViewById(R.id.rpcardnumber);
        TextView pcardowner =(TextView) listViewItem.findViewById(R.id.rpcardowner);
        TextView pcardexpierdate =(TextView) listViewItem.findViewById(R.id.rpcardexpiredate);
        TextView pbookname =(TextView) listViewItem.findViewById(R.id.rpbookname);
        TextView pqty =(TextView) listViewItem.findViewById(R.id.rpqty);
        TextView ptotalprice =(TextView) listViewItem.findViewById(R.id.rptotalprice);
        TextView pdate =(TextView) listViewItem.findViewById(R.id.rpdate);

        PaymentData paymentData = paymentlist.get(position);

        pid.setText(paymentData.getPayid());
        pfirstname.setText(paymentData.getPayfirstname());
        pemail.setText(paymentData.getPayemail());
        paddress.setText(paymentData.getPayaddress());
        pcardnumber.setText(paymentData.getPaycardnumber());
        pcardowner.setText(paymentData.getPaycardowner());
        pcardexpierdate.setText(paymentData.getPaycardexpiredate());
        pbookname.setText(paymentData.getPaybookname());
        pqty.setText(paymentData.getPayqty());
        ptotalprice.setText(paymentData.getPaytotalprice());
        pdate.setText(paymentData.getPaydate());

        return listViewItem;
    }

}
