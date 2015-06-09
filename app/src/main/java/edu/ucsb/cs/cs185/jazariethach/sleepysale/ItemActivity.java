package edu.ucsb.cs.cs185.jazariethach.sleepysale;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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
        Button msg = (Button)findViewById(R.id.contact);
        msg.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Context context = ItemActivity.this;
                Intent intent = new Intent(context, Message.class);
                context.startActivity(intent);
            }
        });
        Button bidButton = (Button)findViewById(R.id.bid);
        bidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(ItemActivity.this);
                builder.setTitle("Make Bid");
                LayoutInflater inflater = LayoutInflater.from(ItemActivity.this);
                final View findView = (inflater.inflate(R.layout.bid_layout, null));
                builder.setView(findView);
                builder
                    .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                                public void onClick(final DialogInterface dialog, final int id) {
                                    EditText fill_price = (EditText) findView.findViewById(R.id.price);
                                    TextView price = (TextView) findViewById(R.id.price);
                                    String s = price.getText().toString();
                                    if (s.substring(0,1) != "$") {
                                        s = "0";
                                    } else {
                                        s = s.replace("$", "");
                                    }
                                    if (Integer.parseInt(s) < Integer.parseInt(fill_price.getText().toString())) {
                                        s = "$" + fill_price.getText();
                                        price.setText(s);
                                        TextView bid = (TextView) findViewById(R.id.buyType);
                                        String bid_s = bid.getText().toString();
                                        bid_s = bid_s.replace("Current Bids: ", "");
                                        bid.setText("Current Bids: " + ((Integer.parseInt(bid_s)) + 1));
                                    } else {
                                        Toast.makeText(ItemActivity.this, "Invalid bid", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                    );
                builder.show();
                    }
            });

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
        if (id == R.id.fave) {
            Toast.makeText(getBaseContext(), "Added to watchlist!", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
