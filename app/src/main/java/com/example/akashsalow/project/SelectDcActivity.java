package com.example.akashsalow.project;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akashsalow.project.Bean.Registration;
import com.example.akashsalow.project.Bean.Room;

public class SelectDcActivity extends AppCompatActivity {

    private ListView mListView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_dc);

        mListView = (ListView) findViewById(R.id.dc_list);

        // Defined Array values to show in ListView
        String[] values = new String[] { "Bangalore",
                "Pune",
                "Jaipur",
                "Chandigarh",
                "Mysore",
                "Trivandrum",
                "Chennai",
                "Hyderabad",
                "Bhuvaneshwar"
        };

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, values);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String dc = ((TextView) view).getText().toString();

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SelectDcActivity.this);

                // set title
                alertDialogBuilder.setTitle("Confrim");

                // set dialog message
                alertDialogBuilder
                        .setMessage("Continue With Registration")
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, close
                                // current activity
                               // MainActivity.this.finish();
                                Registration registration = (Registration) getIntent().getSerializableExtra("Registration");
                                registration.setDc(dc);
                                Intent intent = new Intent(getApplicationContext(), ConfrimActivity.class);
                                intent.putExtra("Registration", registration);
                                startActivity(intent);

                                //Toast.makeText(getBaseContext(),registration.toString(), Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();


            }
        });
    }
}
