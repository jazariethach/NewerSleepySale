package edu.ucsb.cs.cs185.jazariethach.sleepysale;

/**
 * Created by Jazarie on 6/5/2015.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CardViewHolder> {

    private List<CardInfo> cardList;
    Context context;

    public MyAdapter(Context context, List<CardInfo> cardList) {
        this.context = context;
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
       // cvh.vContactInfo.setText("Contact Me: " + ci.contactInfo);
        cvh.vTitle.setText(ci.itemName);
        cvh.vDesc.setText("Description: " + ci.description);
        //cvh.iv.setImageResource(ci.image);
        cvh.type.setText("Current Bids: " + ci.numBids);


        cvh.date.setText("Days left: " + ci.days);
        cvh.tags.setText(ci.tags);
//        Picasso.with(context).load(ci.image).centerCrop().resize(800, 400).into((ImageView)cvh.iv.findViewById(R.id.image));

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
        }
    }
}
