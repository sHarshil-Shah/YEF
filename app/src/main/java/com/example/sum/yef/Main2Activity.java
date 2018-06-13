package com.example.sum.yef;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Objects;

public class Main2Activity extends AppCompatActivity {



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Log.d("mainActivity2", "main2 on click");


        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Log.d("mainActivity2", "after back button");


        /*ListAdapter myAdapter = new customAdapter(this,names);
        ListView myListView = findViewById(R.id.myListView);
        myListView.setAdapter(myAdapter);*/

        Log.d("mainActivity2", "after add back button");

        Button btnCall = findViewById(R.id.btn_call);
        btnCall.setOnClickListener(listen);


        Log.d("mainActivity2", "call button");
    }

    private View.OnClickListener listen = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_call:

                    Log.d("mainActivity2", "In btn_call");
                    TextView telNumber = findViewById(R.id.c);
                    callPerson(telNumber.getText().toString());
                    break;
                default:
                    break;
            }
        }
    };


    public void callPerson(final String phoneNumber) {

        Log.d("mainActivity2", "In call person");
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:123456789"));
        int checkPermission = checkCallingPermission(Manifest.permission.CALL_PHONE);
        if(checkPermission != PackageManager.PERMISSION_GRANTED){
            Log.d("mainActivity2", "permission check");
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
        }
    }
}