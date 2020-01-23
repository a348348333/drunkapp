package com.example.cyrus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Call extends AppCompatActivity {
    final static String CALL = "android.intent.action.CALL";
    Button call;
    TextView AA,BB;
    Spinner City,Taxi;
    List<String> list;
    int count=0,state=0;
    String phone="",temp="";

    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        setTitle("酒醉代駕");
        call = (Button) this.findViewById(R.id.call);
        AA = (TextView) this.findViewById(R.id.aa);
        BB = (TextView) this.findViewById(R.id.bb);

        call.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ phone));
                startActivity(call);
            }
        });

        list = new ArrayList<String>();
        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_gallery_item,list);
        City = (Spinner)this.findViewById(R.id.city);
        // City.setPrompt("城市");
        Taxi = (Spinner)this.findViewById(R.id.taxi);
        ArrayAdapter<CharSequence> nAdapter = ArrayAdapter.createFromResource( this, R.array.city, android.R.layout.simple_spinner_dropdown_item );
        nAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        City.setAdapter(nAdapter);
        City.setVisibility(View.VISIBLE);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Taxi.setPrompt("計程車");
        Taxi.setAdapter(adapter);

        Taxi.setVisibility(View.VISIBLE);
        City.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                // City.setVisibility(View.VISIBLE);
                if(count!=0) {
                    for(int a =list.size()-1;a>= 0;a--)
                    {
                        list.remove(a);
                    }

                }
                if(adapterView.getSelectedItemPosition()==0)
                {
                    AA.setText("台北");
                    count+=1;
                    list.add("台北大都會");
                    list.add("優良計程車");
                    list.add("第一大車隊");
                    list.add("國華計程車");
                    state=0;


                }
                else if(adapterView.getSelectedItemPosition()==1)
                {
                    AA.setText("桃園");
                    count+=1;
                    list.add("桃園大都會");
                    list.add("合作大都會");
                    state=1;


                    // AA.setText(Integer.toString(list.size()));
                }
                else if(adapterView.getSelectedItemPosition()==2)
                {
                    AA.setText("台中");
                    count+=1;
                    list.add("台中大都會");
                    list.add("中南海計程車");
                    state=2;
                }
                else if(adapterView.getSelectedItemPosition()==3)
                {
                    AA.setText("台南");
                    count+=1;
                    list.add("台南大都會");
                    list.add("高鐵大都會");
                    list.add("嘉南大都會");
                    list.add("金榮大都會");
                    list.add("帝一大都會");
                    list.add("大仁大都會");
                    state=3;
                }
                else if(adapterView.getSelectedItemPosition()==4)
                {
                    AA.setText("高雄");
                    count+=1;
                    list.add("高雄大都會");
                    list.add("凱旋大都會車隊");
                    list.add("雄風大都會車隊");
                    state=4;
                }
                Taxi.setSelection(0);
                BB.setText(Taxi.getSelectedItem().toString());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Call.this, "您沒有選擇任何項目", Toast.LENGTH_LONG).show();
            }
        });
        Taxi.setAdapter(adapter);
        Taxi.setVisibility(View.VISIBLE);

        Taxi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                adapterView.setVisibility(View.VISIBLE);

                if(state==0)
                {
                    temp=adapterView.getSelectedItem().toString();
                    BB.setText(temp);
                    if(i==0)
                    {
                        phone="55178";
                    }
                    else if(i==1)
                    {
                        phone="024499988";
                    }
                    else if(i==2)
                    {
                        phone="024499778";
                    }
                    else if(i==3)
                    {
                        phone="024499178";
                    }
                }
                else if(state==1)
                {
                    temp=Taxi.getSelectedItem().toString();
                    BB.setText(temp);
                    if(i==0)
                    {
                        phone="034499178";
                    }
                    else if(i==1)
                    {
                        phone="033558000";
                    }
                }
                else if(state==2)
                {
                    temp=Taxi.getSelectedItem().toString();
                    BB.setText(temp);
                    if(i==0)
                    {
                        phone="044499178";
                    }
                    else if(i==1)
                    {
                        phone="0423163388";
                    }
                }
                else if(state==3)
                {
                    temp=Taxi.getSelectedItem().toString();
                    BB.setText(temp);
                    if(i==0)
                    {
                        phone="064499178";
                    }
                    else if(i==1)
                    {
                        phone="062899999";
                    }
                    else if(i==2)
                    {
                        phone="062099999";
                    }
                    else if(i==3)
                    {
                        phone="062749000";
                    }
                    else if(i==4)
                    {
                        phone="062255555";
                    }
                    else if(i==5)
                    {
                        phone="062606666";
                    }
                }
                else if(state==4)
                {
                    temp=Taxi.getSelectedItem().toString();
                    BB.setText(temp);
                    if(i==0)
                    {
                        phone="074499178";
                    }
                    else if(i==1)
                    {
                        phone="077241111";
                    }
                    else if(i==2)
                    {
                        phone="075561111";
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Call.this, "您沒有選擇任何城市", Toast.LENGTH_LONG).show();
            }
        });
    }
}
