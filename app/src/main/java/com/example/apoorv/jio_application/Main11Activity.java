package com.example.apoorv.jio_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class Main11Activity extends AppCompatActivity {

    EditText ed11,ed12,ed14;
    TextView tv22;
    Button b10;
    CART obj=new CART();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        ed11=(EditText)findViewById(R.id.editText11);
        ed12=(EditText)findViewById(R.id.editText12);
        ed14=(EditText)findViewById(R.id.editText14);
        tv22=(TextView)findViewById(R.id.textView22);
        b10=(Button)findViewById(R.id.button10);
        if(obj.hmrech.containsKey("recharge")){
            tv22.setText("\t\t\t\t\tAmount:\t\t"+obj.hmrech.get("recharge"));
        }
        if(obj.hmrech.containsKey("billing")){
            tv22.setText("\t\t\t\t\tAmount:\t\t"+obj.hmrech.get("billing"));
        }
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed11.getText().toString().equals("") && ed12.getText().toString().equals("") && ed14.getText().toString().equals(""))
                    Toast.makeText(getBaseContext(),"All field are mandatory",Toast.LENGTH_LONG).show();
                else
                    obj.hmrech.remove("recharge");
                obj.hmrech.remove("billing");
                Toast.makeText(getBaseContext(),"Payment successful",Toast.LENGTH_LONG).show();
                Intent in=new Intent(getApplicationContext(),Main6Activity.class);
                startActivity(in);
            }
        });
    }
}
