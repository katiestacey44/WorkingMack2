package com.example.myapplication;

import junit.framework.TestCase;

import java.util.LinkedList;
import java.util.Arrays;

public class GraphTest extends TestCase {

    public void testGetVisited() {
        Graph g = new Graph(12, 3);
        int Array[] = {10,4,1,3,0,0,0,0,0,0,0,0};

        g.addEdge(10,4);
        g.addEdge(10,5);
        g.addEdge(10,6);
        g.addEdge(4,1);
        g.addEdge(1,3);
        g.DFS(10);

       assertTrue(Arrays.equals(Array, g.getVisited()));
    }

    public void testAddEdge() {
        Graph C1 = new Graph(6, 4);
        int num =5;
        int num2;

        boolean result = false;
        C1.addEdge(3, 5);
        LinkedList<Integer>[] array = C1.getadj();
        num2 = array[3].get(0);
        if (num == num2){
            result = true;
        }

        assertTrue(result);


    }


    public void testFoundRoom() {
        Graph g = new Graph(10,20);
        assertTrue(g.foundRoom(20));
    }
}