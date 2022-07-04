package graph;

import java.util.*;

/**
 * <p>Leetcode problem</p>
 * 133. Clone Graph
 * https://leetcode.com/problems/clone-graph/
 */
public class CloneAGraph_LC133 {
    public static void main(String[] args) {
        CloneAGraph_LC133 obj = new CloneAGraph_LC133();

        int[][] adjList = new int[][]{{2, 4}, {1, 3}, {4, 2}, {3, 1}};

        Node rootNode = new Node();
        Node cloneNodeBFS = obj.cloneGraph_BFS(rootNode);

        //DFS
        Node cloneNodeDFS = obj.cloneGraph_DFS_Runner(rootNode);

    }

    public static Node cloneGraph_DFS_Runner(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return cloneGraph_DFS(node, map);
    }

    private static Node cloneGraph_DFS(Node node, Map<Node, Node> map) {
        if (node == null)
            return null;


        if (map.containsKey(node))
            return map.get(node);

        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);

        final List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            final Node clonedNeighborNode = cloneGraph_DFS(neighbor, map);
            cloneNode.neighbors.add(clonedNeighborNode);
        }

        return cloneNode;
    }


    //[1]-[2]
    //[1]-[2]-[3]
    public Node cloneGraph_BFS(Node node) {
        if (node == null)
            return null;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        map.put(node, new Node(node.val)); //[1] -- [1']
        queue.add(node); //[1]

        while (!queue.isEmpty()) {
            final Node currNode = queue.poll(); //[3]
            final Node clonedCurrNode = map.get(currNode); //[3']
            final List<Node> neighbors = currNode.neighbors; //[2]
            for (Node neighbor : neighbors) {
                if (!map.containsKey(neighbor)) { // not already created
                    map.put(neighbor, new Node(neighbor.val)); //[3], [3']->[2']
                    queue.add(neighbor); //[3]
                }

                clonedCurrNode.neighbors.add(map.get(neighbor));  //[2']->[3']
            }

        }
        return map.get(node);
    }


    private static class Node {
        public int val;
        public List<Node> neighbors = new ArrayList<>();

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

    }
}
