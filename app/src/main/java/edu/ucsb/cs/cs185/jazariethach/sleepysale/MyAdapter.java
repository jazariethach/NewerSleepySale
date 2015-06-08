package edu.ucsb.cs.cs185.jazariethach.sleepysale;

/**
 * Created by Jazarie on 6/5/2015.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CardViewHolder> {

    private List<CardInfo> cardList;

    public MyAdapter(List<CardInfo> cardList) {
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
        cvh.vContactInfo.setText("Contact Info: " + ci.contactInfo);
        cvh.vTitle.setText(ci.itemName);
        cvh.vDesc.setText("Description: " + ci.description);
        cvh.iv.setImageResource(ci.image);
        if(ci.buyNow){
            cvh.type.setText("Buy Now");
        }else{
            cvh.type.setText("Current Bids:" + ci.numBids);
        }
        if(ci.obo){
            cvh.obo.setVisibility(View.VISIBLE);
        }else{
            cvh.obo.setVisibility(View.GONE);
        }

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
        public TextView vContactInfo;
        public TextView vTitle;
        public TextView vDesc;
        public TextView obo;
        public TextView type;
        public ImageView iv;

        public CardViewHolder(View v) {
            super(v);
            vPrice =  (TextView) v.findViewById(R.id.price);
            vContactInfo = (TextView)  v.findViewById(R.id.contact);
            vTitle = (TextView) v.findViewById(R.id.title);
            vDesc = (TextView) v.findViewById(R.id.desc);
            obo = (TextView) v.findViewById(R.id.obo);
            type = (TextView) v.findViewById(R.id.buyType);
            iv = (ImageView) v.findViewById(R.id.imageView);
        }
    }
}
