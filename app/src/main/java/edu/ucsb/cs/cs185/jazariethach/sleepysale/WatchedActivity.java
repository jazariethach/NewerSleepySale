package edu.ucsb.cs.cs185.jazariethach.sleepysale;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class WatchedActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watched);

        RecyclerView rList = (RecyclerView)findViewById(R.id.cardList);
        rList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rList.setLayoutManager(llm);

        WatchAdapter wa = new WatchAdapter(this, createList());
        rList.setAdapter(wa);
    }

    private List<CardInfo> createList() {
        List<CardInfo> cards = new ArrayList<CardInfo>();

        //CardInfo(String name, int price, String contact, String desc,int image, int days, boolean sold, boolean buyNow, int numBids, String categories){

        cards.add(new CardInfo("Cat Playtime", 0,  "That is one fine cat! Come play with Jackson, he loves people.", R.drawable.cat1, 1, false, 50, "#Misc"));

        cards.add(new CardInfo("Toucat", 532,  "That is one fine Toucan. Sometimes chirps", R.drawable.cat2, 2, false, 0, ""));
        cards.add(new CardInfo("Beats PillCat", 100,  "Good as new Cat! Comes with the cat and all the accessories.", R.drawable.beats_pill, 3, false, 0, "#Technology"));
        cards.add(new CardInfo("CatDresser", 35, "Can be used as a great cat!", R.drawable.cat6, 3, true, 5, "#Household #Furniture"));
        cards.add(new CardInfo("Desk Cat", 50,  "Super comfy leather desk chair", R.drawable.cat5, 5, true,  0, "#Household #Furniture"));
        cards.add(new CardInfo("Wetcat, Size 8", 80, "Selling a cat's dawn patrol Ripcurl wetsuit, 5/3 GB, Size 8, almost new! only used once! In perfect condition!"
                , R.drawable.cat3, 7, true, 0, "#Fashion"));
        cards.add(new CardInfo("Free FoodCat!", 0, "Just try to clear out the fridge, plz take! \n" +
                "Bring your cat", R.drawable.cat4, 7, true, 0, "#Food"));


        return cards;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_watched, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
