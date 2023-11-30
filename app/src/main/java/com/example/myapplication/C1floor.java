package com.example.myapplication;

import android.graphics.Path;

/**
 * C1floor class represents the navigation path on the C1 floor of a building.
 */

public class C1floor {

    private int visitedArr[]; // Array to keep track of visited rooms during DFS traversal

    // PathMaker and Path objects for generating and storing the navigation path
    private PathMaker p;
    private Path path;


    private Graph C1; // Graph representing the floor layout


    public C1floor(){

    }
    /**
     * Constructor for C1floor class.
     *
     * @param scaleValr   Scaling factor for the path
     * @param currRoom    Current room number
     * @param nextRoom    Destination room number
     */

    public C1floor(float scaleValr,int currRoom, int nextRoom) {
        // Adjust room numbers to start from 0
        int currentRoom = currRoom - 100;
        int desiredRoom = nextRoom - 100;

        // Initialize graph information and perform DFS traversal
        addInfo(desiredRoom);

        C1.DFS(currentRoom);
        visitedArr = C1.getVisited();

        // Create PathMaker and obtain the navigation path
        p = new PathMaker(scaleValr,visitedArr);
        path = p.getPath();
    }

    /**
     * Get the generated navigation path.
     * @return Path object representing the navigation path
     */
    public Path getPath()
    {

        return path;
    }

    /**
     * Get the x-coordinate for a given room.
     * @param num Room number
     * @return X-coordinate of the room
     */

    public float getX(int num){
        num -=100;
        return p.getX(num);
    }

    /**
     * Get the y-coordinate for a given room.
     * @param num Room number
     * @return Y-coordinate of the room
     */

    public float getY(int num){
        num -=100;
        return p.getY(num);
    }

    /**
     * Add information about the floor layout to the graph.
     * @param num Desired room number
     */

    private void addInfo(int num){
        // Create a graph representing the C1 floor layout
        C1 = new Graph(70, num);

        C1.addEdge(60, 14); // the edges between all the room in the C1 floor
        C1.addEdge(60, 12);
        C1.addEdge(60, 10);
        C1.addEdge(60, 6);
        C1.addEdge(60, 4);
        C1.addEdge(60, 2);
        C1.addEdge(60, 61);
        C1.addEdge(61, 62);
        C1.addEdge(62, 20);
        C1.addEdge(62, 65);
        C1.addEdge(65, 49);
        C1.addEdge(65, 48);
        C1.addEdge(20, 30);
        C1.addEdge(20, 27);
        C1.addEdge(20, 25);

        C1.addEdge(20, 26);
        C1.addEdge(20, 64);
        C1.addEdge(64, 21);
        C1.addEdge(64, 22);
        C1.addEdge(64, 24);
        C1.addEdge(64, 33);
        C1.addEdge(64, 23);

        C1.addEdge(64, 32);
        C1.addEdge(65, 66);
        C1.addEdge(66, 40);
        C1.addEdge(40, 41);
        C1.addEdge(40, 42);
        C1.addEdge(40, 43);

        C1.addEdge(40, 45);
        C1.addEdge(40, 44);
        C1.addEdge(40, 46);
        C1.addEdge(40, 67);
        C1.addEdge(67, 52);
        C1.addEdge(67, 51);
        C1.addEdge(67, 50);
        C1.addEdge(67, 55);
        C1.addEdge(67, 56);
        C1.addEdge(67, 57);
        C1.addEdge(67, 54);
        C1.addEdge(67, 53);

    }
    public boolean check(int num){
        boolean result = false;
        int[] array = {110,112,104,102,106,114,120,125,126,127,130,124,123,121,122,132,133,140,144,146,145,143,142,141,154,153,152,151,150,148,149,157,156,155};

        for (int i= 0; i < array.length; i++){
            if (num == array[i]){
                result = true;
                break;
            }
        }
        return result;
    }

}


