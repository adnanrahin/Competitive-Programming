package LeetCode.BreadthFirstSearch.CourseSchedule;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(HashMapSolution.canFinish(2, new int[][]{{1, 0}}));

    }

    public static class HashMapSolution {
        public static boolean canFinish(int numCourses, int[][] prerequisites) {

            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int i = 0; i < numCourses; i++) graph.put(i, new ArrayList<>());
            for (int[] pre : prerequisites) {
                if (!graph.containsKey(pre[0])) graph.put(pre[0], new ArrayList<>());
                graph.get(pre[0]).add(pre[1]);
            }

            Set<Integer> visited = new HashSet<>();

            for (int i = 0; i < numCourses; i++) {
                if (!visited.contains(i))
                    if (isCycle(i, graph, visited)) return false;
            }

            return true;
        }

        public static boolean isCycle(int src, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
            visited.add(src);

            List<Integer> neighbors = graph.get(src);

            for (Integer neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    if (isCycle(neighbor, graph, visited)) return true;
                } else if (visited.contains(neighbor)) {
                    return true;
                }
            }
            visited.remove(src);
            return false;
        }
    }

}
