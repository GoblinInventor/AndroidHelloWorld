package com.example.dave.androidhelloworld;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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


        /**
         * The AsyncTask threads that the OnClickListener generates need a
         * reference to the MainActivity object, so this variable holds that
         * information.
         */
        final MainActivity mainActivityReference = this;


        Button button = (Button) findViewById(R.id.center_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* This line makes a Toast when you press the button */
//                Toast.makeText(MainActivity.this, "You pressed my button!",
//                        Toast.LENGTH_SHORT).show();

                /**
                 * If we're using a Java Servlets backend, this line will create a background
                 * thread that sends the text "Button" to the backend, which will then send the
                 * text "Hello Button" back to the thread, which will receive the text and display
                 * it in a Toast message.
                 */
//                new ServletPostAsyncTask().execute(new Pair<Context, String>(
//                      mainActivityReference, "Button w/ Servlets"));

                /* This line does the same thing for a Java Endpoints backend. */
                new EndpointsAsyncTask().execute(new Pair<Context, String>(
                        mainActivityReference, "Button w/ Endpoints"));
            }
        });


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
}
