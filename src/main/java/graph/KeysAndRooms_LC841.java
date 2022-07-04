package graph;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Leetcode 841
 * https://leetcode.com/problems/keys-and-rooms/
 */
public class KeysAndRooms_LC841 {

    public static void main(String[] args) {
        Integer[][] rooms = new Integer[][]{{1}, {2}, {3}, {}};

        final List<List<Integer>> collect = Arrays.stream(rooms).map(Arrays::asList).collect(Collectors.toList());
        final boolean result = canVisitAllRooms(collect);
        System.out.println("result " + result);
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        final int startRoomNumber = 0;

        dfs(startRoomNumber, rooms, visited);

        for (int i = 0; i < rooms.size(); i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    private static void dfs(int roomNumber, List<List<Integer>> rooms, boolean[] visited) {
        visited[roomNumber] = true;
        final List<Integer> adjs = rooms.get(roomNumber);
        for (int adj : adjs) {
            if (!visited[adj]) {
                dfs(adj, rooms, visited);
            }
        }

    }


}
