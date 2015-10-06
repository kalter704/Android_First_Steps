package com.example.vasiliy.p0191_simplecalculator;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button  btnAdd,
            btnSub,
            btnMul,
            btnDiv,
            btnReset;

    EditText etNum1,
             etNum2;

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnReset = (Button) findViewById(R.id.btnReset);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnReset.setOnClickListener(this);

        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);

        tvResult = (TextView) findViewById(R.id.tvResult);
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
        float   num1 = 0,
                num2 = 0,
                result = 0;
        boolean isReset = false;
        String oper = "";

        if (TextUtils.isEmpty(etNum1.getText().toString()) || TextUtils.isEmpty(etNum2.getText().toString())) {
            Toast.makeText(this, "Заполните оба поля", Toast.LENGTH_SHORT).show();
            return;
        }

        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        switch (v.getId()) {
            case R.id.btnAdd:
                result = num1 + num2;
                oper = "+";
                break;
            case R.id.btnSub:
                result = num1 - num2;
                oper = "-";
                break;
            case R.id.btnMult:
                result = num1 * num2;
                oper = "*";
                break;
            case R.id.btnDiv:
                result = num1 / num2;
                oper = "/";
                break;
            case R.id.btnReset:
                isReset = true;
                num1 = 0;
                num2 = 0;
                break;
        }
        if (!isReset) {
            tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
        }else {
            tvResult.setText("");
            etNum1.setText("");
            etNum2.setText("");
        }
    }
}
