package com.somitsolutions.android.training.sharedpreferenceexample;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button mButtonSaveData;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);

        mButtonSaveData = (Button)findViewById(R.id.buttonSaveData);
        mButtonSaveData.setOnClickListener(this);


        // If value for key not exist then return second param value - In this case null
        boolean boolData = pref.getBoolean("key_name1", true);         // getting boolean
        int intData = pref.getInt("key_name2", 0);             // getting Integer
        float floatData = pref.getFloat("key_name3", 0);           // getting Float
        String strData = pref.getString("key_name4", null);          // getting String

        String toastString = "The saved values are" + " Boolean = " + Boolean.toString(boolData)
                + " Integer= " + Integer.toString(intData) + " Float= "+ Float.toString(floatData)+
                " String= "+ strData;

        Toast.makeText(getApplicationContext(), toastString, Toast.LENGTH_LONG).show();
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        SharedPreferences.Editor editor = pref.edit();

        editor.putBoolean("key_name1", true);           // Saving boolean - true/false
        editor.putInt("key_name2", 10);        // Saving integer
        editor.putFloat("key_name3", (float)(12.05));      // Saving long
        editor.putString("key_name4", "Somenath Mukhopadhyay");  // Saving string

        // Save the changes in SharedPreferences
        editor.commit(); // commit changes
    }
}
