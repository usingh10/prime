package com.example.utkarshsingh.prime1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int result = 0, rt = 0,f=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null)
        {
            result=savedInstanceState.getInt("result");
            rt=savedInstanceState.getInt("rt");
            f=savedInstanceState.getInt("f");
            String s=savedInstanceState.getString("s");
            TextView e = (TextView) findViewById(R.id.editText4);
            e.setText(s);
            String ss=savedInstanceState.getString("ss");
            TextView ee = (TextView) findViewById(R.id.editText3);
            ee.setText(ss);
            String sss=savedInstanceState.getString("sss");
            TextView eee = (TextView) findViewById(R.id.editText2);
            eee.setText(sss);
            String start=savedInstanceState.getString("start");
            Button bb = (Button) findViewById(R.id.next);
            bb.setText(start);
            if(start.equals("Start") || start.equals("Start Again!"))
            {
                if(start.equals("Start Again!"))
                {
                    String s1=savedInstanceState.getString("s1");
                    TextView e1 = (TextView) findViewById(R.id.editText);
                    e1.setText(s1);
                }
                Button b1 = (Button) findViewById(R.id.yes);
                Button b = (Button) findViewById(R.id.no);
                b.setVisibility(View.INVISIBLE);
                b1.setVisibility(View.INVISIBLE);
            }
            else {

                Button b1 = (Button) findViewById(R.id.yes);
                Button b = (Button) findViewById(R.id.no);
                b.setVisibility(View.VISIBLE);
                b1.setVisibility(View.VISIBLE);
                Log.d("ff",Integer.toString(f));
                if (f != 0) {
                    if (f == 1) {
                        //Button b1 = (Button) findViewById(R.id.no);
                        b.setEnabled(false);
                        if (result == 0) {
                            //Button b = (Button) findViewById(R.id.yes);
                            b1.setBackgroundColor(Color.GREEN);
                            b1.setEnabled(false);
                        } else {
                            //Button b = (Button) findViewById(R.id.yes);
                            b1.setBackgroundColor(Color.RED);
                            b1.setEnabled(false);
                        }
                    }
                } else {
                    b.setEnabled(true);
                    b1.setEnabled(true);
                    //Button b1 = (Button) findViewById(R.id.yes);

                }
            }
        }



    }


    public void next(View view) {
        if (rt == 0) {
            TextView e1 = (TextView) findViewById(R.id.editText3);
            e1.setText("Correct : 0");
            TextView e2 = (TextView) findViewById(R.id.editText4);
            e2.setText("Incorrect : 0");
        }
        if (rt <= 10) {
            TextView b = (TextView) findViewById(R.id.editText2);

            Random rand = new Random();
            int j = 2;
            result = 0;
            int i = rand.nextInt((10000 - 1) + 1) + 1;
            while (j <= i / 2) {
                if (i % j == 0) {
                    result = 1;
                }
                j++;
            }
            Button bb = (Button) findViewById(R.id.next);
            bb.setText("Next");
            Button b1 = (Button) findViewById(R.id.yes);
            b1.setEnabled(true);

            Button b2 = (Button) findViewById(R.id.no);
            b2.setEnabled(true);
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);
            //b1.setBackgroundColor(Color.GRAY);
            //b2.setBackgroundColor(Color.GRAY);
            b1.setBackgroundResource(android.R.drawable.btn_default);
            b2.setBackgroundResource(android.R.drawable.btn_default);
            b.setText("Is " + Integer.toString(i) + " a prime number??");
            Log.d("as", "saaa");
            //id.setBackgroundColor(Color.WHITE);

            TextView e5 = (TextView) findViewById(R.id.editText);
            e5.setText("");
            rt++;
            if (rt == 10) {
                bb.setText("End");
                rt = 11;
            }
        } else {
            rt = 0;
            TextView b = (TextView) findViewById(R.id.editText2);
            b.setText("Hope You Enjoyed the Game.");
            Button b1 = (Button) findViewById(R.id.yes);
            b1.setEnabled(true);

            Button b2 = (Button) findViewById(R.id.no);
            b2.setEnabled(true);
            b1.setVisibility(View.INVISIBLE);
            b2.setVisibility(View.INVISIBLE);
            TextView e = (TextView) findViewById(R.id.editText4);
            String s = e.getText().toString();
            int n = s.length();
            String str = "";
            for (int i = 12; i < n; i++) {
                char c = s.charAt(i);
                str = str + c;
            }
            n = Integer.parseInt(str);
            TextView e1 = (TextView) findViewById(R.id.editText3);
            String s1 = e1.getText().toString();
            int n1 = s1.length();
            String str1 = "";
            for (int i = 10; i < n1; i++) {
                char c = s1.charAt(i);
                str1 = str1 + c;
            }
            n1 = Integer.parseInt(str1);
            int n2 = 10 * n1 - 5 * n;
            TextView e5 = (TextView) findViewById(R.id.editText);
            e5.setText("Score : " + Integer.toString(n2));
            Button bb = (Button) findViewById(R.id.next);
            bb.setText("Start Again!");
        }
        f=0;
    }

    public void yes(View view) {
        f=1;
        Button b1 = (Button) findViewById(R.id.no);
        b1.setEnabled(false);
        if (result == 1) {
            Button b = (Button) findViewById(R.id.yes);
            b.setBackgroundColor(Color.RED);
            b.setEnabled(false);
            //b.setText("Is " + Integer.toString(i) + " a prime number??");
            Log.d("aaaaa", "saaa");

            TextView e = (TextView) findViewById(R.id.editText4);
            String s = e.getText().toString();
            int n = s.length();
            String str = "";
            for (int i = 12; i < n; i++) {
                char c = s.charAt(i);
                str = str + c;
            }
            n = Integer.parseInt(str);
            n++;
            e.setText("Incorrect : " + Integer.toString(n));
            Log.d(Integer.toString(n), str);
            Toast.makeText(this, "Oops! Wrong Answer.", Toast.LENGTH_SHORT).show();
        } else {
            Button b = (Button) findViewById(R.id.yes);
            b.setBackgroundColor(Color.GREEN);
            b.setEnabled(false);
            //b.setBackgroundColor(Color.RED);
            TextView e = (TextView) findViewById(R.id.editText3);
            String s = e.getText().toString();
            int n = s.length();
            String str = "";
            for (int i = 10; i < n; i++) {
                char c = s.charAt(i);
                str = str + c;
            }
            n = Integer.parseInt(str);
            n++;
            e.setText("Correct : " + Integer.toString(n));
            Log.d(Integer.toString(n), str);
            Toast.makeText(this, "You got it Right!", Toast.LENGTH_SHORT).show();
            Log.d("aaaaa", "saaa");
        }
    }

    public void no(View view) {
        f=2;
        Button b1 = (Button) findViewById(R.id.yes);
        b1.setEnabled(false);
        if (result == 1) {
            Button b = (Button) findViewById(R.id.no);
            b.setEnabled(false);
            //b.setText("Is " + Integer.toString(i) + " a prime number??");
            TextView e = (TextView) findViewById(R.id.editText3);
            String s = e.getText().toString();
            int n = s.length();
            String str = "";
            for (int i = 10; i < n; i++) {
                char c = s.charAt(i);
                str = str + c;
            }
            n = Integer.parseInt(str);
            n++;
            e.setText("Correct : " + Integer.toString(n));
            Log.d(Integer.toString(n), str);

            Log.d("as", "saaa");
            b.setBackgroundColor(Color.GREEN);
            Toast.makeText(this, "You got it Right!", Toast.LENGTH_SHORT).show();
        } else {
            Button b = (Button) findViewById(R.id.no);
            b.setBackgroundColor(Color.RED);
            b.setEnabled(false);
            // b.setBackgroundColor(Color.RED);
            TextView e = (TextView) findViewById(R.id.editText4);
            String s = e.getText().toString();
            int n = s.length();
            String str = "";
            for (int i = 12; i < n; i++) {
                char c = s.charAt(i);
                str = str + c;
            }
            n = Integer.parseInt(str);
            n++;
            e.setText("Incorrect : " + Integer.toString(n));
            Log.d(Integer.toString(n), str);
            Toast.makeText(this, "Oops! Wrong Answer.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putInt("rt", rt);
        outState.putInt("f", f);
        outState.putInt("result", result);
        TextView e = (TextView) findViewById(R.id.editText4);
        String s = e.getText().toString();
        outState.putString("s", s);
        TextView ee = (TextView) findViewById(R.id.editText3);
        String ss = ee.getText().toString();
        outState.putString("ss", ss);
        TextView eee = (TextView) findViewById(R.id.editText2);
        String sss = eee.getText().toString();
        outState.putString("sss", sss);
        TextView e1 = (TextView) findViewById(R.id.editText);
        String s1 = e1.getText().toString();
        outState.putString("s1", s1);
        Button b = (Button) findViewById(R.id.next);
        String start=b.getText().toString();
        outState.putString("start",start);
        super.onSaveInstanceState(outState);
    }
}