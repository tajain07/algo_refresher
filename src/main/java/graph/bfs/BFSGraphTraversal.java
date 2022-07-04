package graph.bfs;

import graph.UndirectedGraphImplementation;

import java.util.*;

// BFS Traversal
// Time complexity - O(V+ E)
// Space complexity - O(V)
public class BFSGraphTraversal {
    public static void main(String[] args) {
        {
            int N = 7;

            //final UndirectedGraphImplementation graph = UndirectedGraphImplementation.createGraph();

            int numberOfVertex = 7;

            List<int[]> vertexList = new LinkedList<>();
            vertexList.add(new int[]{0, 1});
            vertexList.add(new int[]{1, 2});
            vertexList.add(new int[]{2, 3});
            vertexList.add(new int[]{3, 4});
            vertexList.add(new int[]{4, 0});
            vertexList.add(new int[]{5, 6});

            final UndirectedGraphImplementation graph = UndirectedGraphImplementation.createGraph(numberOfVertex, vertexList);


            /*ArrayList<Integer>[] adjacencyList = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                adjacencyList[i] = new ArrayList<>();
            }

            adjacencyList[0].add(1);
            adjacencyList[1].add(0);

            adjacencyList[0].add(2);
            adjacencyList[2].add(0);

            adjacencyList[1].add(3);
            adjacencyList[3].add(1);

            adjacencyList[1].add(4);
            adjacencyList[4].add(1);

            adjacencyList[3].add(5);
            adjacencyList[5].add(3);

            adjacencyList[2].add(6);
            adjacencyList[6].add(2);

            adjacencyList[4].add(5);
            adjacencyList[5].add(4);



            //visited[0] = true;
            System.out.print("BFS Recursive - ");*/
            bfsRunner(graph.getAdj());

        }
    }

    private static void bfsRunner(List<Integer>[] adjacencyList) {
        System.out.println(Arrays.toString(adjacencyList));

        boolean[] visited = new boolean[adjacencyList.length];
        Queue<Integer> queue = new LinkedList<>();


        for (int i = 0; i < adjacencyList.length; i++) {
            queue.add(i);
            while (!queue.isEmpty()) {
                final Integer element = queue.poll();
                if (!visited[element]) {
                    visited[element] = true;
                    System.out.print(element + " ");
                    queue.addAll(adjacencyList[element]);
                }
            }

        }

    }


}
