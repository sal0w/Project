package com.example.akashsalow.project;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText mEmailView;
    private EditText mPasswordView;
    private Button mSinginBTNView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupWindowAnimations();
        mEmailView = (EditText) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        mSinginBTNView = (Button) findViewById(R.id.signinBTN);

        mSinginBTNView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, mEmailView.getText() +" "+ mPasswordView.getText()+" "+mEmailView.getText().equals("User001") , Toast.LENGTH_LONG).show();
                if(mEmailView.getText().toString().equals("User001") && mPasswordView.getText().toString().equals("pwd123")){
                    //Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
                    // last EnterDetailActivity
                    Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                    startActivity(intent);


                }
                else{
                    TextView error = (TextView) findViewById(R.id.error);
                    error.setText("Please check Username and Password");
                    //Toast.makeText(getBaseContext(), "Fail", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations() {

        Slide slide = new Slide();
        slide.setDuration(1000);
        getWindow().setEnterTransition(slide);
    }
}
