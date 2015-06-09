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
        cards.add(new CardInfo("Full Sized Bed", 100, "Full sized ikea bed frame & mattress", R.drawable.bed, 1, false,  3, "#Household #Furniture"));
        cards.add(new CardInfo("Cat Playtime", 0,  "That is one fine cat, and this is your chance to destress! Come play with Jackson, he loves people.", R.drawable.cat1, 1, false, 50, "#Misc"));
        cards.add(new CardInfo("Purple Bike", 25, "Perfect condition bike for sale. It was bought brand new in October. " +
                "The reason I'm selling this bike is because I'm moving to Europe.Comes with lock.", R.drawable.bike, 1, false, 1, "#Transprortation"));
        cards.add(new CardInfo("Toucan", 532,  "That is one fine Toucan? Sometimes chirps", R.drawable.cat2, 2, false, 0, ""));
        cards.add(new CardInfo("Beats Pill", 100,  "Good as new Beats Pill! Comes with the box, a case, and all the cables.", R.drawable.beats_pill, 3, false, 0, "#Technology"));
        cards.add(new CardInfo("Dresser", 35, "Can be used as a nightstand or dresser!\n" +
                "Made of Solid Wood--great quality and in great condition. ", R.drawable.dresser, 3, false, 5, "#Household #Furniture"));
        cards.add(new CardInfo("Desk Chair", 50,  "Super comfy leather desk chair", R.drawable.deskchair, 5, false,  0, "#Household #Furniture"));
        cards.add(new CardInfo("Wetsuit Size 8", 80, "Selling a womens dawn patrol Ripcurl wetsuit, 5/3 GB, Size 8, almost new! only used once! In perfect condition!"
                , R.drawable.wetsuit, 7, true, 0, "#Fashion"));
        cards.add(new CardInfo("Free Food!", 0, "Just try to clear out the fridge, plz take! \n" +
                "Eggs, cheese, salami, sauces, lemons.", R.drawable.freefood, 7, true, 0, "#Food"));


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
