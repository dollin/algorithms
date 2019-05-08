package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.tags.depth_first_search;
import org.elvaston.leetcode.tags.graph;
import org.elvaston.leetcode.difficulty.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/keys-and-rooms/
 *
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.
 * A key rooms[i][j] = v opens the room with number v.
 * Initially, all the rooms start locked (except for room 0).
 * You can walk back and forth between rooms freely.
 * Return true if and only if you can enter every room.
 *
 * Example 1:
 * Input: [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We start in room 0, and pick up key 1.
 * We then go to room 1, and pick up key 2.
 * We then go to room 2, and pick up key 3.
 * We then go to room 3.  Since we were able to go to every room, we return true.
 * Example 2:
 * Input: [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can't enter the room with number 2.
 * Note:
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * The number of keys in all rooms combined is at most 3000.
 */
@medium
@depth_first_search
@graph
public class keys_and_rooms {

    public static void main(String[] args) {
        keys_and_rooms solution = new keys_and_rooms();
        List<Integer> room0 = new ArrayList<>();
        add(room0, 1, 3);
        List<Integer> room1 = new ArrayList<>();
        add(room1, 3, 0, 1);
        List<Integer> room2 = new ArrayList<>();
        add(room2, 2);
        List<Integer> room3 = new ArrayList<>();
        add(room3, 0);
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        System.out.println(solution.canVisitAllRooms(rooms));
    }

    private static void add(List<Integer> room, int... keys) {
        for (int key : keys) {
            room.add(key);
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visitedRooms = new boolean[rooms.size()];

        visitRoom(rooms, 0, visitedRooms);

        for (boolean visitedRoom: visitedRooms) {
            if (!visitedRoom) {
                return false;
            }
        }
        return true;
    }

    private void visitRoom(List<List<Integer>> rooms, int roomId, boolean[] visited) {
        if (!visited[roomId]) {
            visited[roomId] = true;
            for (Integer key: rooms.get(roomId)) {
                visitRoom(rooms, key, visited);
            }
        }
    }
}
