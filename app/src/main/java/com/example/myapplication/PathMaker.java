package com.example.myapplication;

import android.graphics.Path;

public class PathMaker {

    private Path P = new Path();
    private int Start;
    private int End;

    private int StartX;
    private int StartY;



    public PathMaker(float scaleValue, Path p){

        float trueX = (165*scaleValue); //(trueX,trueY) c120 branch point
        float trueY =100*scaleValue;
        float trueY2= 490* scaleValue;    //(trueX,trueY2) = c1140 branch point
        float x=(float)120*scaleValue;  //120 itself
        float y=(float)490*scaleValue;
        P = p;
    }

    public void setStartX(int X) {
        StartX = X;
    }

    public void setStartY(int Y){
            StartY = Y;
        }

    public void Make(){
        P.moveTo(StartX, StartY);

       // P.lineTo(trueX, trueY2);
       // P.lineTo(trueX, trueY);
       // P.lineTo(x, trueY);
    }
    public void setStart(int S){
        Start = S;

    }
    public void setEnd(int E){
        End = E;

    }
    public Path getPath(){
        return P;
    }
    private void Cfloor(){
        switch (Start){
            case 120:
                StartX = 120;
                StartY = 100;
                break;
            case 125:
                StartX = 90;
                StartY = 100;
                break;
            case 126:
                StartX = 120;
                StartY = 100;
                break;
            case 140:
                StartX = 120;
                StartY = 490;
                break;
            default:
                System.out.println("ERROR INVALID START CLASS");
        }
    }
}
