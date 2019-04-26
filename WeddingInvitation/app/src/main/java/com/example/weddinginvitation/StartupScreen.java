package com.example.weddinginvitation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartupScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_screen);
        Thread thread = new Thread() {
            public void run(){
                try

                {
                    sleep(5 * 1000); // a 5 second wait before going to the menu page
                    Intent i = new Intent(getApplicationContext(), MenuPage.class);
                    startActivity(i);
                }
                catch(Exception ex)
                {}
            }

        };
        thread.start();
    }
}
