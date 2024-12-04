package com.example.menu_options;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    EditText eD1,eD2;
    TextView tV1;

    //DecimalFormat scientificFormat;//for printing the format
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
        if(input.isEmpty() || input.equals(".") || input.equals("-") || input.equals(".-") || input.equals("-.") || input.equals("+") || input.equals(".+") || input.equals("+."))
        {
            return false;
        }
        return true;
    }

    public boolean check_zero(double nun)
    {
        if(nun == 0)
        {
            return false;
        }
        return true;
    }

    public String give_format(double num)
    {
        String format = Double.toString(num);
        if(format.replace(".", "").length() > 10)
        {
            DecimalFormat scientificFormat = new DecimalFormat("0.#########E0");
            format = scientificFormat.format(num);
            return format;
        }
        else
        {
            return format;
        }
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected (MenuItem item)
    {
        String str_eD1,str_eD2;
        str_eD1 = eD1.getText().toString();
        str_eD2 = eD2.getText().toString();

        if(check_input(str_eD1) && check_input(str_eD2))//check input
        {
            Double num_eD1 = Double.parseDouble(str_eD1);
            Double num_eD2 = Double.parseDouble(str_eD2);
            Double ans;
            int id = item.getItemId();
            if(id == R.id.menu_plus)
            {
                ans = num_eD1 + num_eD2;
                tV1.setText(""+ give_format(ans));
            }
            else if(id == R.id.menu_minus)
            {
                ans = num_eD1 - num_eD2;
                tV1.setText(""+ give_format(ans));
            }
            else if(id == R.id.menu_mul)
            {
                ans = num_eD1 * num_eD2;
                tV1.setText(""+ give_format(ans));
            }
            else if(id == R.id.menu_div)
            {
                if(check_zero(num_eD2))
                {
                    ans = num_eD1 / num_eD2;
                    tV1.setText(""+ give_format(ans));
                }
                else
                {
                    Toast.makeText(this,"Error: Can't div in zero",Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                eD1.setText("");
                eD2.setText("");
                tV1.setText("");
            }
        }
        else
        {
            tV1.setText("Error");
            Toast.makeText(this,"Error: illegal input",Toast.LENGTH_LONG).show();
        }


        return true;
    }

}
