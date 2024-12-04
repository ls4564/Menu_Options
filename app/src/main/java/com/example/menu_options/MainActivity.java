package com.example.menu_options;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText eD1,eD2;
    TextView tV1;

    Double num1,num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wedding();
    }



    public void wedding()
    {
        eD1 = (EditText) findViewById(R.id.eD1);
        eD2 = (EditText) findViewById(R.id.eD2);
        tV1 = (TextView) findViewById(R.id.tV1);
    }

/*
    String st = eD1.getText().toString();
    Double answer = Double.parseDouble(st);
 */

    public boolean check_input(String input)
    {
        if(input.equals(".") || input.equals("-") || input.equals(".-") || input.equals("-.") || input.equals("+") || input.equals(".+") || input.equals("+."))
        {
            return false;
        }
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected (MenuItem item)
    {
        if(check_input())//check input
        {
            int id = item.getItemId();
            if(id == R.id.menu_plus)
            {

            }
            else if(id == R.id.menu_minus)
            {

            }
            else if(id == R.id.menu_mul)
            {

            }
            else if(id == R.id.menu_div)
            {

            }
            else
            {

            }
        }


        return true;
    }

}
