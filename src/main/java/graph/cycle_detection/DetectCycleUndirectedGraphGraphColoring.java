package graph.cycle_detection;


import graph.UndirectedGraphImplementation;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=L0DcePeWHnM&ab_channel=TECHDOSE
 */
//Complexity - O(E+V)
//White = 0 => not visited
//Gray  = 1 => visited
//Black = 0 => visited + processed
public class DetectCycleUndirectedGraphGraphColoring {
    public static void main(String[] args) {
        int number_of_vertex = 3;

        List<int[]> adjList = new ArrayList<int[]>();
        adjList.add(new int[]{0, 1});
        //adjList.add(new int[]{0, 2});

        //adjList.add(new int[]{1, 0});
        adjList.add(new int[]{1, 2});

        //adjList.add(new int[]{2, 1});
        //adjList.add(new int[]{2, 0});

        //adjList.add(new int[]{3, 0});
        //adjList.add(new int[]{3, 4});

        adjList.add(new int[]{2, 0});


        final UndirectedGraphImplementation graph = UndirectedGraphImplementation.createGraph(number_of_vertex, adjList);

        boolean result = isCycle_Undirected_Coloring(graph.getAdj(), number_of_vertex);
        System.out.printf("Cycle exist %b\n", result);
    }

    //TODO
    private static boolean isCycle_Undirected_Coloring(List<Integer>[] adj, int number_of_vertex) {


        return false;
    }



}
