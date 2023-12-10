package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;


/**
 * MainActivity is the main activity of the Android Map Navigation App.
 * It allows users to input current and next room numbers and navigate to the
 * MainActivity2 activity to display the navigation path.
 */

public class MainActivity extends AppCompatActivity {
    private String mCurrentRoom;
    private String mNextRoom;
    private TextInputLayout mCurrentInput;
    private TextInputLayout mNextInput;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCurrentInput = findViewById(R.id.currentInputLayout);
        mNextInput = findViewById(R.id.nextInputLayout);

        //instantiates a C1floor object representing our graph of rooms
        C1floor c = new C1floor();
        //Action when button is clicked
        Button button = findViewById(R.id.confirmButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { //When button is clicked, check the input in the 2 input boxes
                checkInput(c);
            }
        });
    }





/**
 * Checks user input in the input boxes for current and next rooms by calling methods validateCurrentInput() and validateNextInput()
 * if both functions return true, mainactivity2 will be opened
 * @param c, the C1floor object used to access a method check(int)
 */

    private void checkInput(C1floor c) {
        //Function call to validateCurrentInput() and validateNextInput
        //If either or both of the functions return false (invalid input), this will exit this function
        if ( !validateCurrentInput(c)|!validateNextInput(c)) {
            return;
        }
        openMainActivity2();


    }

    //Input Validation functions
    //  Tests the user input for NextRoom and displays errors in the TextInputLayout if the input is shorter than 3, no input,
    //  Passes the C1floor c to check whether a room number is valid
    // For being valid, the input must be a 3digit number and be found in the list of rooms in C1floor
    private boolean validateCurrentInput(C1floor c) {
        mCurrentInput = findViewById(R.id.currentInputLayout);
        int number;
        String thisInput = mCurrentInput.getEditText().getText().toString().trim();
        //Validate the input
        if (thisInput.isEmpty()) {
            mCurrentInput.setError("Field cannot be empty");
            return false;
        }
        if (thisInput.length() < 3) {
            mCurrentInput.setError("Input too short");
            return false;
        }
        if (thisInput.length() > 3) { //The input box limits input to 3, but just in case
            mCurrentInput.setError("Input length exceeded");
            return false;
        } else {
            //call check(int) function in C1 to see whether the room is found. Displays error otherwise
            number=Integer.parseInt(thisInput); //convert input from string to int
            if (c.check(number)) { //Valid input, disable error message
                mCurrentInput.setError(null);
                mCurrentInput.setErrorEnabled(false);
                mCurrentRoom = thisInput;
                return true;
            } else {
                mCurrentInput.setError("invalid room number");
                return false;
            }
        }
    }
    //Tests the user input for NextRoom and displays errors in the TextInputLayout if the input is shorter than 3, no input,
    //Passes a C1floor object to call functions in C1floor to validate user input
    private boolean validateNextInput(C1floor c) {
        int number;
        String curInput = mCurrentInput.getEditText().getText().toString().trim(); //convert user input into string
        String thisInput = mNextInput.getEditText().getText().toString().trim(); //convert user input into string


        if (thisInput.isEmpty()) {
            mNextInput.setError("Field cannot be empty");
            return false;
        }
        if (thisInput.length() < 3) {
            mNextInput.setError("Input too short");
            return false;
        }
        //Likely redundant because of textInputEditText parameter
        if (thisInput.length() > 3) {
            mNextInput.setError("Input length exceeded");
            return false;
        }
        if (thisInput.equals(curInput))
        {
            mNextInput.setError("Current and Next cannot be the same room");
            return false;
        }
        else {
            //call to check(int) function in C1floor to see whether the room is found. Displays error otherwise
            number = Integer.parseInt(thisInput); //convert input from string to int
            if (!c.check(number)) {
                mNextInput.setError("Invalid room number");
                return false;
            }
            else {
                mNextInput.setError(null);
                mNextInput.setErrorEnabled(false);
                mNextRoom = thisInput;
                return true;
            }
        }
    }

    /**
     *This function passes the room numbers for current room and next room to the MainActivity2 class and switches to MainActivity2
     */
    private void openMainActivity2(){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("current", Integer.parseInt(mCurrentRoom));
        intent.putExtra("next", Integer.parseInt(mNextRoom));
        startActivity(intent);
    }

}




