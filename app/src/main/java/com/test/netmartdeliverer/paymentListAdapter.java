package com.test.netmartdeliverer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class paymentListAdapter extends RecyclerView.Adapter<paymentListAdapter.paymentListViewHolder> {
    private ArrayList<payment_model> mPaymentList;

    @NonNull
    @Override
    public paymentListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment, parent, false);
        paymentListAdapter.paymentListViewHolder evh = new paymentListAdapter.paymentListViewHolder(v, mPaymentList);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull paymentListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class paymentListViewHolder extends RecyclerView.ViewHolder{

        public ImageView notifyImageId;
        public TextView timetosend;
        public TextView notifytitle;
        public TextView notifyDeliveryTime;
        public TextView notifyDeliveryDate;
        public TextView notifyDeliveryItem;
        public TextView notifyTotalPrice;

        public paymentListViewHolder(@NonNull View itemView, ArrayList<payment_model> mPaymentList) {
            super(itemView);

            notifyImageId      = itemView.findViewById(R.id.notifyImageId);
            timetosend         = itemView.findViewById(R.id.timetosend);
            notifytitle        = itemView.findViewById(R.id.notifyTitleClient);
            notifyDeliveryTime = itemView.findViewById(R.id.notifyDeliveryTime);
            notifyDeliveryDate = itemView.findViewById(R.id.notifyDeliveryDate);
            notifyDeliveryItem = itemView.findViewById(R.id.notifyDeliveryItem);
            notifyTotalPrice   = itemView.findViewById(R.id.notifyTotalPrice);
        }
    }
}
