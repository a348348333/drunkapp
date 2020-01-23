package com.example.cyrus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Test extends AppCompatActivity {
    private BAC_cal bac;
    Button Cal;
    EditText Weight,Hr,Min,Percent,Ml;
    Spinner Sex,Beer;
    int sex = 0,beer=0;
    Double Ebac_send;
    String s="";
    Intent i_back;
    Bundle b_back;
    Test_data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bac);

        bac = new BAC_cal();
        Cal = (Button)this.findViewById(R.id.cal);
        Sex = (Spinner)this.findViewById(R.id.sex);
        Beer = (Spinner)this.findViewById(R.id.beer);
        Weight=(EditText)this.findViewById(R.id.weight);
        Hr=(EditText)this.findViewById(R.id.hr);
        Min=(EditText)this.findViewById(R.id.min);
        Percent=(EditText)this.findViewById(R.id.percent);
        Ml=(EditText)this.findViewById(R.id.ml);
        //final AlertDialog[] alertDialog = new AlertDialog[1];//= getAlertDialog("測試結果","請選擇......");



        ArrayAdapter<CharSequence> nAdapter = ArrayAdapter.createFromResource( this, R.array.sex, android.R.layout.simple_spinner_dropdown_item );
        nAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        Sex.setAdapter(nAdapter);
        Sex.setVisibility(View.VISIBLE);
        nAdapter.notifyDataSetChanged();



        ArrayAdapter<CharSequence> mAdapter = ArrayAdapter.createFromResource( this, R.array.beer, android.R.layout.simple_spinner_dropdown_item );
        mAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        Beer.setAdapter(mAdapter);
        Beer.setVisibility(View.VISIBLE);
        mAdapter.notifyDataSetChanged();



        i_back = this.getIntent();
        b_back = i_back.getExtras();
        if(b_back != null)
        {
            Double a = b_back.getDouble("Wei");
            Double b = b_back.getDouble("Hr");
            Double c = b_back.getDouble("Min");
            Double d = b_back.getDouble("Percent");
            Double e = b_back.getDouble("Ml");
            Weight.setText( a.toString());
            Hr.setText( b.toString());
            Min.setText( c.toString());
            Percent.setText( d.toString());
            Ml.setText( e.toString());
            nAdapter.notifyDataSetChanged();
            mAdapter.notifyDataSetChanged();
            Sex.setSelection(b_back.getInt("Sex"),true);
            Beer.setSelection(b_back.getInt("Beer"),true);


        }


        Cal.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                bac.setWeight( Double.parseDouble(Weight.getText().toString()));
                bac.setPercent( Double.parseDouble(Percent.getText().toString()));
                bac.setHr( Double.parseDouble(Hr.getText().toString()));
                bac.setMin( Double.parseDouble(Min.getText().toString()));
                bac.setMl( Double.parseDouble(Ml.getText().toString()));
                bac.compute();
                Ebac_send = bac.getEBAC();




                Intent intent = new Intent();
                Bundle b = new Bundle();
                b.putDouble("E",Ebac_send);
                b.putDouble("Wei", Double.parseDouble(Weight.getText().toString()));
                b.putDouble("Percent", Double.parseDouble(Percent.getText().toString()));
                b.putDouble("Hr", Double.parseDouble(Hr.getText().toString()));
                b.putDouble("Min", Double.parseDouble(Min.getText().toString()));
                b.putDouble("Ml", Double.parseDouble(Ml.getText().toString()));
                b.putInt("Sex", Sex.getSelectedItemPosition());
                b.putInt("Beer", Beer.getSelectedItemPosition());

                intent.putExtras(b);
                intent.setClass(Test.this, BAC_output.class);
                startActivity(intent);
                finish();
            }
        });


        Sex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(adapterView.getSelectedItemPosition()==0)
                {
                    sex=0;
                }
                else if(adapterView.getSelectedItemPosition()==1)
                {
                    sex=1;
                }
                bac.setSex(sex);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Test.this, "您沒有選擇任何項目", Toast.LENGTH_LONG).show();
            }
        });


        Beer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(adapterView.getSelectedItemPosition()==0)
                {
                    beer=0;
                }
                else if(adapterView.getSelectedItemPosition()==1)
                {
                    beer=1;
                }
                else if(adapterView.getSelectedItemPosition()==2)
                {
                    beer=2;
                }
                bac.setBeer(beer);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Test.this, "您沒有選擇任何項目", Toast.LENGTH_LONG).show();
            }
        });

    }
}
