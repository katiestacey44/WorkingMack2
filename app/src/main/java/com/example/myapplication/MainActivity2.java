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
import android.widget.RelativeLayout;
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
    private ImageView imageView;
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
        //Obtain current and next room ids from other activity
        start = getIntent().getIntExtra("current", 120);
        end = getIntent().getIntExtra("next", 140);
        //display info
        ((TextView)findViewById(R.id.CurrText)).setText("Current:"+ "\n" +"C1"+ start);
        ((TextView)findViewById(R.id.NextText)).setText("Next:"+ "\n"+"C1"+ end);


        path = new Path();

    }

    /**
     * Displays the path and room markers on the map when the "Show" button is clicked.
     * @param v The clicked button view.
     */

    public void testPoints(View v) {
        int[] array = {110, 112, 104, 102, 106, 114, 120, 125, 126, 127, 130, 124, 123, 121, 122, 132, 133, 140, 144, 146, 145, 143, 142, 141, 154, 153, 152, 151, 150, 148, 149, 157, 156, 155};
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

        canvas.drawCircle(c.getX(start),c.getY(start),35,paint);
        paint.setColor(red);
        canvas.drawCircle(c.getX(end),c.getY(end),30,paint);

        ImageView map  = findViewById(R.id.pathDisplay);

        map.setImageBitmap(bitmap);

    }

    /**
     * Navigates back to the main activity when the "Go Back" button is clicked.
     * @param v The clicked button view.
     */
    public void GoBackButton(View v){
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }
}