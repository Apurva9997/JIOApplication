package com.example.apoorv.jio_application;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity {

    TextView t10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        t10=(TextView)findViewById(R.id.textView10);
        SharedPreferences sb= getSharedPreferences("sp1",MODE_PRIVATE);
        String name=sb.getString("name","null");
        String username=sb.getString("username","null");
        t10.setText("      \tWelcome   "+username);
    }
    void jiophone(View v){
        Intent in=new Intent(getApplicationContext(),Main8Activity.class);
        String spec="\tSpecifications\nScreen size (inches)\t2.40Processor\t1.2GHz dual-core\n" +
                "Processor make\tSPRD 9820A/QC8905\n" +
                "RAM\t512MB\n" +
                "Internal storage\t4\nGBRear camera\t2-megapixel\n" +
                "Front camera\t0.3-megapixel";
        in.putExtra("item","JIO-PHONE");
        in.putExtra("spec",spec);
        startActivity(in);
    }
    void jiofi(View v){
        Intent in=new Intent(getApplicationContext(),Main8Activity.class);
        String spec="\tSpecifications\nPortable Wi-Fi hotspot connects up to 10 devices and one on USB.\n" +
                "Enjoy HD voice calls, video calls on 2G / 3G phone via Jio4GVoice app.\n" +
                "The powerful 2300mAh battery which gives you a backup of 6 hours.\n" +
                "JioFi wifi router range easily cover 2 rooms.";
        in.putExtra("item","JIO-FI");
        in.putExtra("spec",spec);
        startActivity(in);
    }
    void jiofiber(View v){
        Intent in=new Intent(getApplicationContext(),Main8Activity.class);
        String spec="\tSpecifications\nJioFiber Price – The installation charge costs Rs 4500 which is refundable.\n" +
                "\n" +
                "JioFiber speed – Initially for 90 days, the user can expect a speed of up to 100Mbps. \nReportedly, the JioFiber will also be available with 1gbps plans.\n" +
                "\n" +
                "JioFiber plans – Jio.Care, which isn’t always the official jio internet site, notes that plans for JioFiber offer could be divided into three categories especially- jio giga fiber velocity-primarily based plans, jio giga fiber volume-primarily based plans and jio giga fiber special broadband plan.\n" +
                "\n" +
                "Jiofiber broadband – The Jio Giga Fiber Broadband volume-based monthly plans start from 5GB to 60GB daily. The 5GB daily plan costs Rs 1000, 10 GB daily plan for Rs 2000, 20GB daily plan costs Rs 3000, 40 GB daily plan for Rs 4000 and 60GB daily plan at Rs 5000. Validity is for 30 days.";
        in.putExtra("item","JIO-Fiber");
        in.putExtra("spec",spec);
        startActivity(in);
    }
    void jiophrech(View v){
            Intent in=new Intent(getApplicationContext(),Main10Activity.class);
            startActivity(in);
    }
    void processLogout(View v){
        SharedPreferences sharedpreferences = getSharedPreferences("sp1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.commit();
        Intent in=new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(in);
    }
    void jiofibrech(View v){
        Intent in=new Intent(getApplicationContext(),Main12Activity.class);
        startActivity(in);
    }
    void jiofirech(View v){
        Intent in=new Intent(getApplicationContext(),Main13Activity.class);
        startActivity(in);
    }
}
