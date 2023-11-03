package com.example.myapplication;

public class C1floor {

    private int visited[];
    private String result;


    public void setVisited(int[] visited) {
        this.visited = visited;
    }

    public String getString() {
        return result;
    }

    /**
     * @param CurrRoom
     * @param NextRoom
     * has all the edges needed to create a graph with the adj. list for C1 floor
     */



    public C1floor(String CurrRoom, String NextRoom) {


        int CurrentRoom = Integer.parseInt(CurrRoom);
        int desiredRoom = Integer.parseInt(NextRoom);


        Graph C1 = new Graph(31, desiredRoom);


        C1.addEdge(102, 104); // the edges between all the room in the C1 floor
        C1.addEdge(104, 110);
        C1.addEdge(112, 114);
        C1.addEdge(114, 120);
        C1.addEdge(114, 130);
        C1.addEdge(114, 140);
        C1.addEdge(120, 126);
        C1.addEdge(120, 127);
        C1.addEdge(126, 125);
        C1.addEdge(125, 132);
        C1.addEdge(132, 133);
        C1.addEdge(125, 124);
        C1.addEdge(124, 123);
        C1.addEdge(123, 122);
        C1.addEdge(122, 121);

        C1.addEdge(140, 146);
        C1.addEdge(146, 145);
        C1.addEdge(140, 144);
        C1.addEdge(144, 143);
        C1.addEdge(143, 142);
        C1.addEdge(142, 141);
        C1.addEdge(140, 155);

        C1.addEdge(155, 154);
        C1.addEdge(154, 153);
        C1.addEdge(153, 152);
        C1.addEdge(152, 151);
        C1.addEdge(155, 156);
        C1.addEdge(156, 157);





        C1.DFS(CurrentRoom);
        result = "";

        visited = C1.getVisited();

        for (int i = 0; i < visited.length; i++){
            if (visited[i] != 0){
                result = " -> " + visited[i];
            }
        }

        // figure out how to display path on map
    }
}
