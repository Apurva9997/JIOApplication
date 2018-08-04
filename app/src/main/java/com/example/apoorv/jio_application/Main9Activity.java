package com.example.apoorv.jio_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;

public class Main9Activity extends AppCompatActivity {
    TextView tb17;Button b8;
    CART obj=new CART();
    int count=0,total=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        tb17=(TextView)findViewById(R.id.textView17);
        b8=(Button)findViewById(R.id.button8);
        String items="\tItems\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tQuantity\n";
        for(Map.Entry m:obj.hm.entrySet()) {
            ++count;
            if(m.getKey().toString().equals("JIO-PHONE")){
            items += "\t" + m.getKey() + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + m.getValue() + "\n";
            total+=1500;
            }
            if(m.getKey().toString().equals("JIO-FI")){
                items += "\t" + m.getKey() + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + m.getValue() + "\n";
                total+=999;
            }
            if(m.getKey().toString().equals("JIO-Fiber")){
                items += "\t" + m.getKey() + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + m.getValue() + "\n";
                total+=4500;
            }
        }
        items+="\n\t\tTotal items\t\t\t\t\t\t\t\t\t="+count;
        items+="\n\t\tTotal Amount\t\t\t\t=";
        items+=Integer.toString(total);
        tb17.setText(items);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(total>0){
                    obj.hmrech.put("billing",total);
                    Intent in=new Intent(getApplicationContext(),Main11Activity.class);
                    startActivity(in);
                }
            }
        });
    }
}
