package graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {

        assertEquals(canFinishDFS(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}), true);
        assertEquals(canFinishDFS(1, new int[][]{{1, 0}, {2, 0}}), true);
        assertEquals(canFinishDFS(2, new int[][]{{1, 0}}), true);
        assertEquals(canFinishDFS(2, new int[][]{}), true);
        assertEquals(canFinishDFS(2, new int[][]{{1, 0}, {0, 1}}), false);
        assertEquals(canFinishDFS(5, new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}}), false);
        assertEquals(canFinishDFS(5, new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}}), true);
        assertEquals(canFinishDFS(8, new int[][]{{1, 0}, {2, 6}, {1, 7}, {6, 4}, {7, 0}, {0, 5}}), true);


        assertEquals(canFinishCycleDetectionGraphColoring(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}), true);
        assertEquals(canFinishCycleDetectionGraphColoring(1, new int[][]{{1, 0}, {2, 0}}), true);
        assertEquals(canFinishCycleDetectionGraphColoring(2, new int[][]{{1, 0}}), true);
        assertEquals(canFinishCycleDetectionGraphColoring(2, new int[][]{}), true);
        assertEquals(canFinishCycleDetectionGraphColoring(2, new int[][]{{1, 0}, {0, 1}}), false);
        assertEquals(canFinishCycleDetectionGraphColoring(5, new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}}), false);
        assertEquals(canFinishCycleDetectionGraphColoring(5, new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}}), true);
        assertEquals(canFinishCycleDetectionGraphColoring(8, new int[][]{{1, 0}, {2, 6}, {1, 7}, {6, 4}, {7, 0}, {0, 5}}), true);


        assertEquals(cycleInDirectedGraph(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}), true);
        //assertEquals(cycleInDirectedGraph(1, new int[][]{{1, 0}, {2, 0}}), true);
        assertEquals(cycleInDirectedGraph(2, new int[][]{{1, 0}}), true);
        assertEquals(cycleInDirectedGraph(2, new int[][]{}), true);
        assertEquals(cycleInDirectedGraph(2, new int[][]{{1, 0}, {0, 1}}), false);
        assertEquals(cycleInDirectedGraph(5, new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}}), false);
        assertEquals(cycleInDirectedGraph(5, new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}}), true);
        assertEquals(cycleInDirectedGraph(8, new int[][]{{1, 0}, {2, 6}, {1, 7}, {6, 4}, {7, 0}, {0, 5}}), true);
    }

    //Approach # 1 - Using DFS
    //Video - https://www.youtube.com/watch?v=EgI5nU9etnU
    //Complexity - O(V+P) | V - nodes, P - # of pre-requisite
    public static boolean canFinishDFS(int numCourses, int[][] prerequisites) {


        class Local {
            private boolean dfs(int course, Set<Integer> visitedSet, Map<Integer, List<Integer>> map) {
                if (visitedSet.contains(course)) {
                    return false;
                }

                if (map.get(course) == null || map.get(course).size() == 0) return true;

                visitedSet.add(course);

                for (Integer pre : map.get(course)) {
                    final boolean result = dfs(pre, visitedSet, map);
                    if (!result)
                        return false;
                }
                visitedSet.remove(course);
                map.put(course, new ArrayList<>());
                return true;

            }
        }

        Map<Integer, List<Integer>> courseDependency = new HashMap<>();

        for (int[] courseList : prerequisites) {
            List<Integer> dependentCourses = courseDependency.getOrDefault(courseList[0], new ArrayList<>());
            dependentCourses.add(courseList[1]);
            courseDependency.put(courseList[0], dependentCourses);
        }

        Set<Integer> setVal = new HashSet<>();

        Local local = new Local();
        for (int i = 0; i < numCourses; i++) {
            boolean result = local.dfs(i, setVal, courseDependency);
            if (!result)
                return false;
        }

        return true;

    }


    //Approach # 2 - Deadlock detection - Single resource instance distributed system.
    // Cycle detection - graph coloring
    //Source Video - https://www.youtube.com/watch?v=kXy0ABd1vwo
    //Complexity - O(E+V) | E - Edges, V - # of nodes?
    public static boolean canFinishCycleDetectionGraphColoring(int numCourses, int[][] prerequisites) {

        class Local {
            private boolean dfs(int course, Map<Integer, List<Integer>> map, int[] visitedArray) {

                if (visitedArray[course] == 2)
                    return false;


                if (visitedArray[course] == 1)
                    return true;

                final List<Integer> pres = map.get(course);
                if (pres == null || pres.size() == 0) {
                    visitedArray[course] = 1; //no pres-requisite so can be marked as processed.
                    return true;
                }

                visitedArray[course] = 2;
                for (Integer preCourse : pres) {
                    boolean result = dfs(preCourse, map, visitedArray);
                    if (!result)
                        return false;
                }
                visitedArray[course] = 1;
                return true;
            }
        }

        Map<Integer, List<Integer>> courseDependency = new HashMap<>();

        for (int[] courseList : prerequisites) {
            List<Integer> dependentCourses = courseDependency.getOrDefault(courseList[0], new ArrayList<>());
            dependentCourses.add(courseList[1]);
            courseDependency.put(courseList[0], dependentCourses);
        }

        int[] visitedArray = new int[numCourses];

        final Local local = new Local();
        for (int i = 0; i < numCourses; i++) {

            if (visitedArray[i] == 0) {
                boolean result = local.dfs(i, courseDependency, visitedArray);
                if (!result)
                    return false;
            }
        }

        return true;
    }

    //Approach 3 - this approach is similar(same) as Approach 2. Instead of a hashmap we are using array of list and is
    // and resulting in best runtime of all 3
    //Runtime: 2 ms, faster than 98.99% of Java online submissions for Course Schedule.
    public static boolean cycleInDirectedGraph(int numCourses, int[][] prerequisites) {
        class Local {
            private boolean dfs(ArrayList<Integer>[] adj, int[] visited, int v) {
                //loop
                if (visited[v] == 1)
                    return false;

                if (visited[v] == 2)
                    return true;

                if (adj[v] == null || adj[v].size() == 0) {
                    visited[v] = 2;
                    return true;
                }
                visited[v] = 1;

                for (int ad : adj[v]) {
                    if (!dfs(adj, visited, ad)) return false;
                }
                visited[v] = 2;
                return true;

            }
        }
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            adj[pre[0]].add(pre[1]);
        }

        //0 - not processed,1 - processing,2 - processed
        int[] visited = new int[numCourses];
        Local local = new Local();
        for (int i = 0; i < numCourses; i++)
            if (visited[i] == 0 && !local.dfs(adj, visited, i)) return false;

        return true;
    }


}
