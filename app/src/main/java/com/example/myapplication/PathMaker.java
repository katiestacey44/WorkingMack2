package com.example.myapplication;

import android.graphics.Path;

/**
 * PathMaker class is responsible for generating a Path object based on a given array of room indices.
 * It also provides methods to check the existence of a room, retrieve scaled coordinates, and obtain the generated path.
 */

public class PathMaker {

    private Path P;  // Path object to store the generated path

    private Point[] pointArray; // Array of Point objects representing room coordinates

    private float scaleVal;  // Scaling factor for the path



    /**
     * Constructor for the PathMaker class.
     *
     * @param scaler Scaling factor for the path
     * @param Array  Array of room indices
     */

    public PathMaker(float scaler, int[] Array){
        scaleVal  = scaler;
        P = new Path();
        pointArray = new Point[70];

        // Initialize the array with Point objects representing room coordinates
        addPoints();

        // Move to the starting point of the path
        float x = scaleVal*pointArray[Array[0]].getX();
        float y = scaleVal*pointArray[Array[0]].getY();

        P.moveTo(x, y);

        // Generate the path by connecting the rooms
        for (int i = 1; i < Array.length; i++){
            if (Array[i] != 0) {
                x = scaleVal * pointArray[Array[i]].getX();
                y = scaleVal * pointArray[Array[i]].getY();
                P.lineTo(x, y);
            }
        }


    }

    /**
     * Get the scaled x-coordinate for a given room index.
     * @param num Room index
     * @return Scaled x-coordinate of the room
     */
    public float getX(int num){

    return pointArray[num].getX() * scaleVal;

    }

    /**
     * Get the scaled y-coordinate for a given room index.
     * @param num Room index
     * @return Scaled y-coordinate of the room
     */

    public float getY(int num){

        return pointArray[num].getY() * scaleVal;
    }

    /**
     * Get the generated path.
     * @return Path object representing the generated path
     */

    public Path getPath(){
        return P;

    }

    /**
     * Initialize the array of Point objects with room coordinates.
     */
    private void addPoints(){


        pointArray[14] = new Point(80, 672);
        pointArray[12] = new Point( 92, 730);
        pointArray[10] = new Point( 106, 730);
        pointArray[20] = new Point( 132, 490);
        pointArray[21] = new Point( 14, 545);
        pointArray[22] = new Point( 40, 545);
        pointArray[23] = new Point( 25, 503);
        pointArray[24] = new Point( 25, 470);
        pointArray[25] = new Point( 96, 548);
        pointArray[26] = new Point( 112, 548);
        pointArray[27] = new Point( 90, 456);
        pointArray[30] = new Point( 77, 430);
        pointArray[32] = new Point( 34, 392);
        pointArray[33] = new Point( 10, 354);

        pointArray[40] = new Point( 132, 101);
        pointArray[46] = new Point( 102, 36);
        pointArray[44] = new Point( 99, 159);
        pointArray[43] = new Point( 99, 188);
        pointArray[42] = new Point( 99, 222);
        pointArray[41] = new Point( 99, 257);


        pointArray[55] = new Point( 27, 85);
        pointArray[56] = new Point( 39, 52);
        pointArray[57] = new Point( 14, 50);

        pointArray[54] = new Point( 27, 117);
        pointArray[53] = new Point( 27, 152);
        pointArray[52] = new Point( 27, 188);
        pointArray[51] = new Point( 27, 221);
        pointArray[50] = new Point( 27, 255);


        pointArray[1] = new Point( 92, 672);
        pointArray[2] = new Point( 92, 625);
        pointArray[3] = new Point( 105, 625);
        pointArray[4] = new Point( 165, 625);
        pointArray[5] = new Point( 165, 490);
        pointArray[6] = new Point( 165, 101); //to 140
        pointArray[7] = new Point( 95, 490);
        pointArray[8] = new Point( 14, 455);
        pointArray[9] = new Point( 104, 101);
        pointArray[11] = new Point( 112, 490);
        pointArray[13] = new Point( 77, 455);
        pointArray[15] = new Point( 14, 390);
        pointArray[16] = new Point( 14, 470);
        pointArray[17] = new Point( 14, 503);
        pointArray[18] = new Point( 14, 520);

        pointArray[19] = new Point( 88, 101); //<v>
        pointArray[35] = new Point( 88, 159); //144
        pointArray[36] = new Point( 88, 186); //143
        pointArray[37] = new Point( 88, 222); //142
        pointArray[38] = new Point( 88, 257); //141
        pointArray[39] = new Point( 14, 102);//what is this Unused???
        pointArray[28] = new Point( 14, 85);
        pointArray[29] = new Point( 14, 77);
        pointArray[45] = new Point( 14, 102); //|- in 50
        pointArray[47] = new Point( 14, 117);
        pointArray[48] = new Point( 14, 152);
        pointArray[49] = new Point( 14, 188);
        pointArray[58] = new Point( 14, 221);
        pointArray[34] = new Point( 14, 255); //153?

    }







}
