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

import java.text.MessageFormat;

/**
 * MainActivity2 represents the second activity of the application.
 * It displays a floor map, a mPath between two rooms, and markers for the current and next rooms.
 * additionally it display the room numbers of current and next,
 * Button functionality: show the mPath, a test and allows user to toggle room number labels to be visible
 */

public class MainActivity2 extends AppCompatActivity {
    private Context context;
    private ImageView imageView, labelView;
    private int mStart;
    private int mEnd;
    private Path mPath;
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
        imageView = findViewById(R.id.imageView_c1Map);
        labelView = findViewById(R.id.imageView_RoomLabels);
        labelView.setVisibility(View.INVISIBLE) ;//hide the labels initially

        //Obtain current and next room ids MainActivity passed to intent
        mStart = getIntent().getIntExtra("current", 120);
        mEnd = getIntent().getIntExtra("next", 140);

        //display the room numbers in textViews
        ((TextView)findViewById(R.id.CurrText)).setText((MessageFormat.format("{0}{1}", getString(R.string.current_c1_displaytxt), mStart)));
        ((TextView)findViewById(R.id.NextText)).setText((MessageFormat.format("{0}{1}", getString(R.string.next_c1_displaytxt), mEnd)));

        //initialize mPath object
        mPath = new Path();

    }



    /** Function that obtains the mPath from a C1floor method and draws the mPath on a bitmap
     * precondition: variables mStart & mEnd have been retrieved from intent for this to work
     * post-condition: Sets a bitmap with a mPath drawn onto imageView
     * @param v the view of the clicked button @id/showButton
     */
    public void showButton(View v){
        //access colors from resources
        int cyan = ContextCompat.getColor(context, R.color.teal);
        int red = ContextCompat.getColor(context, R.color.red);
        int blue = ContextCompat.getColor(context, R.color.blue);


        //Initialize canvas and paint for drawing Path
        Bitmap bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap); // mPath is drawn on the bitmap
        Paint paint = new Paint(); //canvas uses paint

        paint.setColor(cyan);
        paint.setStrokeWidth(22); //line width
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);//STROKE style for drawing mPath/line
        //obtain scale value for the map on this device to pass to our mPath function
        float scaleW = imageView.getWidth()/(float)200;
        float scaleH=imageView.getHeight()/(float)796;
         C1floor c = new C1floor(scaleW,scaleH,mStart, mEnd);


        //Obtain the mPath from current room to next room
        mPath = c.getPath();

        //Display mPath and room markers
        canvas.drawPath(mPath, paint);
        paint.setStyle(Paint.Style.FILL); //FILL style to make circles
        paint.setColor(blue);
        canvas.drawCircle(c.getX(mStart),c.getY(mStart),20,paint); // A blue circle = current room marker
        paint.setColor(red);
        canvas.drawCircle(c.getX(mEnd),c.getY(mEnd),20,paint); // A red circle = next room marker

        //ImageView map  = findViewById(R.id.imageView);

        imageView.setImageBitmap(bitmap); //Displays the mPath over the imageview background

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
        else {labelView.setVisibility(View.INVISIBLE);}
    }

    /**
     * this function is to display the possible points on the imageview
     * displays the room points and mPath points in different colors
     * @param v the view of the clicked button labeled "Test".
     */

    public void testPoints(View v) {
        float scaleW = imageView.getWidth()/(float)200;
        float scaleH=imageView.getHeight()/(float)796;
        C1floor c = new C1floor(scaleW,scaleH,mStart, mEnd);

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
        ImageView map  = findViewById(R.id.imageView_c1Map);
        map.setImageBitmap(bitmap);
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