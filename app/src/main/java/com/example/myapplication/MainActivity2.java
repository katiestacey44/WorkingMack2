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

import com.google.android.material.textfield.TextInputEditText;


public class MainActivity2 extends AppCompatActivity {
    private Context context;
   private  Resources resources;
    private RelativeLayout relativeLayout;
    private Button button;
    private ImageView imageView;
    private int Start;
    private int End;


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
        Start = 0;
        End = 0;


    }

    public void setStart(int S){
        Start = S;

    }

    public void setEnd(int E){
        End = E;
    }
    @SuppressLint("ResourceAsColor")
    public void ShowButton(View v){
        //The map image's original dimensions are 200x796 px
        float scaleValue = imageView.getWidth()/(float)200;
        //get the imageView's scaling multiplier
        Path path = new Path();
       // PathMaker p = new PathMaker(scaleValue, path);
        //Create bitmap the size of imageView to pass to canvas to be drawn on
        Bitmap bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(R.color.cyan);
        paint.setStrokeWidth(22); //line width
        paint.setAntiAlias(true);

        paint.setStyle(Paint.Style.STROKE);//STOKE for drawLine/drawPath
        //canvas.drawLine(trueX, trueY, trueX, trueY2, paint);
        float trueX = (165*scaleValue); //(trueX,trueY) c120 branch point
        float trueY =100*scaleValue;
        float trueY2= 490* scaleValue;    //(trueX,trueY2) = c1140 branch point
        float x=(float)30*scaleValue;  //120 itself
        float y=(float)50*scaleValue;

        path.moveTo(x, y);

        path.lineTo(trueX, trueY2);
        path.lineTo(trueX, trueY);
        path.lineTo(x, trueY);

        //Path is a series of connected lines drawn
        //p.setEnd(End);
       // p.setStart(Start);
       // path = p.getPath();

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