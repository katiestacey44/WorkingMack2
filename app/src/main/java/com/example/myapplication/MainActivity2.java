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
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;


public class MainActivity2 extends AppCompatActivity {
    private Context context;
   private  Resources resources;
    private RelativeLayout relativeLayout;
    private ImageView imageView;
    private int Start;
    private int End;
    private float scaleValue;
    private Path path;




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
        Start = 110;
        End = 120;
        scaleValue = imageView.getWidth()/(float)200;
        path = new Path();

    }

    public void setStart(int S){
        Start = S;

    }

    public void setEnd(int E){
        End = E;
    }

    public float getScaleVal(){
        return scaleValue;
    }
    @SuppressLint("ResourceAsColor")
    public void ShowButton(View v){

        ((TextView)findViewById(R.id.CurrText)).setText("Current: C1 - "+ Start);
        ((TextView)findViewById(R.id.NextText)).setText("Next: C1 - "+ End);

        C1floor c = new C1floor(Start, End);

        Bitmap bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(R.color.cyan);
        paint.setStrokeWidth(22); //line width
        paint.setAntiAlias(true);

        paint.setStyle(Paint.Style.STROKE);//STOKE for drawLine/drawPath

        path = c.getPath();

        canvas.drawPath(path, paint);

        paint.setStyle(Paint.Style.FILL); //FILL style to make circles

        paint.setColor(R.color.blue);
        canvas.drawCircle(c.getX(Start),c.getY(Start),35,paint);
        paint.setColor(R.color.red);
        canvas.drawCircle(c.getX(End),c.getY(End),30,paint);

        ImageView map  = findViewById(R.id.MapPath);

        map.setImageBitmap(bitmap);

    }

    public void GoBackButton(View v){
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }
}