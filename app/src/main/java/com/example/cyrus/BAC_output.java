package com.example.cyrus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BAC_output extends AppCompatActivity {
    TextView Result,Value,Tip;
    String s="";
    String t="";
    Intent intent_get;
    Bundle bundle_get;
    Double Ebac;
    Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bac_output);
        setTitle("BAC");

        Result = (TextView) this.findViewById(R.id.result);
        Tip = (TextView) this.findViewById(R.id.tip);
        Value = (TextView) this.findViewById(R.id.value);
        Back = (Button) this.findViewById(R.id.back);
        intent_get = this.getIntent();
        bundle_get = intent_get.getExtras();
        Ebac = bundle_get.getDouble("E");

        if(Ebac<0.030)
        {
            s=("正常");
        }
        else if(Ebac>=0.030 && Ebac< 0.06)
        {
            s=("專注力損害\n" +
                    "多語\n" +
                    "抑制力下降");
        }
        else if(Ebac>=0.06 && Ebac< 0.090)
        {
            s=("感覺變得麻木\n" +
                    "去抑制\n" +
                    "外向");
        }
        else if(Ebac>=0.10 && Ebac<= 0.19)
        {
            s=( "情緒波動\n" +
                    "憤怒或悲傷\n" +
                    "喧鬧\n" +
                    "力比多下降");
        }
        else if(Ebac>=0.20 && Ebac< 0.29)
        {
            s=("目光呆滯；恍惚\n" +
                    "失去理解力\n" +
                    "感知受損\n" +
                    "可能陷入昏迷");
        }
        else if(Ebac>=0.30 && Ebac< 0.39)
        {
            s=("嚴重的中樞神經系統抑制\n" +
                    "不省人事\n" +
                    "可能致死");
        }
        else if(Ebac>=0.40 && Ebac<= 0.50)
        {
            s=("失去行為能力\n" +
                    "昏迷\n" +
                    "可能致死");
        }
        else//>.050
        {
            s=("很高風險中毒\n" +
                    "致死可能");
        }

        t=("(BAC超過0.03，罰鍰新台幣15,000至90,000元，吊扣駕照一年:超過0.05，吊扣駕照一年，並依公共危險罪移送法辦。)"
        );
        Tip.setText(t);
        Result.setText(s);




        String s = String.valueOf(Ebac);
        String t = s.substring(0, s.indexOf(".") + 5);
        Value.setText(t);

        Back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
