package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

/**
 * MainActivity2 represents the second activity of the application.
 * It displays a floor map, a path between two rooms, and markers for the current and next rooms.
 */

public class MainActivity2 extends AppCompatActivity {
    private Context context;
    private ImageView imageView, labelView;
    private int start;
    private int end;
    private float scaleValValue;
    private Path path;

    /**
     * Called when the activity is first created.
     * Initializes the layout and retrieves data from the previous activity.
     * @param savedInstanceState The saved state of the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        context = getApplicationContext();
        imageView = findViewById(R.id.imageView);
        labelView = findViewById(R.id.labelView);
        labelView.setVisibility(View.INVISIBLE) ;//hide the labels initially

        //Obtain current and next room ids MainActivity passed to intent
        start = getIntent().getIntExtra("current", 120);
        end = getIntent().getIntExtra("next", 140);
        //display the room numbers in text boxes
        ((TextView)findViewById(R.id.CurrText)).setText(String.format("Current:\nC1%d", start));
        ((TextView)findViewById(R.id.NextText)).setText(String.format("Next:\nC1%d", end));

        //initialize path object
        path = new Path();

    }

    /**
     * this is a troubleshooting function to view and manually adjust the xy-coordinates of all path points
     * displays the room points and path points in different colors
     * @param v the view of the clicked button labeled "test".
     */
    public void testPoints(View v) {
        scaleValValue = imageView.getWidth()/(float)200;
        C1floor c = new C1floor(scaleValValue,start, end);

        //points for rooms in array, non-room in array2
        int[] array = {110, 112, 114, 120, 121, 122, 123, 124, 125, 126, 127, 130, 132, 133, 140, 144, 146, 143, 142, 141, 154, 153, 152, 151, 150,  157, 156, 155};
        int[] array2 = {1,2,3,4,5,6,7,8,9,11,13,15,16,17,18,19,34,35,36,37,38,28,29,45,47,48,49,58,34};
        //display colors
        int testColor = ContextCompat.getColor(context, R.color.green);
        int testColor2 = ContextCompat.getColor(context, R.color.butt);

        //Initialize display
        Bitmap bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL); //FILL style to make circles


        //Displays all points
        paint.setColor(testColor); //rooms displayed as green
        for (int j : array) {
            canvas.drawCircle(c.getX(j), c.getY(j), 10, paint);
        }
        paint.setColor(testColor2); //non-rooms shown as a different color
        for (int j : array2) {
            canvas.drawCircle(c.getX(j + 100), c.getY(j + 100), 10, paint);
        }

        ImageView map  = findViewById(R.id.imageView);
        map.setImageBitmap(bitmap);

    }

    /** Function that obtains the path from a C1floor method and draws the path on a bitmap
     * precondition:variables start & end have been retrieved from intent for this to work
     * postcondition: Sets a bitmap with a path drawn onto imageView
     * @param v the view of the clicked button @1d/showButton
     */
    public void showButton(View v){
        //access colors from android's res>values>colors.xml
        int cyan = ContextCompat.getColor(context, R.color.teal);
        int red = ContextCompat.getColor(context, R.color.red);
        int blue = ContextCompat.getColor(context, R.color.blue);


        //Initialize canvas for drawing path
        Bitmap bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap); // path is drawn on the bitmap
        Paint paint = new Paint(); //canvas uses paint

        paint.setColor(cyan);
        paint.setStrokeWidth(22); //line width
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);//STOKE style for drawing path/line



        //obtain scale value for the map on this device to pass to our path function
        scaleValValue = imageView.getWidth()/(float)200;
        C1floor c = new C1floor(scaleValValue,start, end);


        //Obtain the path from current room to next room
        path = c.getPath();

        //Display path and room markers
        canvas.drawPath(path, paint);


        paint.setStyle(Paint.Style.FILL); //FILL style to make circles
        paint.setColor(blue);
        canvas.drawCircle(c.getX(start),c.getY(start),20,paint); // A blue circle = current room marker
        paint.setColor(red);
        canvas.drawCircle(c.getX(end),c.getY(end),20,paint); // A red circle = next room marker

        //ImageView map  = findViewById(R.id.imageView);

        imageView.setImageBitmap(bitmap); //Displays the path over the imageview background

    }

    /**
     * Toggling the switch will show/hide an overlay of room numbers over the c1map,
     * Initial visibility: invisible
     * @param v The View of the clicked switch.
     */
    public void toggleLabels(View v) {
        if(labelView.getVisibility()==View.INVISIBLE)
        {
            labelView.setVisibility(View.VISIBLE);
        }
        else
        {
            labelView.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * Returns to MainActivity upon clicking the "Return" button
     * @param v The View of the button clicked
     */
    public void goBack(View v){
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }
}