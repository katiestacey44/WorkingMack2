package com.example.myapplication;

import android.graphics.Path;

public class Test {

    public static void main(String[] args) {
        // Example test for C1floor
        testC1floor();
    }

    private static void testC1floor() {
        System.out.println("Testing C1floor class...");

        // Example parameters for C1floor constructor
        float scaleValue = 2.0f;
        int currentRoom = 110;
        int nextRoom = 140;

        // Create C1floor object
        C1floor c1floor = new C1floor(scaleValue, currentRoom, nextRoom);

        // Get the generated Path
        Path path = c1floor.getPath();
        System.out.println("Generated Path: " + path.toString());

        // Example test for getX() and getY()
        int roomToCheck = 120;
        System.out.println("Scaled X-coordinate for Room " + roomToCheck + ": " + c1floor.getX(roomToCheck));
        System.out.println("Scaled Y-coordinate for Room " + roomToCheck + ": " + c1floor.getY(roomToCheck));

        System.out.println("C1floor class test completed.");
    }
}

