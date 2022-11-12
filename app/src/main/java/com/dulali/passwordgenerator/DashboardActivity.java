package com.dulali.passwordgenerator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class DashboardActivity extends AppCompatActivity {

   LinearLayout passwordGenerator;
    AlertDialog.Builder exitDialog;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

     passwordGenerator = findViewById(R.id.passwordGenerator);
     mediaPlayer = new MediaPlayer();

//first card view for change activity
//        passwordGenerator.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                startActivity(new Intent(DashboardActivity.this,PasswordGeneratorActivity.class));
//
//            }
//        });
        passwordGenerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(DashboardActivity.this , R.raw.button);
                mediaPlayer.start();
                startActivity(new Intent(DashboardActivity.this , PasswordGeneratorActivity.class));
            }
        });

    }

    //when back pressed then this dialog pop up
    public void loadExitDialog(){

        //set title and message
        exitDialog = new AlertDialog.Builder(DashboardActivity.this);
        exitDialog.setTitle("Password Specialist");
        exitDialog.setMessage("Do you want to exit ?");
        exitDialog.setCancelable(false);

        exitDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                finishAffinity();
                System.exit(0);
            }
        });
        exitDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = exitDialog.create();
        alertDialog.show();
    }

    @Override
    public void onBackPressed(){
        loadExitDialog();
    }

}