package com.example.weddinginvitation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class InvitationViewer extends AppCompatActivity {

    ImageButton share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitation_viewer);



        Intent myIntent=getIntent();
        String txt = myIntent.getStringExtra("demo");

        TextView invitationViewer = (TextView)findViewById(R.id.invitationViewer);
        invitationViewer.setText(txt);

        share_btn = (ImageButton) findViewById(R.id.shareBtn);

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // when button is clicked
                Intent share = new Intent(Intent.ACTION_SEND); // allows user to share with other apps
                share.setType("text/plain");
                Intent myIntent=getIntent();
                String txt = myIntent.getStringExtra("demo"); // data from previous activity is going to be shared to other apps

                share.putExtra(Intent.EXTRA_TEXT, txt);
                startActivity(Intent.createChooser(share, "Share This On..."));
            }
        });

    }
}
