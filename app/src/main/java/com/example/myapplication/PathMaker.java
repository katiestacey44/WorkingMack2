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


        pointArray[14] = new Point(80, 670);
        pointArray[12] = new Point( 92, 715);
        pointArray[10] = new Point( 105, 715);
        pointArray[20] = new Point( 140, 490);
        pointArray[26] = new Point( 112, 545);
        pointArray[25] = new Point( 95, 545);
        pointArray[27] = new Point( 85, 455);
        pointArray[30] = new Point( 75, 435);
        pointArray[32] = new Point( 30, 390);
        pointArray[33] = new Point( 10, 362);
        pointArray[24] = new Point( 25, 470);
        pointArray[23] = new Point( 25, 503);
        pointArray[22] = new Point( 35, 545);
        pointArray[21] = new Point( 14, 545);
        pointArray[40] = new Point( 140, 100);
        pointArray[46] = new Point( 104, 36);
        pointArray[45] = new Point( 25, 108);
        pointArray[44] = new Point( 95, 159);
        pointArray[43] = new Point( 95, 178);
        pointArray[42] = new Point( 95, 210);
        pointArray[41] = new Point( 95, 255);
        pointArray[55] = new Point( 25, 90);
        pointArray[56] = new Point( 35, 50);
        pointArray[57] = new Point( 14, 50);
        pointArray[54] = new Point( 25, 117);
        pointArray[53] = new Point( 25, 147);
        pointArray[52] = new Point( 25, 178);
        pointArray[51] = new Point( 25, 210);
        pointArray[50] = new Point( 25, 255);
        pointArray[1] = new Point( 92, 670);
        pointArray[2] = new Point( 92, 625);
        pointArray[3] = new Point( 105, 625);
        pointArray[4] = new Point( 165, 625);
        pointArray[5] = new Point( 165, 490);
        pointArray[6] = new Point( 165, 100);
        pointArray[11] = new Point( 112, 490);
        pointArray[7] = new Point( 95, 490);
        pointArray[13] = new Point( 75, 455);
        pointArray[8] = new Point( 14, 455);
        pointArray[15] = new Point( 14, 390);
        pointArray[16] = new Point( 14, 470);
        pointArray[17] = new Point( 14, 503);
        pointArray[18] = new Point( 14, 520);
        pointArray[9] = new Point( 104, 100);
        pointArray[19] = new Point( 88, 100);
        pointArray[35] = new Point( 88, 159);
        pointArray[36] = new Point( 88, 178);
        pointArray[37] = new Point( 88, 210);
        pointArray[38] = new Point( 88, 255);
        pointArray[39] = new Point( 14, 100);
        pointArray[28] = new Point( 14, 90);
        pointArray[29] = new Point( 14, 70);
        pointArray[47] = new Point( 14, 117);
        pointArray[48] = new Point( 14, 147);
        pointArray[49] = new Point( 14, 178);
        pointArray[58] = new Point( 14, 210);
        pointArray[34] = new Point( 14, 255);

    }







}
