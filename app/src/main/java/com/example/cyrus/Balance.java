package com.example.cyrus;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.os.CountDownTimer;



public class Balance extends AppCompatActivity implements SensorEventListener {

    private TextView time;
    private Button btn, btn_s;
    private SensorManager aSensorManager;
    private Sensor aSensor;
    private float gravity[] = new float[3];
    private float max_x, min_x, max_y, min_y, max_z, min_z;
    boolean fail, stoped;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("平衡測試");

        setContentView(R.layout.activity_balance);

        time = (TextView)findViewById(R.id.textView8);
        btn = (Button)findViewById(R.id.start);
        btn_s = (Button)findViewById(R.id.stop);

        aSensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        aSensor = aSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        aSensorManager.registerListener(this, aSensor, aSensorManager.SENSOR_DELAY_NORMAL);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stoped = false;
                max_x = -10;
                min_x = 10;
                max_y = -10;
                min_y = 10;
                max_z = 0;
                min_z = 20;
                new CountDownTimer(30000,1000){

                    @Override
                    public void onFinish() {
                        if(!stoped)
                            time.setText("完成!");
                        result();
                    }

                    @Override
                    public void onTick(long millisUntilFinished) {
                        time.setText("剩餘時間："+millisUntilFinished/1000);
                    }

                }.start();
            }
        });

        btn_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stoped = true;
                AlertDialog.Builder builder = new AlertDialog.Builder(Balance.this);
                builder.setMessage(R.string.fail)
                        .setTitle(R.string.Balance)
                        .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        }).show();
            }
        });

    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        gravity[0] = event.values[0];
        gravity[1] = event.values[1];
        gravity[2] = event.values[2];
        if(gravity[0] > max_x)
            max_x = gravity[0];
        if(gravity[0] < min_x)
            min_x = gravity[0];
        if(gravity[1] > max_y)
            max_y = gravity[1];
        if(gravity[1] < min_y)
            min_y = gravity[1];
        if(gravity[2] > max_z)
            max_z = gravity[2];
        if(gravity[2] < min_z)
            min_z = gravity[2];
    }
    @Override
    protected void onPause()
    {
        aSensorManager.unregisterListener(this);
        super.onPause();
    }

    public void result()
    {
        fail = false;
        if (max_x - min_x >= 3 || max_y - min_y >= 3 || max_z - min_z >= 3)
            fail = true;
        if (fail) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Balance.this);
            builder.setMessage(R.string.fail)
                    .setTitle(R.string.Balance)
                    .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    }).show();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(Balance.this);
            builder.setMessage(R.string.pass)
                    .setTitle(R.string.Balance)
                    .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    }).show();
        }
    }
}