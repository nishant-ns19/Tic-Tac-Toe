package com.example.nishant.higherlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
int Rd;
    public void click(View view)
    {
        EditText e1= (EditText) findViewById(R.id.e1);
        String s=e1.getText().toString();
        if(!s.isEmpty())
        {
            Log.i("User Entered",s);
            int d=Integer.parseInt(s);
            if(d>Rd)
                Toast.makeText(MainActivity.this, "Lower.", Toast.LENGTH_SHORT).show();
            else if(d<Rd)
                Toast.makeText(MainActivity.this, "Higher", Toast.LENGTH_SHORT).show();
            else
            {
                Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                Rd=(new Random()).nextInt(20) +1;
            }

        }
        else
        {
            Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random random=new Random();
        Rd=random.nextInt(20) + 1;
    }
}
