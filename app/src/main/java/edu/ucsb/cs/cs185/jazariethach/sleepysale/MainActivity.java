package edu.ucsb.cs.cs185.jazariethach.sleepysale;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.squareup.picasso.Picasso;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* To those seniors
            _.-'`'-._
         .-'    _    '-.
          `-.__  `\_.-'
            |  `-``\|
            `-.....-A
                    #
                    #
 */

// Here goes my try at documentation, Idk how it'll be but I'm pretty sure nobody minds
public class MainActivity extends ActionBarActivity {
    Context context;

    // So this function creates something, apparently it takes in a bundle...
    // ... wow a whole bundle, that's amazingly remarkable!!!
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        // We see here that the amazing bundle needs a recycler view, well
        // you know, because we want to recycle that amazing bundle of
        // love of course
        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        // Well at this point of the code, we see that the bundle is just a bit too
        // overwhelming for us, so we have to adapt to this amazingness, therefore
        // we create an adapter that can adapt for us!!! great-io!
        MyAdapter adapter = new MyAdapter(context, createList());
        recList.setAdapter(adapter);
    }


    // Our options menu for this bundle of goodness, the more options the better ;)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Our bundle of goodness, we need to know what it does when it activates huh?
    // So we are gonna do just that
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.add) {
            final Intent nextScreen = new Intent(this, SaleActivity.class);
            context.startActivity(nextScreen);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    // createList() is a function that creates a beautiful dandy list that our amazing
    // bundle of goodness
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

/*   ."".    ."",
     |  |   /  /
     |  |  /  /
     |  | /  /
     |  |/  ;-._
     }  ` _/  / ;
     |  /` ) /  /
     | /  /_/\_/\
     |/  /      |
     (  ' \ '-  |
      \    `.  /
       |      |
       |      |
*/

// Side notes, apparently we want everything to be more colorful, so we are changing to blue
// Jaz is pretty pissed
// Felicia thinks it's the same one
// She says it might be a little lighter
// Jaz says it's a little better, but lighter
// Felicia says we can do gray