package com.example.apoorv.jio_application;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Main5Activity extends AppCompatActivity {
    OutputStream is;
    TextView t9;
    EditText ed6,ed8,ed9,ed7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ed7=(EditText)findViewById(R.id.editText7);
        ed6=(EditText)findViewById(R.id.editText6);
        ed9=(EditText)findViewById(R.id.editText9);
        ed8=(EditText)findViewById(R.id.editText8);

        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Main5Activity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},0);
        }
        //String mobile=getIntent().getStringExtra("mobile");
        SharedPreferences sp = getSharedPreferences("sp1" , Context.MODE_PRIVATE);
        String mobile=sp.getString("mobile",null);
        t9=(TextView)findViewById(R.id.textView9);
        t9.setText("Mobile Number"+mobile);

    }
    void onSubmit(View v){
        if(!(ed9.getText().toString().equals(ed8.getText().toString()))){
            Toast.makeText(getBaseContext(),"Password didn't match",Toast.LENGTH_SHORT).show();
        }
        else{
            String name=ed7.getText().toString();
            String username=ed6.getText().toString();
            String password=ed8.getText().toString();
            String saveData=name+","+username+","+password;
            WriteBtn(saveData);
        }
    }
    public void WriteBtn(String s) {
        File root =getFilesDir();
        File dir = new File(root.getAbsolutePath()+"/Credentials");
        if(!dir.exists()){
            dir.mkdir();
        }
        File f=new File(dir,"credentials.txt");
        try{
            FileOutputStream fos=new FileOutputStream(f);
            //String s=ed1.getText().toString();
            //s=s+"\n";
            fos.write(s.getBytes());
            Toast.makeText(getBaseContext(), "User registered successfully",
                    Toast.LENGTH_SHORT).show();
            Intent in=new Intent(getApplicationContext(),Main3Activity.class);
            startActivity(in);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
