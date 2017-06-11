package com.example.akashsalow.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akashsalow.project.Bean.Registration;

public class RegistrationActivity extends AppCompatActivity {

    private EditText mNameView;
    private TextView mErrorView;
    private EditText mPhoneNoView;
    private CheckBox mJavaView,mAppleView,mAndroidView;
    private Spinner mUnitSpinner;
    private Button mContinueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mNameView = (EditText) findViewById(R.id.name);
        mPhoneNoView = (EditText) findViewById(R.id.phoneNO);
        mJavaView = (CheckBox) findViewById(R.id.java);
        mAppleView = (CheckBox) findViewById(R.id.apple);
        mAndroidView = (CheckBox) findViewById(R.id.androidCB);
        mUnitSpinner = (Spinner) findViewById(R.id.unit_spinner);
        mContinueBtn = (Button) findViewById(R.id.continue_button);
        mErrorView = (TextView) findViewById(R.id.errorReg);

        mContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder resultCB=new StringBuilder();
                if(mJavaView.isChecked()){
                    resultCB.append("Java ");
                }if(mAppleView.isChecked()){
                    resultCB.append("Apple ");

                }if(mAndroidView.isChecked()){
                    resultCB.append("Android ");
                }

                try {
                    Registration registration = new Registration();
                    registration.setName(mNameView.getText().toString());
                    registration.setPhoneNumber(Integer.parseInt(mPhoneNoView.getText().toString()));
                    registration.setUnit(mUnitSpinner.getSelectedItem().toString());
                    registration.setTechnology(resultCB.toString());
                    Intent intent = new Intent(getApplicationContext(), SelectDcActivity.class);
                    intent.putExtra("Registration", registration);
                    startActivity(intent);

                    //Toast.makeText(getBaseContext(),registration.toString(), Toast.LENGTH_LONG).show();

                }catch (Exception e){
                    mErrorView.setText("Please enter all the details");
                }

            }
        });

    }
}
