package com.example.myapplication;

import android.graphics.Path;

public class PathMaker {

    private Path P = new Path();
    private int Start;
    private int End;
    public PathMaker(float scaleValue, Path p){

        float trueX = (165*scaleValue); //(trueX,trueY) c120 branch point
        float trueY =100*scaleValue;
        float trueY2= 490* scaleValue;    //(trueX,trueY2) = c1140 branch point
        float x=(float)120*scaleValue;  //120 itself
        float y=(float)490*scaleValue;
        P = p;
    }

    public void Make(){
        P.moveTo(x, y);
        P.lineTo(trueX, trueY2);
        P.lineTo(trueX, trueY);
        P.lineTo(x, trueY);
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
}
