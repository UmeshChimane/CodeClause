package com.mycompany.smstelephony;

import android.app.*;

import android.os.*;

import android.widget.*;

import android.view.*;

import android.content.*;

import android.telephony.gsm.*;

import android.telephony.*;

import java.security.acl.*;

import android.*;

import android.Manifest;

import android.app.PendingIntent;

import android.content.Intent;

import android.os.Bundle;

import android.telephony.SmsManager;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.Toast;

import android.support.v4.app.*;

public class MainActivity extends Activity {

    EditText et_number,et_message;

    Button btn_send;

    String number,msg;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        et_number=findViewById(R.id.et_mobile_number);

        et_message=findViewById(R.id.et_message);

        btn_send=findViewById(R.id.btn_send);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);

        btn_send.setOnClickListener(new View.OnClickListener() {

				@Override				public void onClick(View v) {

					number=et_number.getText().toString();

					msg=et_message.getText().toString();

					Intent it=new Intent(MainActivity.this,MainActivity.class);

					PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),0,it,0);

					SmsManager sms=SmsManager.getDefault();

					sms.sendTextMessage(number,null,msg,pi,null);

					Toast.makeText(MainActivity.this, "Message Send Successfully", Toast.LENGTH_SHORT).show();

				}

			});

    }}
