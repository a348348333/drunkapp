package com.example.cyrus;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button info_btn = (Button)findViewById(R.id.info);
        Button banlance_btn = (Button)findViewById(R.id.balance);
        Button bac_btn = (Button)findViewById(R.id.bac);
        Button call_btn = (Button)findViewById(R.id.call);
        Button reaction_btn = (Button)findViewById(R.id.reaction);
        Button speak_btn = (Button)findViewById(R.id.speak);
        Button blindness_btn = (Button)findViewById(R.id.blindness);
        Button test_btn = (Button)findViewById(R.id.test);
        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(R.string.content)
                        .setTitle(R.string.info)
                        .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        }).show();
            }
        });
        banlance_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Balance.class);
                startActivity(intent);
            }
        });
        bac_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BAC.class);
                startActivity(intent);
            }
        });
        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Call.class);
                startActivity(intent);
            }
        });
        reaction_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Reaction.class);
                startActivity(intent);
            }
        });
        speak_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Speak.class);
                startActivity(intent);
            }
        });
        blindness_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Blindness.class);
                startActivity(intent);
            }
        });
        test_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Call.class);
                startActivity(intent);
                intent = new Intent(MainActivity.this, Blindness.class);
                startActivity(intent);
                intent = new Intent(MainActivity.this, Speak.class);
                startActivity(intent);
                intent = new Intent(MainActivity.this, Reaction.class);
                startActivity(intent);
                intent = new Intent(MainActivity.this, Balance.class);
                startActivity(intent);
                intent = new Intent(MainActivity.this, BAC.class);
                startActivity(intent);
            }
        });
    }
}
