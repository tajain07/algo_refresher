package graph;

import java.util.*;

public class TopologicalSortKahnAlgorithm {
    public static void main(String[] args) {
        int number_of_vertex = 14;

        List<int[]> adjList = new ArrayList<>();
        adjList.add(new int[]{0, 2});
        adjList.add(new int[]{0, 3});
        adjList.add(new int[]{0, 6});

        adjList.add(new int[]{1, 4});

        adjList.add(new int[]{2, 6});

        adjList.add(new int[]{3, 1});
        adjList.add(new int[]{3, 4});

        adjList.add(new int[]{4, 5});
        adjList.add(new int[]{4, 8});

        adjList.add(new int[]{6, 7});
        adjList.add(new int[]{6, 11});

        adjList.add(new int[]{7, 4});
        adjList.add(new int[]{7, 12});

        adjList.add(new int[]{9, 2});
        adjList.add(new int[]{9, 10});

        adjList.add(new int[]{10, 6});

        adjList.add(new int[]{11, 12});

        adjList.add(new int[]{12, 8});

        final DirectedGraphImplementation graph = DirectedGraphImplementation.createGraph(number_of_vertex, adjList);
        graph.printAdjacencyList();

        final List<Integer> sortedValues = topologicalSort(number_of_vertex, graph);
        System.out.println(sortedValues);
    }

    private static List<Integer> topologicalSort(int number_of_vertex, DirectedGraphImplementation graph) {
        final List<Integer>[] adj = graph.getAdj();
        List<Integer>[] inwardAdj = InwardAdjacencyList(number_of_vertex, adj);

        List<Integer> sortOrder = new ArrayList<>();
        Queue<Integer> stack = new LinkedList<>();

        for (int i = 0; i < inwardAdj.length; i++) {
            if (inwardAdj[i].size() == 0)
                stack.add(i);
        }

        while (!stack.isEmpty()) {
            final Integer poppedElement = stack.poll();
            sortOrder.add(poppedElement);
            final List<Integer> adjElements = adj[poppedElement];
            for (Integer adjElement : adjElements) {
                final List<Integer> inwardElements = inwardAdj[adjElement];
                inwardElements.removeIf(x -> x.equals(poppedElement));
                if (inwardElements.size() == 0)
                    stack.add(adjElement);
            }


        }
        return sortOrder;
    }

    private static List<Integer>[] InwardAdjacencyList(int number_of_vertex, List<Integer>[] adj) {

        List<Integer>[] inwardAdjacencyList = new ArrayList[number_of_vertex];

        for (int v = 0; v < number_of_vertex; v++) {
            inwardAdjacencyList[v] = new ArrayList<>();
        }

        for (int i = 0; i < adj.length; i++) {
            int parent_element = i;
            final List<Integer> outwardList = adj[i];

            for (int j = 0; j < outwardList.size(); j++) {
                final Integer out_element = outwardList.get(j);
                inwardAdjacencyList[out_element].add(parent_element);
            }
        }

        for (List<Integer> node : inwardAdjacencyList) {
            System.out.println(node);
        }
        return inwardAdjacencyList;

    }
}
