package com.test.netmartdeliverer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.auth.User;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.OrderListViewHolder> {
    //private ArrayList<OrderListModel> mExampleList;
    List<OrderListModel> orderList;
    private OnItemClickListener mListener;

    //constructor
//    public OrderListAdapter(ArrayList<OrderListModel> exampleList, OnItemClickListener listener) {
//        this.mExampleList = exampleList;
//        this.mListener = listener;
//    }

    public OrderListAdapter(List<OrderListModel> orderList, OnItemClickListener listener) {
        this.orderList = orderList;
        this.mListener = listener;
    }

    public interface OnItemClickListener{
         void OnItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    @NonNull
    @Override
    public OrderListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list, parent, false);
        OrderListViewHolder evh = new OrderListViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderListViewHolder holder, final int position) {
            final OrderListModel currentItem = orderList.get(position);
            //holder.bind(currentItem);


            holder.UserImage.setImageResource(currentItem.getImage());
            holder.ClientName.setText(currentItem.getClientName());
            holder.PriceOrder.setText(currentItem.getPriceOrder());
            holder.ItemToBeDelivered.setText(currentItem.getItemToBeDelivered());
            holder.Items.setText(currentItem.getItems());
            //either this or change to other part
            holder.Send_Time.setText(Double.toString(currentItem.getSend_Time()));

            //this item expanded
            boolean isExpandable = orderList.get(position).isExpanded();
            holder.ExpandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);



//        holder.ItemToBeDelivered.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Get the current state of the item
//                boolean expanded = currentItem.isExpanded();
//                // Change the state
//                currentItem.setExpanded(!expanded);
//                // Notify the adapter that item has changed
//                notifyItemChanged(position);
//            }
//        });

        //go to pickupactivity activity
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, PickUpActivity.class);
//                intent.putExtra("image_url", mImages.get(position));
//                intent.putExtra("image_name", mImageNames.get(position));
//                mContext.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    //this viewholder is used to assigned every view on the recyclerview list item
    public class OrderListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView UserImage;
        public TextView ClientName;
        public TextView Send_Time;
        public TextView PriceOrder;
        public TextView ItemToBeDelivered;
        public TextView Items;
        public ImageView mMessageUser;
        public ImageView mLocationSend;
        //public LinearLayout orderListLinearLayout;
        public RelativeLayout ExpandableLayout;

        public OrderListViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            UserImage = itemView.findViewById(R.id.notifyImageId);
            Send_Time = itemView.findViewById(R.id.timetosend);
            ClientName = itemView.findViewById(R.id.notifyTitle);
            PriceOrder = itemView.findViewById(R.id.notifyTotalPrice);
            ItemToBeDelivered = itemView.findViewById(R.id.notifyDeliveryItem);
            Items = itemView.findViewById(R.id.notifyItemDetails);
            mMessageUser = itemView.findViewById(R.id.messageUser);
            mLocationSend = itemView.findViewById(R.id.locationToSend);
            itemView.setOnClickListener(this);

            //orderListLinearLayout = itemView.findViewById(R.id.orderListLinearLayout);
            ExpandableLayout = itemView.findViewById(R.id.ExpandableLayout);


            //click this and expandable recyclerview open
            Items.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    OrderListModel itemsList = orderList.get(getAdapterPosition());
                    itemsList.setExpanded(!itemsList.isExpanded());
                    notifyItemChanged(getAdapterPosition());


                }
            });
            //this function is to show location of the pickup and drop off
            mLocationSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.OnItemClick(position);
                        }
                    }

                }
            });




            mMessageUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.OnItemClick(position);
                        }
                    }

                }
            });
        }

        //use to expand the order item list
//        public void bind(OrderListModel currentItem) {
//            boolean expanded = currentItem.isExpanded();
//            // Set the visibility based on state
//           Items.setVisibility(expanded ? View.VISIBLE : View.GONE);
//
//            UserImage.setImageResource(currentItem.getImage());
//            ClientName.setText("Client Name: " + currentItem.getClientName());
//            Send_Time.setText("Time to Received: " + currentItem.getSend_Time());
//            Items.setText("Items: "+ currentItem.getItems());
//            PriceOrder.setText("Price" + currentItem.getPriceOrder());
//        }

        //this is for when click the particular recyclerview to go for detail
        @Override
        public void onClick(View v) {
            mListener.OnItemClick(getAdapterPosition());
        }
    }

    //the constructor
//    public OrderListAdapter(ArrayList<OrderListModel> orderList, OnItemClickListener mListener){
//        this.mExampleList = orderList;
//        this.mListener = mListener;
//    }
}
