package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity2 extends AppCompatActivity {
    private Context context;
   private  Resources resources;
    private RelativeLayout relativeLayout;
    private Button button;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        context = getApplicationContext();
        resources = getResources();
        relativeLayout = findViewById(R.id.relativeLayout);
        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.c1map);
        //access colors from res>values>colors.xml


    }
    @SuppressLint("ResourceAsColor")
    public void ShowButton(View v){
        //The map image's original dimensions are 200x796 px
        float scaleValue = imageView.getWidth()/(float)200;

        //get the imageView's scaling multiplier
        Path path = new Path();
        PathMaker p = new PathMaker(scaleValue, path);

       /* // proof of concept for how path display will look once the node/edge structure
        // where this will use the x, y Coordinates of the node scaled to match the imageView

        //TESTING PATH DRAW FUNCTION
        float trueX = (165*scaleValue); //(trueX,trueY) c120 branch point
        float trueY =100*scaleValue;
        float trueY2= 490* scaleValue;    //(trueX,trueY2) = c1140 branch point
        float x=(float)120*scaleValue;  //120 itself
        float y=(float)490*scaleValue;*/

        //Create bitmap the size of imageView to pass to canvas to be drawn on
        Bitmap bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(R.color.cyan);
        paint.setStrokeWidth(22); //line width
        paint.setAntiAlias(true);

        paint.setStyle(Paint.Style.STROKE);//STOKE for drawLine/drawPath
        //canvas.drawLine(trueX, trueY, trueX, trueY2, paint);

        //Path is a series of connected lines drawn
        p.setEnd(0);
        p.setStart(0);
        path = p.getPath();

       /* path.moveTo(x, y);
        path.lineTo(trueX, trueY2);
        path.lineTo(trueX, trueY);
        path.lineTo(x, trueY);*/
        canvas.drawPath(path, paint);

        paint.setStyle(Paint.Style.FILL); //FILL style to make circles

        //canvas.drawCircle(trueX,trueY,12,paint);
        //canvas.drawCircle(trueX,trueY2,12,paint);

        paint.setColor(R.color.blue);
        canvas.drawCircle(x,y,35,paint);
        paint.setColor(R.color.red);
        canvas.drawCircle(x,trueY,30,paint);

        ImageView map  = findViewById(R.id.MapPath);

        map.setImageBitmap(bitmap);

    }

    public void OnBackButton(View v){
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }
}