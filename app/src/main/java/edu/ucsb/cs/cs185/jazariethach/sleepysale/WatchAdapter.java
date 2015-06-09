package edu.ucsb.cs.cs185.jazariethach.sleepysale;

/**
 * Created by jessie on 6/9/2015.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class WatchAdapter extends RecyclerView.Adapter<WatchAdapter.CardViewHolder> {

    private List<CardInfo> cardList;
    Context context;
    public static Context msgContext;

    public WatchAdapter(Context context, List<CardInfo> cardList) {
        this.context = context;
        this.msgContext = context;
        this.cardList = cardList;
    }


    @Override
    public int getItemCount() {
        return cardList.size();
    }

    @Override
    public void onBindViewHolder(CardViewHolder cvh, int i) {
        CardInfo ci = cardList.get(i);
        if(ci.itemPrice == 0){
            cvh.vPrice.setText("FREE");
        }else {
            cvh.vPrice.setText("$" + ci.itemPrice);
        }
        if(ci.sold==true){
            cvh.vPrice.setText("Sold: $" + ci.itemPrice);
            cvh.vPrice.setTextColor(Color.parseColor("#a8a8a8"));
            cvh.vTitle.setBackgroundColor(Color.parseColor("#a8a8a8"));
            cvh.date.setTextColor(Color.parseColor("#a8a8a8"));
        }else{
            cvh.vPrice.setTextColor(Color.parseColor("#add8e6"));
            cvh.vTitle.setBackgroundColor(Color.parseColor("#add8e6"));
            cvh.date.setTextColor(Color.parseColor("#add8e6"));
        }
        // cvh.vContactInfo.setText("Contact Me: " + ci.contactInfo);
        cvh.vTitle.setText(ci.itemName);
        cvh.vDesc.setText("Description: " + ci.description);
        //cvh.iv.setImageResource(ci.image);
        cvh.type.setText("Current Bids: " + ci.numBids);

        cvh.date.setText("Days left: " + ci.days);
        cvh.tags.setText(ci.tags);
        Picasso.with(context).load(ci.image).resize(800, 750).into(cvh.iv);


    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup view, int i) {
        View itemView = LayoutInflater.
                from(view.getContext()).
                inflate(R.layout.card_layout, view, false);

        return new CardViewHolder(itemView);
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        public TextView vPrice;
        //public TextView vContactInfo;
        public TextView vTitle;
        public TextView vDesc;
        public TextView date;
        public TextView type;
        public TextView tags;
        public ImageView iv;

        public CardViewHolder(View v) {
            super(v);
            vPrice =  (TextView) v.findViewById(R.id.price);
            //  vContactInfo = (TextView)  v.findViewById(R.id.contact);
            vTitle = (TextView) v.findViewById(R.id.title);
            vDesc = (TextView) v.findViewById(R.id.desc);
            date = (TextView) v.findViewById(R.id.date);
            type = (TextView) v.findViewById(R.id.buyType);
            tags = (TextView) v.findViewById(R.id.tags);
            iv = (ImageView) v.findViewById(R.id.imageView);
            Context iv_context = iv.getContext();
            final Intent nextScreen = new Intent(iv_context, ItemActivity.class);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = iv.getContext();
                    String s = vTitle.getText().toString() + "%" + vPrice.getText().toString() + "%" + type.getText().toString()
                            + "%" + vDesc.getText().toString() + "%" + date.getText().toString() + "%";
                    nextScreen.putExtra("test", s);
                    context.startActivity(nextScreen);
//                    Toast.makeText(context, s, Toast.LENGTH_LONG).show();
                }
            });

            Button click = (Button) v.findViewById(R.id.contact);
            click.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent intent = new Intent(msgContext, Message.class);
                    msgContext.startActivity(intent);
                }
            });

        }
    }}

