package com.example.myapplication;

import android.graphics.Path;

public class PathMaker {

    private Path P;

    private Point[] pointArray;

    private MainActivity2 m;


    public PathMaker(int[] Array){
        float Scale;
        P = new Path();
        pointArray = new Point[70];
        m = new MainActivity2();
        Scale = m.getScaleVal();



        // Initialize the array with Point objects
        pointArray[10] = new Point(100, 640); // x and y of the rooms
        pointArray[12] = new Point(100, 640);
        pointArray[14] = new Point(100, 610);
        pointArray[4] = new Point(100, 640);
        pointArray[2] = new Point(100, 640);
        pointArray[6] = new Point(100, 610);
        pointArray[26] = new Point(120, 500);
        pointArray[25] = new Point(90, 500);
        pointArray[20] = new Point(120, 470);
        pointArray[27] = new Point(90, 450);
        pointArray[30] = new Point(80, 430);
        pointArray[24] = new Point(30, 450);
        pointArray[23] = new Point(30, 470);
        pointArray[22] = new Point(30, 500);
        pointArray[21] = new Point(30, 500);
        pointArray[32] = new Point(30, 370);
        pointArray[33] = new Point(30, 350);
        pointArray[50] = new Point(30, 250);
        pointArray[51] = new Point(30, 210);
        pointArray[52] = new Point(30, 180);
        pointArray[53] = new Point(30, 150);
        pointArray[54] = new Point(30, 120);
        pointArray[55] = new Point(30, 80);
        pointArray[56] = new Point(30, 50);
        pointArray[57] = new Point(30, 50);
        pointArray[40] = new Point(120, 80);
        pointArray[44] = new Point(120, 150);
        pointArray[43] = new Point(120, 180);
        pointArray[42] = new Point(120, 210);
        pointArray[41] = new Point(120, 250);
        pointArray[45] = new Point(120, 50);
        pointArray[46] = new Point(90, 50);
        pointArray[1] = new Point(165, 470);
        pointArray[60] = new Point(100, 580);
        pointArray[61] = new Point(165, 580);
        pointArray[62] = new Point(165, 470);
        pointArray[63] = new Point(90, 450);
        pointArray[64] = new Point(30, 400);
        pointArray[65] = new Point(165, 300);
        pointArray[66] = new Point(165, 80);
        pointArray[67] = new Point(30, 100);

        float x = Scale*pointArray[Array[0]].getX();
        float y = Scale*pointArray[Array[0]].getY();

        P.moveTo(x, y);

        for (int i = 1; i < Array.length; i++){
            x = Scale*pointArray[Array[i]].getX();
            y = Scale*pointArray[Array[i]].getY();
            P.lineTo(x, y);
        }

    }

    public float getX(int num){
        float Scale = m.getScaleVal();
    return pointArray[num].getX() * Scale;

    }

    public float getY(int num){
        float Scale = m.getScaleVal();
        return pointArray[num].getY() * Scale;
    }

    public Path getPath(){
        return P;

    }







}
