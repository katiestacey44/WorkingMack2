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
    private String CurrLetter;
    private String CurrFloor;
    private String NextRoom;
    private String NextLetter;
    private String Nextfloor;
    private Button button;

   private MainActivity2 A2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        A2 = new MainActivity2();


        //Clicking the button will swap to MainActivity2 for map stuff
        //this shouldn't be activated unless valid input for letter, floor and roombut I don't know how to implemen


    }


    public void openMainActivity2(View v){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);

    }


    public void CurEnter(View v){


        TextInputEditText Letter  = findViewById(R.id.CurrentLetterinput); //gets the input from user
        String CurrentL = Letter.getText().toString(); // makes it a string because its initially a char


            CurrLetter = CurrentL;                          // set the input to the right variable
            Log.d("Current letter input", CurrentL); // View > tools window> logcat

        //if you need to case view to a button for different function Button b = (Button) v, then import andriod.widget.Button
        //if you want to access a button that was not passed in to the original function, use button b  = FindViewById(R.id.BUTTONIDNAME)

        TextInputEditText FloorNum  = findViewById(R.id.CurrentFloorInput);//gets the input from user
        String CurrentF = FloorNum.getText().toString(); // makes it a string because its initially a char

            CurrFloor = CurrentF;                       // set the input to the right variable
            Log.d("Current Floor Number", CurrentF);


        TextInputEditText Num  = findViewById(R.id.CurrentRoomNum);//gets the input from user
        String CurrentN = Num.getText().toString(); // makes it a string because its initially a char

            CurrentRoom = CurrentN;                     // set the input to the right variable
            Log.d("Current Room Number", CurrentN);
        ((TextView)findViewById(R.id.textCurr)).setText("Current room: " + CurrentL + " " + CurrentF + "-"+ CurrentN);
            A2.setStart(Integer.parseInt(CurrentRoom));
    }

    public void NextEnter(View v){


        TextInputEditText Letter  = findViewById(R.id.NextLetterInput);//gets the input from user
        String NextL = Letter.getText().toString(); // makes it a string because its initially a char


            NextLetter = NextL;                     // set the input to the right variable
            Log.d("Next Letter input", NextL);



        TextInputEditText FloorNum  = findViewById(R.id.NextFloorInput);//gets the input from user
        String NextF = FloorNum.getText().toString(); // makes it a string because its initially a char


            Nextfloor = NextF;                      // set the input to the right variable
            Log.d("Next Floor Number", NextF);


        TextInputEditText Num  = findViewById(R.id.NextRoomNum);//gets the input from user
        String NextN = Num.getText().toString(); // makes it a string because its initially a char

            NextRoom = NextN;                       // set the input to the right variable
            Log.d("Next Room Number", NextN);

        ((TextView)findViewById(R.id.TextNext)).setText("Next room: " + NextL + " " + NextF + "-"+ NextN);

        A2.setEnd(Integer.parseInt(NextRoom));

        // if i want a pop up Toast.makeText(this, String, Toast.LENGTH_LONG).show();



    }

}