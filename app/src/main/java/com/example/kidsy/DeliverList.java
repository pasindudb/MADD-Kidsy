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

public class DeliverList extends ArrayAdapter<DeliverData> {
    private Activity context;
    private List<DeliverData> deliverlist;

    public DeliverList(Activity context, List<DeliverData> deliverlist){
        super(context,R.layout.deliver_list,deliverlist);
        this.context=context;
        this.deliverlist=deliverlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.deliver_list,null,true);

        TextView did =(TextView) listViewItem.findViewById(R.id.rdid);
        TextView doid =(TextView) listViewItem.findViewById(R.id.roid);
        TextView dfirstname =(TextView) listViewItem.findViewById(R.id.rdfirstname);
        TextView daddress =(TextView) listViewItem.findViewById(R.id.rdaddress);
        TextView dqty =(TextView) listViewItem.findViewById(R.id.rdqty);
        TextView ddate =(TextView) listViewItem.findViewById(R.id.rddate);

        DeliverData deliverData = deliverlist.get(position);

        did.setText(deliverData.getDelid());
        doid.setText(deliverData.getOrderid());
        dfirstname.setText(deliverData.getDelfirst());
        daddress.setText(deliverData.getDeladdress());
        dqty.setText(deliverData.getDelqty());
        ddate.setText(deliverData.getDeldate());

        return listViewItem;
    }
}
