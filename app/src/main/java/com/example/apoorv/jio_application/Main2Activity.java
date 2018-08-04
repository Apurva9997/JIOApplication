package com.example.apoorv.jio_application;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2Activity extends AppCompatActivity {

    Button b4;
    EditText ed,ed2;CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ed=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        b4=(Button)findViewById(R.id.button4);
        cb=(CheckBox)findViewById(R.id.checkBox);
        //ed3=(EditText)findViewById(R.id.editText10);
        SharedPreferences sp = getSharedPreferences("sp1" , Context.MODE_PRIVATE);
        String uname=sp.getString("username",null);
        String pwd=sp.getString("password",null);
        if(!(uname==null) && !(pwd==null)){
            ed.setText(uname);
            ed2.setText(pwd);
        }
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File root =getFilesDir();
                File dir = new File(root.getAbsolutePath()+"/Credentials");
                File f=new File(dir,"credentials.txt");
                try{
                    FileInputStream fin=new FileInputStream(f);
                    BufferedReader buf=new BufferedReader(new InputStreamReader(fin));
                    StringBuilder sb=new StringBuilder();
                    String n;
                    while((n =buf.readLine())!=null){
                        String[] arr=n.split(",");
                        //ed3.setText(arr[1]+"  "+arr[2]);
                        if(ed.getText().toString().equals(arr[1]) && ed2.getText().toString().equals(arr[2])){
                            //ed3.setText(ed.getText().toString()+"  "+ed2.getText().toString());
                            SharedPreferences sp=getSharedPreferences("sp1",MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putString("name",arr[0]);
                            editor.putString("username",arr[1]);
                            editor.putString("password",arr[2]);
                            editor.apply();
                            Intent in=new Intent(getApplicationContext(),Main6Activity.class);
                            startActivity(in);

                        }
                        else{
                            Toast.makeText(getBaseContext(),"User Not Found",Toast.LENGTH_LONG).show();
                        }

                    }
                }
                catch(IOException e){
                    e.printStackTrace();
                }

            }
        });
    }
    void showPassword(View v){
        int start,end;
        if(!cb.isChecked()){
            start=ed2.getSelectionStart();
            end=ed2.getSelectionEnd();
            ed2.setTransformationMethod(new PasswordTransformationMethod());;
            ed2.setSelection(start,end);
        }else{
            start=ed2.getSelectionStart();
            end=ed2.getSelectionEnd();
            ed2.setTransformationMethod(null);
            ed2.setSelection(start,end);
        }
    }
    void forgotPassword(View v){
        Intent in=new Intent(getApplicationContext(),Main3Activity.class);
        startActivity(in);
    }
}
