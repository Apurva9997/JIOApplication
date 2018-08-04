package com.example.apoorv.jio_application;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    Button b5,b7;
    EditText ed4,ed5;
    String phone,otp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Main4Activity.this,new String[]{Manifest.permission.SEND_SMS},0);
        }
        ed4=(EditText)findViewById(R.id.editText4);//mobile number
        ed5=(EditText)findViewById(R.id.editText5);//otp
        b5=(Button)findViewById(R.id.button5);
        b7=(Button)findViewById(R.id.button7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed5.getText().toString().equals(otp)) {
                    Intent in = new Intent(getApplicationContext(), Main5Activity.class);
                    SharedPreferences sp = getSharedPreferences("sp1", Context.MODE_PRIVATE);
                    sp.edit().putString("mobile",phone).commit();
                    //in.putExtra("mobile", phone);
                    startActivity(in);
                }
                else{
                    Toast.makeText(getBaseContext(),"OTP didn't match try again!"+ed5.getText().toString()+"  "+otp,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    void sendOTP(View v){
        phone=ed4.getText().toString();
        otp=generateOTP();
        String otpM=otp+" is your OTP to login to your JIO account.Please do not share this with anyone";
        sendSMS(phone,otp);

    }
    public void sendSMS(String phoneNo, String msg) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }
    String generateOTP(){
        double num=Math.random();
        int num2=(int)(num*1000000);
        String res=String.valueOf(num2);
        return res;
    }

}
