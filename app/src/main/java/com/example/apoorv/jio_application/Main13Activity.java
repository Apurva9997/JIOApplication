package com.example.apoorv.jio_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main13Activity extends AppCompatActivity {
    Spinner spinner;
    ListView lv;
    EditText ed10;
    ListView listView;
    TextView textView,tv24;
    String[] listItem;
    CART obj=new CART();
    Button b9;
    Intent in12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        /*spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.recharge, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);*/
        lv=(ListView)findViewById(R.id.listView);
        listView=(ListView)findViewById(R.id.listView);
        ed10=(EditText)findViewById(R.id.editText10);
        textView=(TextView)findViewById(R.id.textView);
        tv24=(TextView)findViewById(R.id.textView24);
        b9=(Button)findViewById(R.id.button9);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed10.getText().toString().equals("") || ed10.getText().toString().equals(null))
                    Toast.makeText(getBaseContext(),"Mobile number is required",Toast.LENGTH_SHORT).show();
                else {
                    in12 = new Intent(getApplicationContext(), Main11Activity.class);
                    startActivity(in12);
                }
            }
        });
        listItem = getResources().getStringArray(R.array.recharge_jiofib);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                int price=amount(position);
                obj.hmrech.put("recharge",price);
                tv24.setText("Value:\t\t\t\t"+price);
                //System.out.println("position*******"+position+"\n");

            }
        });

    }
    int amount(int a){
        //String[] arr=a.split("               ");
        switch(a){
            case 0:
                return 100;
            case 1:
                return 200;
            case 2:
                return 500;
            case 3:
                return 700;
            case 4:
                return 900;
            case 5:
                return 1600;
            case 6:
                return 2000;

        }
        return 0;
    }
}

