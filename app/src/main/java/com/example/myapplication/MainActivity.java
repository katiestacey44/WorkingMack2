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

        boolean check1 = false;
        boolean check2 = false;
        boolean check3 = false;

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


            //PickGraphs();  // use the information gathered to figure out which graph to use


    }


    /**
     * will use the information changed from to the input of
     * the user to decide which graph will need to be displayed in activity_main2
     */

    public void PickGraphs(){

                C1floor C = new C1floor(CurrentRoom, NextRoom);
                PathGraph(C.getString());
    }

    public void PathGraph(String v){
        ((TextView)findViewById(R.id.PathText)).setText("Path: "+ v);
    }

    /**
     * @param R the inputed room number from the user
     * @param str A string to help with the warning pop up if the input is wrong
     * @return true if the input is an possible room number, three digits
     */

    public boolean CheckRoom(String R, String str){
        boolean result = false;
        int Num = Integer.parseInt(R);

        if(Num > 99 && Num < 1000){
            result = true;
        }
        else {                      //if the input is incorrect it will cause the view to have a pop up warning that lets the user know
            Toast.makeText(this, "Impossible " + str +" room number input!!!", Toast.LENGTH_LONG ).show();
        }

        return result;


    }
    /**
     * @param F the inputed floor number from the user
     * @param str A string to help with the warning pop up if the input is wrong
     * @return true if the input is an possible floor number, either 1 or 2
     */

    public boolean CheckFloor(String F, String str){
        boolean result= false;
        int floor = Integer.parseInt(F);

        if (floor >= 2 && floor <= 1){
            result = true;
        }
        else{                   // if the input is incorrect it will cause the view to have a pop up warning that lets the user know
            Toast.makeText(this, "Impossible " + str +" floor number input!!!", Toast.LENGTH_LONG ).show();
        }

        return result;

    }

    /**
     * @param L the inputed letter from the user
     * @param Str A string to help with the warning pop up if the input is wrong
     * @return true if the input is an possible letter for a building, A, a, B, b or C, c
     */

    public boolean CheckLetter(String L, String Str){

        boolean result= false;
        //V: Does java have string to uppercase function?
        switch (L){  // switch case for the possible building letter including for possible lower case inputs
            case "A":
                result = true;
                break;
            case "a":
                result = true;
                break;
            case "B":
                result = true;
                break;
            case "b":
                result = true;
                break;
            case "C":
                result = true;
                break;
            case "c":
                result = true;
                break;
            default: // if the input is incorrect it will cause the view to have a pop up warning that lets the user know

                Toast.makeText(this, "Impossible " + Str +" room letter input!!!", Toast.LENGTH_LONG ).show();
        }
        return result;

    }
}