package edu.ucsb.cs.cs185.jazariethach.sleepysale;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import android.widget.*;
import com.squareup.picasso.Picasso;


public class SaleActivity extends ActionBarActivity {
    ListView list_view;
    List<String> list = new ArrayList<String>();
    List<String> days = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> day_adapter;

    Uri fileUri = null;
    int i = 0;
    File file = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);
//        setContentView(R.layout.menu);
        list.add("Beauty");
        list.add("Electronics");
        list.add("Fashion");
        list.add("Household");
        list.add("Transportation");
        list.add("Misc");
        days.add("1 day");
        for (int j = 2; j <= 7; j++) {
            days.add(j + " days");
        }
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(SaleActivity.this, "Click event works.", Toast.LENGTH_SHORT).show();
                final AlertDialog.Builder builder = new AlertDialog.Builder(SaleActivity.this);
                builder.setTitle("List Item");
                LayoutInflater inflater = LayoutInflater.from(SaleActivity.this);
                final View findView = (inflater.inflate(R.layout.menu, null));
                builder.setView(findView);
                list_view = (ListView) findView.findViewById(R.id.lv);
                adapter = new ArrayAdapter<String>(SaleActivity.this, android.R.layout.simple_expandable_list_item_1, list);
//                list_view.setAdapter(adapter);
                builder.setAdapter(adapter,
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String item = adapter.getItem(which);
                                Button btn = (Button) findViewById(R.id.button);
                                btn.setText(item);
                                Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();
                            }
                        });
                builder.show();
            }
        });

        ImageView iv = (ImageView) findViewById(R.id.iv);
//        iv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getBaseContext(), "hi", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        Context context = iv.getContext();
//        final Intent nextScreen = new Intent(context, CameraActivity.class);
//        nextScreen.putStringArrayListExtra("image_list", (ArrayList<String>) list);

        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ImageView iv = (ImageView) findViewById(R.id.iv);
                Context context = iv.getContext();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    launchCamera();
//                    Toast.makeText(context, s, Toast.LENGTH_LONG).show();
                }
                return true;
            }

        });
    }

    final static int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1;


    private void launchCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File dir = new File(this.getExternalFilesDir(null), "SleepySale");
        dir.mkdirs();
        file = new File(dir, "pic" + i + ".jpg");
        fileUri = Uri.fromFile(file);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name
        i++; // increment photo number
        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) { // Save picture
            ImageView imageView = (ImageView) findViewById(R.id.iv);
            Context context = imageView.getContext();
            imageView.setBackground(null);
            Picasso.with(context).load(fileUri).resize(800, 400).centerCrop().into(imageView);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sell_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.save) {
            EditText title = (EditText) findViewById(R.id.title);
            Button category = (Button) findViewById(R.id.button);
            EditText price = (EditText) findViewById(R.id.price);
            EditText desc = (EditText) findViewById(R.id.desc);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void endDate(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(SaleActivity.this);
        builder.setTitle("Select Duration");
        LayoutInflater inflater = LayoutInflater.from(SaleActivity.this);
        final View findView = (inflater.inflate(R.layout.duration_list, null));
        builder.setView(findView);
        list_view = (ListView) findView.findViewById(R.id.lv);
        day_adapter = new ArrayAdapter<String>(SaleActivity.this, android.R.layout.simple_expandable_list_item_1, days);
        builder.setAdapter(day_adapter,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String item = day_adapter.getItem(which);
                        Button btn = (Button) findViewById(R.id.date);
                        btn.setText(item);
                        Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();
                    }
                });
        builder.show();
    }
}