package graph;

import java.util.*;

/**
 * <p>Leetcode problem</p>
 * 133. Clone Graph
 * https://leetcode.com/problems/clone-graph/
 */
public class CloneAGraph {

    Map<Integer, Node> visited = new HashMap<>();

    public static void main(String[] args) {
        CloneAGraph obj = new CloneAGraph();

        int[][] adjList = new int[][]{{2, 4}, {1, 3}, {4, 2}, {3, 1}};

        Node rootNode = null;
        Node cloneNode = obj.cloneGraph(rootNode);
    }


    public Node cloneGraph(Node node) {
        return clone(node);
    }

    public Node clone(Node node) {
        if (node == null)
            return null;
        if (visited.containsKey(node.val))
            return visited.get(node.val);

        Node newNode = new Node(node.val, new ArrayList<Node>());
        visited.put(newNode.val, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(clone(neighbor));
        }
        return newNode;
    }

    private class Node {
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

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", neighbors=" + neighbors +
                    '}';
        }
    }
}
