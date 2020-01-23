package com.example.cyrus;

import android.content.DialogInterface;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.text.format.Time;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class Blindness extends AppCompatActivity {

    private Button button;
    private ImageView img;
    private EditText usr_ans;
    private int last, num, ans;
    private Time now;
    private Random rnd;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blindness);
        setTitle("視力測試");

        button = (Button)findViewById(R.id.blindness_submit);
        img = (ImageView)findViewById(R.id.blindness_image);
        usr_ans = (EditText)findViewById(R.id.blindness_ans);

        now = new Time();
        now.setToNow();
        rnd = new Random(now.second);

        last = -1;
        randomImage();
        i = 1;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(usr_ans.getText().toString()) == ans) {
                    if(i == 2)
                        pass();
                    else {
                        randomImage();
                        usr_ans.setText("");
                        ++i;
                    }
                }
                else
                    fail();
            }
        });

    }

    protected void randomImage()
    {
        do {
            num = rnd.nextInt() % 15;
            if (num < 0)
                num *= -1;
        }
        while(num == last);
        switch (num){
            case 0:
                img.setImageResource(R.drawable.plate1);
                ans = 8;
                break;
            case 1:
                img.setImageResource(R.drawable.plate2);
                ans = 29;
                break;
            case 2:
                img.setImageResource(R.drawable.plate3);
                ans = 5;
                break;
            case 3:
                img.setImageResource(R.drawable.plate4);
                ans = 3;
                break;
            case 4:
                img.setImageResource(R.drawable.plate5);
                ans = 15;
                break;
            case 5:
                img.setImageResource(R.drawable.plate6);
                ans = 74;
                break;
            case 6:
                img.setImageResource(R.drawable.plate7);
                ans = 6;
                break;
            case 7:
                img.setImageResource(R.drawable.plate8);
                ans = 45;
                break;
            case 8:
                img.setImageResource(R.drawable.plate9);
                ans = 5;
                break;
            case 9:
                img.setImageResource(R.drawable.plate10);
                ans = 7;
                break;
            case 10:
                img.setImageResource(R.drawable.plate11);
                ans = 16;
                break;
            case 11:
                img.setImageResource(R.drawable.plate12);
                ans = 73;
                break;
            case 12:
                img.setImageResource(R.drawable.plate13);
                ans = 26;
                break;
            case 13:
                img.setImageResource(R.drawable.plate14);
                ans = 42;
                break;
            case 14:
                img.setImageResource(R.drawable.plate15);
                ans = 12;
                break;
        }
        last = num;
    }

    protected void pass()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(Blindness.this);
        builder.setMessage(R.string.pass)
                .setTitle(R.string.Blindness)
                .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                }).show();
    }

    protected void fail()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(Blindness.this);
        builder.setMessage(R.string.fail)
                .setTitle(R.string.Blindness)
                .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                }).show();
    }
}
