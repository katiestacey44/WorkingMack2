package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;


/**
 * MainActivity is the main activity of the Android Map Navigation App.
 * It allows users to input current and next room numbers and navigate to the
 * MainActivity2 activity to display the navigation path.
 */

public class MainActivity extends AppCompatActivity {
    private String currentRoom;
    private String nextRoom;
    private TextInputLayout currentInput;
    private TextInputLayout nextInput;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentInput = findViewById(R.id.currentInputLayout);
        nextInput = findViewById(R.id.nextInputLayout);

        //initialize the map
        C1floor c = new C1floor();
        //Action when button is clicked
        Button button = findViewById(R.id.confirmButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkInput(c);
            }
        });
    }





    /**
     * Sets the next room number based on the user input.
     * //@param //v The View that was clicked.
     **/

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
    private boolean validateCurrentInput(C1floor c) {
        currentInput = findViewById(R.id.currentInputLayout);
        int number;
        String thisInput = currentInput.getEditText().getText().toString().trim();
        if (thisInput.isEmpty()) {
            currentInput.setError("Field cannot be empty");
            return false;
        }
        if (thisInput.length() < 3) {
            currentInput.setError("Input too short");
            return false;
        }
        if (thisInput.length() > 3) {
            currentInput.setError("Input length exceeded");
            return false;
        } else {
            //call check(int) function in C1 to see whether the room is found. Displays error otherwise
            number=Integer.parseInt(thisInput); //convert input from string to int
            if (c.check(number) == false) {
                currentInput.setError("invalid room number");
                return false;
            }
            else {
                currentInput.setError(null);
                currentInput.setErrorEnabled(false);
                currentRoom = thisInput;
                return true;
            }
        }
    }
    //Tests the user input for NextRoom and displays errors in the TextInputLayout if the input is shorter than 3, no input,
    //Passes the C1floor to check whether a room number is valid
    private boolean validateNextInput(C1floor c) {
        int number;
        String thisInput = nextInput.getEditText().getText().toString().trim();

        if (thisInput.isEmpty()) {
            nextInput.setError("Field cannot be empty");
            return false;
        }
        if (thisInput.length() < 3) {
            nextInput.setError("Input too short");
            return false;
        }
        //Likely redundant because of textInputEditText parameter
        if (thisInput.length() > 3) {
            nextInput.setError("Input length exceeded");
            return false;
        }
        else {
            //call check(int) function in C1 to see whether the room is found. Displays error otherwise
            number = Integer.parseInt(thisInput); //convert input from string to int
            if (c.check(number) == false) {
                nextInput.setError("invalid room number");
                return false;
            }
            else {
                nextInput.setError(null);
                nextInput.setErrorEnabled(false);
                nextRoom = thisInput;
                return true;
            }
        }
    }
    private void openMainActivity2(){
        //if (!c.check(Integer.parseInt(currentRoom))){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("current", Integer.parseInt(currentRoom));
        intent.putExtra("next", Integer.parseInt(nextRoom));
        startActivity(intent);
    }

}




