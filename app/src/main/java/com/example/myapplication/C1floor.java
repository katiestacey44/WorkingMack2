package com.example.myapplication;

import android.graphics.Path;

/**
 * C1floor class represents the navigation path on the graphC1 floor of a building.
 */

public class C1floor {

    private int[] visitedArr; // Array to keep track of visited rooms during DFS traversal
    // PathMaker and Path objects for generating and storing the navigation path
    private Path path;
    private PathMaker p;
    private Graph graphC1; // Graph representing the floor layout


    public C1floor(){}
    /**
     * Constructor for C1floor class.
     * @param scaleValue   Scaling factor for the path
     * @param currRoom    Current room number
     * @param nextRoom    Destination room number
     */

    public C1floor(float scaleValue,int currRoom, int nextRoom) {
        // Adjust room numbers to start from 0
        int currentRoom = currRoom - 100;
        int desiredRoom = nextRoom - 100;

        // Initialize graph information and perform DFS traversal
        addInfo(desiredRoom);

        graphC1.DFS(currentRoom);
        visitedArr = graphC1.getVisited();

        // Create PathMaker and obtain the navigation path
        p = new PathMaker(scaleValue,visitedArr);
        path = p.getPath();
    }

    /**
     * Get the generated navigation path.
     * @return Path object representing the navigation path
     */
    public Path getPath() {return path;}

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
     * creates a graph object called graphC1
     * @param num Desired room number
     */

    private void addInfo(int num){
        // Create a graph representing the graphC1 floor layout
        graphC1 = new Graph(70, num);

        // the edges between all the rooms in the C1 floor
        graphC1.addEdge(14,  1);
        graphC1.addEdge(12,  1);
        graphC1.addEdge(1,  2);
        graphC1.addEdge(2,  3);
        graphC1.addEdge(10,  3);
        graphC1.addEdge(3,  4);
        graphC1.addEdge(4,  5);
        graphC1.addEdge(5,  6);
        graphC1.addEdge(20,  5);
        graphC1.addEdge(20,  11);
        graphC1.addEdge(26,  11);
        graphC1.addEdge(11,  7);
        graphC1.addEdge(25,  7);
        graphC1.addEdge(7,  13);
        graphC1.addEdge(27,  13);
        graphC1.addEdge(30,  13);
        graphC1.addEdge(13,  8);
        graphC1.addEdge(8,  15);
        graphC1.addEdge(32,  15);
        graphC1.addEdge(33,  15);
        graphC1.addEdge(8,  16);
        graphC1.addEdge(16,  17);
        graphC1.addEdge(24,  16);
        graphC1.addEdge(17,  18);
        graphC1.addEdge(23,  17);
        graphC1.addEdge(21,  18);
        graphC1.addEdge(22,  18);
        graphC1.addEdge(40,  6);
        graphC1.addEdge(40,  9);
        graphC1.addEdge(46,  9);
        graphC1.addEdge(9,  19);
        graphC1.addEdge(19,  35);
        graphC1.addEdge(44,  35);
        graphC1.addEdge(35,  36);
        graphC1.addEdge(43,  36);
        graphC1.addEdge(36,  37);
        graphC1.addEdge(42,  37);
        graphC1.addEdge(37,  38);
        graphC1.addEdge(41,  38);
        graphC1.addEdge(19,  39);
        graphC1.addEdge(39,  28);
        graphC1.addEdge(55,  28);
        graphC1.addEdge(28,  29);
        graphC1.addEdge(56,  29);
        graphC1.addEdge(57,  29);
        graphC1.addEdge(39,  47);
        graphC1.addEdge(54,  47);
        graphC1.addEdge(47,  48);
        graphC1.addEdge(53,  48);
        graphC1.addEdge(48,  49);
        graphC1.addEdge(52,  49);
        graphC1.addEdge(49,  58);
        graphC1.addEdge(51,  58);
        graphC1.addEdge(50,  34);
        graphC1.addEdge(58,  34);
    }
    public boolean check(int num){
        boolean result = false;
        int[] array = {110,112,114,120,125,126,127,130,124,123,121,122,132,133,140,144,146,145,143,142,141,154,153,152,151,150,148,149,157,156,155};

        for (int j : array) {
            if (num == j) {
                result = true;
                break;
            }
        }
        return result;
    }

}


