package edu.ucsb.cs.cs185.jazariethach.sleepysale;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
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

        MyAdapter adapter = new MyAdapter(createList(10));
        recList.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    private List<CardInfo> createList(int size) {
//        int id = context.getResources().getIdentifier("big_" + i,"drawable", context.getPackageName());

        List<CardInfo> cards = new ArrayList<CardInfo>();
        for (int i=1; i <= size; i++) {
            CardInfo ci = new CardInfo();
            ci.itemName = "ITEM" + i;
            ci.email = "Contact Info: " + CardInfo.EMAIL_PREFIX + i + "@test.com";
            ci.itemPrice = "$" + i*10;
           // ci.description = "Description: "+ this.getResources().getIdentifier("desc"+i, "strings", this.getPackageName());
            ci.description = "Description: Oh hey, that is one sweet cat!";
            ci.image = getId("cat"+i, R.drawable.class);



            cards.add(ci);

        }

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
