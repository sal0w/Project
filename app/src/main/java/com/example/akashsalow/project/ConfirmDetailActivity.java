package com.example.akashsalow.project;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akashsalow.project.Bean.Room;

public class ConfirmDetailActivity extends AppCompatActivity {

    private TextView mFirstNameView;
    private TextView mLastNameView;
    private TextView mPhoneNumberView;
    private TextView mAddressView;
    private TextView mNoOfGuestsView;
    private TextView mTotalNoOfRoomsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_detail);

        setupWindowAnimations();

        mFirstNameView = (TextView) findViewById(R.id.dfirstname);
        mLastNameView = (TextView) findViewById(R.id.dlastname);
        mPhoneNumberView = (TextView) findViewById(R.id.dphonenumber);
        mAddressView = (TextView) findViewById(R.id.daddress);
        mNoOfGuestsView = (TextView) findViewById(R.id.dguests);
        mTotalNoOfRoomsView = (TextView) findViewById(R.id.drooms);

        Room room = (Room) getIntent().getSerializableExtra("Room");

        mFirstNameView.setText("First Name : "+room.getFirstName());
        mLastNameView.setText("Last Name : "+room.getLastName());
        mPhoneNumberView.setText("Phone Number : "+room.getPhoneNumber().toString());
        mAddressView.setText("Address : "+room.getAddress());
        mNoOfGuestsView.setText("No Of Guests : "+room.getNoOfGuests().toString());
        mTotalNoOfRoomsView.setText("Total No Of Rooms : "+room.getTotalNoOfRooms().toString());

        Button confrimBtn = (Button) findViewById(R.id.confrimBTN);

        confrimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Booked Successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        //Toast.makeText(getBaseContext(), "Confirm  "+room.toString(), Toast.LENGTH_LONG).show();



    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations() {

        Slide slide = new Slide();
        slide.setDuration(1000);
        getWindow().setEnterTransition(slide);
    }
}
