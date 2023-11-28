package com.example.myapplication;

/**
 * Point class represents a point in a 2D coordinate system with x and y coordinates.
 */

public class Point {
    private int x;  // x-coordinate of the point
    private int y;  // x-coordinate of the point

    /**
     * Constructor for the Point class.
     * @param x x-coordinate of the point
     * @param y y-coordinate of the point
     */

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x-coordinate of the point.
     * @return x-coordinate of the point
     */

    public int getX()
    {
        return x;
    }

    /**
     * Get the y-coordinate of the point.
     * @return y-coordinate of the point
     */

    public int getY()
    {
        return y;
    }
}
