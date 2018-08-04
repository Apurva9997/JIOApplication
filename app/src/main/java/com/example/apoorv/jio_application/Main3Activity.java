package com.example.apoorv.jio_application;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Main3Activity.this,new String[]{Manifest.permission.SEND_SMS},0);
        }
        ed=(EditText)findViewById(R.id.editText3);
    }
    void sendOTP(View v){
        String phone=ed.getText().toString();
        String otp=generateOTP();
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
        int num2=(int)num*1000000;
        String res=String.valueOf(num2);
        return res;
    }
}
