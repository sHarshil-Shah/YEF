package com.example.sum.yef;

import android.Manifest;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.TextView;

import java.util.Objects;



public class Main2Activity extends AppCompatActivity {

    private NotificationCompat.Builder builder;
    private NotificationManager notificationManager;
    private int notification_id;
    private RemoteViews remoteViews;
    private Context context;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        context=this;

        Log.d("mainActivity2", "In main2");

        (Objects.requireNonNull(getSupportActionBar())).setDisplayHomeAsUpEnabled(true);
        Log.d("mainActivity2", "after back button");

        Button btnCall = findViewById(R.id.btn_call);
        btnCall.setOnClickListener(listen);

        Log.d("mainActivity2", "call button");

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        remoteViews = new RemoteViews(getPackageName(), R.layout.notification);
        remoteViews.setImageViewResource(R.id.imageView,R.mipmap.ic_yef_logo_round);
        remoteViews.setTextViewText(R.id.textView,"YEF");

        notification_id= (int) System.currentTimeMillis();
        Intent txtintent= new Intent("Reply_Clicked");
        txtintent.putExtra("id",notification_id);
        final Intent closeintent=new Intent("Close_Clicked");
        closeintent.putExtra("id",notification_id);

        PendingIntent pendingIntent=PendingIntent.getBroadcast(context,123,txtintent,0);
        remoteViews.setOnClickPendingIntent(R.id.btnreply,pendingIntent);

        pendingIntent = PendingIntent.getBroadcast(context, 123, closeintent, 0);
        remoteViews.setOnClickPendingIntent(R.id.btnclose,pendingIntent);

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        findViewById(R.id.btnnotify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inte=new Intent(context,MainActivity.class);
                PendingIntent pendingIntent1=PendingIntent.getActivity(context,0,inte,0);

                builder =new NotificationCompat.Builder(context);
                builder.setSmallIcon(R.mipmap.ic_yef_logo).setAutoCancel(true).setCustomBigContentView(remoteViews)
                        .setContentIntent(pendingIntent1);
                notificationManager.notify(notification_id,builder.build());
            }
        });
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

