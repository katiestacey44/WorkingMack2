package com.example.myapplication;


import java.util.LinkedList;

public class C1floor {

    private int visited[];

    public int[] getVisited() {
        return visited;
    }

    /**
     * @param CurrRoom
     * @param NextRoom
     * has all the edges needed to create a graph with the adj. list for C1 floor
     */



    public C1floor(String CurrRoom, String NextRoom) {


        int CurrentRoom = Integer.parseInt(CurrRoom);
        int desiredRoom = Integer.parseInt(NextRoom);
        CurrentRoom -= 100;
        desiredRoom -= 100;


        Graph C1 = new Graph(58, desiredRoom);


        C1.addEdge(10, 12); // the edges between all the room in the C1 floor
        C1.addEdge(12, 6);
        C1.addEdge(6, 4);
        C1.addEdge(6, 2);
        C1.addEdge(6, 14);
        C1.addEdge(14, 3);
        C1.addEdge(3, 20);
        C1.addEdge(20, 25);
        C1.addEdge(20, 26);
        C1.addEdge(20, 27);
        C1.addEdge(20, 30);
        C1.addEdge(20, 32);
        C1.addEdge(20, 24);
        C1.addEdge(24, 23);
        C1.addEdge(23, 21);

        C1.addEdge(23, 22);
        C1.addEdge(32, 33);
        C1.addEdge(3, 1);
        C1.addEdge(1, 49);
        C1.addEdge(49, 48);
        C1.addEdge(1, 40);
        C1.addEdge(40, 44);

        C1.addEdge(44, 43);
        C1.addEdge(43, 42);
        C1.addEdge(42, 41);
        C1.addEdge(40, 45);
        C1.addEdge(40, 46);
        C1.addEdge(40, 55);

        C1.addEdge(40, 54);
        C1.addEdge(54, 53);
        C1.addEdge(53, 52);
        C1.addEdge(52, 51);
        C1.addEdge(51, 50);
        C1.addEdge(55, 56);
        C1.addEdge(55, 57);





        C1.DFS(CurrentRoom);
        visited = C1.getVisited();
        for (int i = 0; i < visited.length; i++){
            visited[i] += 100;
        }



        // figure out how to display path on map
    }
}


