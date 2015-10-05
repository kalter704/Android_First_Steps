package com.example.vasiliy.p0151_contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvColor, tvSize;

    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;

    final int MENU_SIZE_22 = 4;
    final int MENU_SIZE_26 = 5;
    final int MENU_SIZE_30 = 6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

       tvColor = (TextView) findViewById(R.id.textViewColor);
       tvSize = (TextView) findViewById(R.id.textViewSize);

        registerForContextMenu(tvColor);
        registerForContextMenu(tvSize);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.textViewColor:
                    menu.add(0, MENU_COLOR_RED, 0, "Red");
                    menu.add(0, MENU_COLOR_GREEN, 0, "Green");
                    menu.add(0, MENU_COLOR_BLUE, 0, "Blue");
                break;
            case R.id.textViewSize:
                    menu.add(0, MENU_SIZE_22, 0, "22");
                    menu.add(0, MENU_SIZE_26, 0, "26");
                    menu.add(0, MENU_SIZE_30, 0, "30");
                break;

        }
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
