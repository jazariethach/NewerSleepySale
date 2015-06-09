package edu.ucsb.cs.cs185.jazariethach.sleepysale;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class ItemActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_view);
        Intent i = getIntent();
        String s = i.getStringExtra("test");
        TextView title = (TextView)findViewById(R.id.title);
        String t = s.substring(0, s.indexOf("%"));
        title.setText(t);
        s = s.replace(t+"%", "");
        TextView price = (TextView)findViewById(R.id.price);
        String p = s.substring(0, s.indexOf("%"));
        price.setText(p);
        s = s.replace(p+"%", "");
        TextView bid = (TextView)findViewById(R.id.buyType);
        String b = s.substring(0, s.indexOf("%"));
        bid.setText(b);
        s = s.replace(b+"%", "");
        TextView desc = (TextView)findViewById(R.id.desc);
        String ds = s.substring(0, s.indexOf("%"));
        desc.setText(ds);
        s = s.replace(ds+"%", "");
        TextView date = (TextView)findViewById(R.id.date);
        String d = s.substring(0, s.indexOf("%"));
        date.setText(d);
        s = s.replace(d+"%", "");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item, menu);
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
