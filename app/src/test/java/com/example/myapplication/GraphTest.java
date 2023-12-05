package com.example.myapplication;

import junit.framework.TestCase;


public class GraphTest extends TestCase {

    public void testGetVisited() {
    }

    public void testAddVisited() {
    }

    public void testAddEdge() {
    }

    public void testDFS() {
    }

    public void testFoundRoom() {
        Graph g = new Graph(10,20);
        assertTrue(g.foundRoom(20));
    }
}