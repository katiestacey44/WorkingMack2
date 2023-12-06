package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
    private Resources resources;
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
        resources = getResources();
        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.c1map);
        labelView = findViewById(R.id.labelView);
        labelView.setVisibility(View.INVISIBLE) ;

        //Obtain current and next room ids from other activity
        start = getIntent().getIntExtra("current", 120);
        end = getIntent().getIntExtra("next", 140);
        //display info
        ((TextView)findViewById(R.id.CurrText)).setText(String.format("Current:\nC1%d", start));
        ((TextView)findViewById(R.id.NextText)).setText(String.format("Next:\nC1%d", end));


        path = new Path();

    }

    /**
     * Displays the path and room markers on the map when the "Show" button is clicked.
     * @param v The clicked button view.
     */
    //Function to view all points to manually adjust their xy coordinates
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
        for (int i=0;i<array.length;i++)
        {
            canvas.drawCircle(c.getX(array[i]), c.getY(array[i]), 10, paint);
        };
        paint.setColor(testColor2); //non-rooms shown as a different color
        for (int i=0;i<array2.length;i++)
        {
            canvas.drawCircle(c.getX(array2[i]+100), c.getY(array2[i]+100), 10, paint);
        };

        ImageView map  = findViewById(R.id.imageView);
        map.setImageBitmap(bitmap);

    }
    public void ShowButton(View v){
        //access colors from res>values>colors.xml
        int cyan = ContextCompat.getColor(context, R.color.cyan);
        int red = ContextCompat.getColor(context, R.color.red);
        int blue = ContextCompat.getColor(context, R.color.blue);

        //obtain scale value for the map on this device to pass to our path function
        scaleValValue = imageView.getWidth()/(float)200;
        C1floor c = new C1floor(scaleValValue,start, end);


        //Initialize display
        Bitmap bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();

        paint.setColor(cyan);
        paint.setStrokeWidth(22); //line width
        paint.setAntiAlias(true);

        paint.setStyle(Paint.Style.STROKE);//STOKE for drawLine/drawPath

        //Get path
        path = c.getPath();

        //Display path and room markers
        canvas.drawPath(path, paint);

        paint.setStyle(Paint.Style.FILL); //FILL style to make circles
        paint.setColor(blue);

        canvas.drawCircle(c.getX(start),c.getY(start),20,paint);
        paint.setColor(red);
        canvas.drawCircle(c.getX(end),c.getY(end),20,paint);

        ImageView map  = findViewById(R.id.imageView);

        map.setImageBitmap(bitmap);

    }
    public void toggleLabels(View v) {
        if(labelView.getVisibility()==View.INVISIBLE)
            labelView.setVisibility(View.VISIBLE);
        else
            labelView.setVisibility(View.INVISIBLE);
    }

    public void GoBackButton(View v){
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }
}