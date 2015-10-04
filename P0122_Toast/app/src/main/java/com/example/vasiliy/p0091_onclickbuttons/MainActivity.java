package com.example.vasiliy.p0091_onclickbuttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtView;
    Button  btn1,
            btn2,
            btn3;

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Log.d(TAG, "Находим View-элементы");
        txtView = (TextView) findViewById(R.id.textView);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Нажимаем кнопку 1");
                txtView.setText("Нажата кнопка 1");
                Toast toast = Toast.makeText(MainActivity.this, "Нажата кнопка 1", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });

        btn2.setOnClickListener(this);

    }

    public void clickButton3(View v) {
        txtView.setText("Нажата кнопка 3");
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
        Log.e(TAG, "Нажимаем кнопку 2");

        Toast toast2 = Toast.makeText(MainActivity.this, "Нажата кнопка 2", Toast.LENGTH_LONG);
        toast2.setGravity(Gravity.CENTER, 0, 0);

        LinearLayout toastImage = (LinearLayout) toast2.getView();

        ImageView imageView = new ImageView(MainActivity.this);
        imageView.setImageResource(R.drawable.ic_colorize_black_48dp);

        toastImage.addView(imageView, 0);

        toast2.show();

        txtView.setText("Нажата кнопка 2");
    }
}
