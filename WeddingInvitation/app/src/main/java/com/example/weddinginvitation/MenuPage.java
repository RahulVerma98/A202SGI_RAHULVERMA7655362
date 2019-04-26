package com.example.weddinginvitation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MenuPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        ImageButton invitationCreatebtn,functionList;

        invitationCreatebtn = (ImageButton) findViewById(R.id.invCreateBtn);
        functionList = (ImageButton) findViewById(R.id.functionList);

        invitationCreatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Image button is linked to corresponding page
                Intent creator_page = new Intent(getBaseContext(),   MainActivity.class);
                startActivity(creator_page);
            }
        });

        functionList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Image button is linked to corresponding page
                Intent list_page = new Intent(getBaseContext(),   FunctionList.class);
                startActivity(list_page);
            }
        });
    }
}
