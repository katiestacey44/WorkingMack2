package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


/**
 * MainActivity is the main activity of the Android Map Navigation App.
 * It allows users to input current and next room numbers and navigate to the
 * MainActivity2 activity to display the navigation path.
 */

public class MainActivity extends AppCompatActivity {
    private String currentRoom;
    private String nextRoom;
    private TextInputEditText inputCurrentRoom;
    private TextInputEditText inputNextRoom;

    public MainActivity() {
    }

    private void checkInput();
    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being
     * shut down, this Bundle contains the data it most recently supplied
     * in onSaveInstanceState(Bundle). Otherwise, it is null.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputCurrentRoom = findViewById(R.id.currentInputlayout);
        inputNextRoom = findViewById(R.id.nextInputLayout);
    }
    private boolean validateCurrentInput() {
        String cInput = inputCurrentRoom.getEditText().getText().toString().trim();

    }
    /**
     * Opens MainActivity2 to display the navigation path based on the entered current and next room numbers.
     * @param v The View that was clicked.
     */

    public void openMainActivity2(View v){

        //create
        //C1floor c = new C1floor();

        //if (!c.check(Integer.parseInt(currentRoom))){

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("current", Integer.parseInt(currentRoom));
            intent.putExtra("next", Integer.parseInt(nextRoom));
            startActivity(intent);
        }
    }

    /**
     * Sets the current room number based on the user input.
     * @param v The View that was clicked.
     */

    private void checkInput(View v) {
        {
            if (!validateNextInput() | !validateCurrentInput()) {
                return;
            }

        }


    }
        /**
         * Sets the next room number based on the user input.
         * @param v The View that was clicked.
         **/
        private boolean validateCurrentInput() {


        }
        private boolean validateNextInput() {
            TextInputEditText nextInput = findViewById(R.id.nextInputEditText);//gets the input from user

            String roomNext = nextInput.getText().toString().trim();
            if (roomNext.isEmpty()) {
                nextInput.setError("Field cannot be empty");
                return false;
            }
            if (roomNext.length() < 3) {
                nextInput.setError("Input too short");
                return false;
            }
            if (roomNext.length() > 3) {
                nextInput.setError("Input length exceeded");
                return false;
            } else {
                //call check function to see whether the 3digit input is a room
                if (c.check(roomNext) == false) {
                    nextInput.setError("invalid room number");
                    return false;
                } else
                    nextInput.setError(null);
                nextInput.setErrorEnabled(false);
                return true;
            }
        }
    };


    public void NextInput(View v){
        TextInputEditText num  = findViewById(R.id.editTextNext);//gets the input from user


        String room = num.getText().toString(); // makes it a string because its initially a char

        nextRoom = room;

       // ((TextView)findViewById(R.id.TextNext)).setText("Next room: C1 - "+ NextN);


    }

}