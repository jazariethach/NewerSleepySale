package edu.ucsb.cs.cs185.jazariethach.sleepysale;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends Activity {
    private static EditText username;
    private static EditText password;
    private static Button login;

    public void login(){
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);

        login.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(username.getText().toString().equals("user") &&
                                password.getText().toString().equals("pass")){

                            Intent intent = new Intent("edu.ucsb.cs.cs185.jazariethach.sleepysale.MainActivity");
                            startActivity(intent);
                            Toast.makeText(Login.this, "Welcome back user",
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(Login.this,
                                    "The Username and Password combination is not recognized",
                                    Toast.LENGTH_SHORT).show();
                            Toast.makeText(Login.this, "Please Try again",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
