package com.example.weddinginvitation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper functionInformationDB;

    Button createButton;
    EditText name1, name2,function,location,time, date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        functionInformationDB = new DatabaseHelper(this);

        name1 = (EditText) findViewById(R.id.etName_1);
        name2 = (EditText) findViewById(R.id.etName_2);
        function = (EditText) findViewById(R.id.etFunction);
        location = (EditText) findViewById(R.id.etLocation);
        time = (EditText) findViewById(R.id.etTime);
        date = (EditText) findViewById(R.id.etDate);
        createButton = (Button) findViewById(R.id.createButton);

        AddData();

    }

    public void AddData(){
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name_1 = name1.getText().toString();
                String name_2 = name2.getText().toString();
                String Function = function.getText().toString();
                String Location = location.getText().toString();
                String Time = time.getText().toString();
                String Date = date.getText().toString();

                boolean insertData = functionInformationDB.addData(name_1,name_2,Function,Location,Time,Date);
                // ^ data is inserted into database in the DatabaseHelper activity

                if(insertData == true){
                    Toast.makeText(MainActivity.this, "Wedding Invitation Is Created", Toast.LENGTH_LONG).show();
                    // Toast shows an pop which determines whether creation was sucessful or not
                }else{
                    Toast.makeText(MainActivity.this, "Data input error", Toast.LENGTH_LONG).show(); //tells user theres an error
                }

                Intent myIntent = new Intent(getBaseContext(),   FunctionList.class); // once invitation created sent to the next activity page
                startActivity(myIntent);
            }
        });
    }
}
