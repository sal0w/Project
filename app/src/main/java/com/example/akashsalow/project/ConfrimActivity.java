package com.example.akashsalow.project;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.akashsalow.project.Bean.Registration;
import com.example.akashsalow.project.Bean.Room;
import com.example.akashsalow.project.DAO.DatabaseHandler;

public class ConfrimActivity extends AppCompatActivity {

    private TextView mNameView;
    private TextView mPhoneNoView;
    private TextView mUnitView;
    private TextView mTechnologyView;
    private TextView mDcView;
    private Button mConfrimBtn;
    Registration registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confrim);
        mNameView = (TextView) findViewById(R.id.dName);
        mPhoneNoView = (TextView) findViewById(R.id.dphoneno);
        mUnitView = (TextView) findViewById(R.id.dunit);
        mTechnologyView = (TextView) findViewById(R.id.dtechnology);
        mDcView = (TextView) findViewById(R.id.ddc);
        mConfrimBtn = (Button) findViewById(R.id.confrim_button);


        registration = (Registration) getIntent().getSerializableExtra("Registration");
        mNameView.setText("NAME : "+registration.getName());
        mPhoneNoView.setText("PHONE NUMBER : "+registration.getPhoneNumber().toString());
        mUnitView.setText("UNIT : "+registration.getUnit());
        mTechnologyView.setText("TECHNOLOGY : "+registration.getTechnology());
        mDcView.setText("DC : "+registration.getDc());

        mConfrimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotification();
                DatabaseHandler db = new DatabaseHandler(ConfrimActivity.this,"sd",null,1);

                db.addRegistration(registration);
            }
        });

    }
    private void addNotification() {
        NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.salowicon)
                        .setContentTitle("Success")
                        .setContentText("You are registered successfully");

        Intent notificationIntent = new Intent(this, ConfrimActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
}
