package com.example.weddinginvitation;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FunctionList extends AppCompatActivity {

    DatabaseHelper functionInformationDB;

    ListView function_list;
    ListView details;


    ArrayList<String> listItem;
    ArrayAdapter adapter;

    ArrayList<String> details_list;
    ArrayAdapter details_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_list);




        functionInformationDB = new DatabaseHelper(this); // links to the database from the DatabaseHelper

        function_list = (ListView) findViewById(R.id.functionList); // Information from the variable where the user places there input
        details = (ListView) findViewById(R.id.details);

        listItem = new ArrayList<>(); // Array List to store the data in
        details_list = new ArrayList<>();


        viewData();

        function_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String text = function_list.getItemAtPosition(i).toString();
                String detail = details.getItemAtPosition(i).toString();
                Intent myIntent = new Intent(getBaseContext(),   InvitationViewer.class); // Destination where the data is going
                myIntent.putExtra("demo", detail); // Data is sent onto another activity in the project
                startActivity(myIntent);
            }
        });


    }


    private void viewData() {
        Cursor cursor = functionInformationDB.viewData();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Data to show", Toast.LENGTH_LONG).show();
        } else {
            while (cursor.moveToNext()) {
                // Generates an iteration where the data creates a list based on number of entries in the db
                listItem.add("The Wedding of: " + cursor.getString(1)+ " & " +cursor.getString(2));

                // this version is a more descriptive version which is showed only when user clicks on a list item
                details_list.add( "The Wedding of: " + cursor.getString(1)+ " & " +cursor.getString(2)+
                        "\n"+
                        "\n" + "Function: " + cursor.getString(3)+
                        "\n" + "Location: " + cursor.getString(4)+
                        "\n"+
                        "\n" + "Time: "  + cursor.getString(5) +
                        "\n" +" Date: " + cursor.getString(6));





            }

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
            function_list.setAdapter(adapter); // data is inserted into the array

            details_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, details_list);
            details.setAdapter(details_adapter);



        }
    }
}
