package com.example.apoorv.jio_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main8Activity extends AppCompatActivity {
    TextView tb15;
    Button buy;
    String name;
    CART obj=new CART();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        tb15 = (TextView) findViewById(R.id.textView16);
        buy = (Button) findViewById(R.id.buyButton);
        String spec = getIntent().getStringExtra("spec");
        name = getIntent().getStringExtra("item");
        tb15.setText(spec);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(obj.hm.entrySet().size()!=3 && !obj.hm.containsKey(name)) {
                    obj.hm.put(name, 1);
                    //int price=checkPrice(name);
                    //obj.hmtotal.put(name,price);
                    Intent in = new Intent(getApplicationContext(), Main9Activity.class);
                    startActivity(in);
                }
                else{
                    Toast.makeText(getBaseContext(),"Only 1 piece of each item type can be bought by each user or maximum limit reached",Toast.LENGTH_LONG).show();
                    Intent in = new Intent(getApplicationContext(), Main9Activity.class);
                    startActivity(in);
                }

            }
        });
    }
    /*int checkPrice(String s){
       if(s.equals("JIO-PHONE"))
           return 1500;
       if(s.equals("JIO-FI"))
           return 999;
       if(s.equals("JIO-Fiber"))
           return 4500;
       return 0;
    }*/
}
