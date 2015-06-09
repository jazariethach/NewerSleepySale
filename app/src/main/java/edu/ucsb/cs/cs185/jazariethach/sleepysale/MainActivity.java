package edu.ucsb.cs.cs185.jazariethach.sleepysale;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.squareup.picasso.Picasso;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity{
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);


        MyAdapter adapter = new MyAdapter(context, createList());
        recList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch(item.getItemId()){
            case R.id.add:
                final Intent nextScreen = new Intent(this, SaleActivity.class);
                context.startActivity(nextScreen);
                return true;
            case R.id.watch:
                Intent intent = new Intent(this, WatchedActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
                , R.drawable.wetsuit, 7, false, 0, "#Fashion"));
        cards.add(new CardInfo("Free Food!", 0, "Just try to clear out the fridge, plz take! \n" +
                "Eggs, cheese, salami, sauces, lemons.", R.drawable.freefood, 7, false, 0, "#Food"));


        return cards;
    }

    public static int getId(String resourceName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resourceName);
            return idField.getInt(idField);
        } catch (Exception e) {
            throw new RuntimeException("No resource ID found for: "
                    + resourceName + " / " + c, e);
        }
    }
}
