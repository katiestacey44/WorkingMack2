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

        // the edges between all the room in the C1 floor
        C1.addEdge(14,  1);
        C1.addEdge(12,  1);
        C1.addEdge(1,  2);
        C1.addEdge(2,  3);
        C1.addEdge(10,  3);
        C1.addEdge(3,  4);
        C1.addEdge(4,  5);
        C1.addEdge(5,  6);
        C1.addEdge(20,  5);
        C1.addEdge(20,  11);
        C1.addEdge(26,  11);
        C1.addEdge(11,  7);
        C1.addEdge(25,  7);
        C1.addEdge(7,  13);
        C1.addEdge(27,  13);
        C1.addEdge(30,  13);
        C1.addEdge(13,  8);
        C1.addEdge(8,  15);
        C1.addEdge(32,  15);
        C1.addEdge(33,  15);
        C1.addEdge(8,  16);
        C1.addEdge(16,  17);
        C1.addEdge(24,  16);
        C1.addEdge(17,  18);
        C1.addEdge(23,  17);
        C1.addEdge(21,  18);
        C1.addEdge(22,  18);
        C1.addEdge(40,  6);
        C1.addEdge(40,  9);
        C1.addEdge(46,  9);
        C1.addEdge(9,  19);
        C1.addEdge(19,  35);
        C1.addEdge(44,  35);
        C1.addEdge(35,  36);
        C1.addEdge(43,  36);
        C1.addEdge(36,  37);
        C1.addEdge(42,  37);
        C1.addEdge(37,  38);
        C1.addEdge(41,  38);
        C1.addEdge(19,  39);
        C1.addEdge(39,  28);
        C1.addEdge(55,  28);
        C1.addEdge(28,  29);
        C1.addEdge(56,  29);
        C1.addEdge(57,  29);
        C1.addEdge(39,  47);
        C1.addEdge(54,  47);
        C1.addEdge(47,  48);
        C1.addEdge(53,  48);
        C1.addEdge(48,  49);
        C1.addEdge(52,  49);
        C1.addEdge(49,  58);
        C1.addEdge(51,  58);
        C1.addEdge(50,  34);
        C1.addEdge(58,  34);
    }
    public boolean check(int num){
        boolean result = false;
        int[] array = {110,112,114,120,125,126,127,130,124,123,121,122,132,133,140,144,146,145,143,142,141,154,153,152,151,150,148,149,157,156,155};

        for(int i= 0; i < array.length; i++){
            if (num == array[i]){
                result = true;
                break;
            }
        }
        return result;
    }

}


