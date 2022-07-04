package graph;

import java.util.ArrayList;
import java.util.List;

public class TestGraph {
    public static void main(String[] args) {
        List<int[]> edgeList = new ArrayList<>();
        edgeList.add(new int[]{0,1});
        edgeList.add(new int[]{0,4});

        edgeList.add(new int[]{1,2});
        edgeList.add(new int[]{1,3});
        edgeList.add(new int[]{1,4});

        edgeList.add(new int[]{2,3});
        edgeList.add(new int[]{3,4});



        UndirectedGraphImplementation graph = UndirectedGraphImplementation.createGraph(5, edgeList);

      graph.printAdjacencyList();
    }
}
