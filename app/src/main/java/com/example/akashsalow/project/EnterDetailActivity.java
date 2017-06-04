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

import com.example.akashsalow.project.Bean.Room;

import java.io.Serializable;

/**
 * Created by Akash Salow on 03-06-2017.
 * First Name(Edit Text)
 Last Name(Edit Text)
 Phone Number(Ph No field)
 Address(TextArea)
 Number of Guest(Number field)
 Total Number of rooms(Number field)
 Book Rooms(Button)

 */

public class EnterDetailActivity extends AppCompatActivity {

    private EditText mFirstNameView;
    private EditText mLastNameView;
    private EditText mPhoneNumberView;
    private EditText mAddressView;
    private EditText mNoOfGuestsView;
    private EditText mTotalNoOfRoomsView;
    private Room room;


    private Button mBookRoomsBTNView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_detail);

        setupWindowAnimations();
        mFirstNameView = (EditText) findViewById(R.id.firstname);
        mLastNameView = (EditText) findViewById(R.id.lastname);
        mPhoneNumberView = (EditText) findViewById(R.id.phone);
        mAddressView = (EditText) findViewById(R.id.address);
        mNoOfGuestsView = (EditText) findViewById(R.id.guest);
        mTotalNoOfRoomsView = (EditText) findViewById(R.id.rooms);
        mBookRoomsBTNView = (Button) findViewById(R.id.bookBTN);

        room = new Room();

        mBookRoomsBTNView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    room.setFirstName(mFirstNameView.getText().toString());
                    room.setLastName(mLastNameView.getText().toString());
                    room.setPhoneNumber( Integer.parseInt(mPhoneNumberView.getText().toString()) );
                    room.setAddress(mAddressView.getText().toString());
                    room.setNoOfGuests(Integer.parseInt(mNoOfGuestsView.getText().toString()));
                    room.setTotalNoOfRooms(Integer.parseInt(mTotalNoOfRoomsView.getText().toString()));

                    //Toast.makeText(EnterDetailActivity.this,room.toString(), Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getApplicationContext(), ConfirmDetailActivity.class);
                    intent.putExtra("Room", room);
                    startActivity(intent);
                }catch (Exception e){
                    TextView error = (TextView) findViewById(R.id.errorDetail);
                    error.setText("Please Fill All the Fieds");
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
