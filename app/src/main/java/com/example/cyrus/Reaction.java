package com.example.cyrus;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.text.format.Time;
import android.os.Handler;
import android.widget.Button;
import java.util.Random;
import android.graphics.Color;

public class Reaction extends AppCompatActivity {

    private Button button;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Time now;
    private long start, end;
    private int rand, cur;
    private int [] num;
    private Random rnd;
    private boolean finished;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction);
        setTitle("反應測試");

        button = (Button)findViewById(R.id.reaction_start);
        button1 = (Button)findViewById(R.id.reaction_btn1);
        button2 = (Button)findViewById(R.id.reaction_btn2);
        button3 = (Button)findViewById(R.id.reaction_btn3);
        button4 = (Button)findViewById(R.id.reaction_btn4);
        button5 = (Button)findViewById(R.id.reaction_btn5);
        button6 = (Button)findViewById(R.id.reaction_btn6);
        button7 = (Button)findViewById(R.id.reaction_btn7);
        button8 = (Button)findViewById(R.id.reaction_btn8);
        button9 = (Button)findViewById(R.id.reaction_btn9);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finished = false;
                setnum();
            }
        });
    }

    protected void setnum()
    {
        now = new Time();
        now.setToNow();
        rnd = new Random(now.second);

        num = new int [9];
        for(int i = 0; i < 9; ++i) {
            num[i] = 0;
        }

        for(int i = 1; i < 10; ++i){
            rand = rnd.nextInt() % 9;
            if(rand < 0)
                rand *= -1;
            while(num[rand] != 0){
                rand = rnd.nextInt() % 9;
                if(rand < 0)
                    rand *= -1;
            }
            num[rand] = i;
        }

        button1.setText(Integer.toString(num[0]));
        button2.setText(Integer.toString(num[1]));
        button3.setText(Integer.toString(num[2]));
        button4.setText(Integer.toString(num[3]));
        button5.setText(Integer.toString(num[4]));
        button6.setText(Integer.toString(num[5]));
        button7.setText(Integer.toString(num[6]));
        button8.setText(Integer.toString(num[7]));
        button9.setText(Integer.toString(num[8]));

        cur = 1;

        new CountDownTimer(6000,1000){

            @Override
            public void onFinish() {
                if(!finished)
                    fail();
            }
            @Override
            public void onTick(long millisUntilFinished) {

            }
        }.start();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button1.setBackgroundColor(Color.rgb(255, 255, 255));
                if(cur == num[0]){
                    if(cur == 9)
                        pass();
                    ++cur;
                }
                else{
                    fail();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button2.setBackgroundColor(Color.rgb(255, 255, 255));
                if(cur == num[1]){
                    if(cur == 9)
                        pass();
                    ++cur;
                }
                else{
                    fail();
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button3.setBackgroundColor(Color.rgb(255, 255, 255));
                if(cur == num[2]){
                    if(cur == 9)
                        pass();
                    ++cur;
                }
                else{
                    fail();
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button4.setBackgroundColor(Color.rgb(255, 255, 255));
                if(cur == num[3]){
                    if(cur == 9)
                        pass();
                    ++cur;
                }
                else{
                    fail();
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button5.setBackgroundColor(Color.rgb(255, 255, 255));
                if(cur == num[4]){
                    if(cur == 9)
                        pass();
                    ++cur;
                }
                else{
                    fail();
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button6.setBackgroundColor(Color.rgb(255, 255, 255));
                if(cur == num[5]){
                    if(cur == 9)
                        pass();
                    ++cur;
                }
                else{
                    fail();
                }
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button7.setBackgroundColor(Color.rgb(255, 255, 255));
                if(cur == num[6]){
                    if(cur == 9)
                        pass();
                    ++cur;
                }
                else{
                    fail();
                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button8.setBackgroundColor(Color.rgb(255, 255, 255));
                if(cur == num[7]){
                    if(cur == 9)
                        pass();
                    ++cur;
                }
                else{
                    fail();
                }
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button9.setBackgroundColor(Color.rgb(255, 255, 255));
                if(cur == num[8]){
                    if(cur == 9)
                        pass();
                    ++cur;
                }
                else{
                    fail();
                }
            }
        });


    }

    protected void pass()
    {
        finished = true;
        AlertDialog.Builder builder = new AlertDialog.Builder(Reaction.this);
        builder.setMessage(R.string.pass)
                .setTitle(R.string.Reaction)
                .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                }).show();
    }

    protected void fail()
    {
        finished = true;
        AlertDialog.Builder builder = new AlertDialog.Builder(Reaction.this);
        builder.setMessage(R.string.fail)
                .setTitle(R.string.Reaction)
                .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        finish();
                    }
                }).show();
    }
}
