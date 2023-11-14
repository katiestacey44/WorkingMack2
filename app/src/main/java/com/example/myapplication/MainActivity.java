package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;

import java.util.LinkedList;


public class MainActivity extends AppCompatActivity {
    private String CurrentRoom;
    private String NextRoom;
   private MainActivity2 A2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openMainActivity2(View v){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("current",Integer.parseInt(CurrentRoom) );
        intent.putExtra("next",Integer.parseInt(NextRoom) );
        startActivity(intent);

    }

    public void CurEnter(View v){


        TextInputEditText Num  = findViewById(R.id.CurrentRoomNum);//gets the input from user

        String CurrentN = Num.getText().toString(); // makes it a string because its initially a char

        CurrentRoom = CurrentN;                     // set the input to the right variable

        ((TextView)findViewById(R.id.textCurr)).setText("Current room: C1 - "+ CurrentN);

    }

    public void NextEnter(View v){

        TextInputEditText Num  = findViewById(R.id.NextRoomNum);//gets the input from user

        String NextN = Num.getText().toString(); // makes it a string because its initially a char

        NextRoom = NextN;

        ((TextView)findViewById(R.id.TextNext)).setText("Next room: C1 - "+ NextN);


    }

}