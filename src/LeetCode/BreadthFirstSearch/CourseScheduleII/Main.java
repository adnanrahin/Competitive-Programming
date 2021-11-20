package LeetCode.BreadthFirstSearch.CourseScheduleII;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[][] graph = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        System.out.println(Arrays.toString(findOrder(4, graph)));

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) graph.put(i, new ArrayList<>());

        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }

        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (topologicalSorting(i, graph, set, stack, visited)) return new int[]{};
            }
        }


        int index = numCourses - 1;
        while (!stack.isEmpty()) {
            order[index--] = stack.pop();
        }

        return order;
    }

    public static boolean topologicalSorting(int src, Map<Integer, List<Integer>> graph, Set<Integer> cycle,
                                             Stack<Integer> stack, boolean[] visited) {
        visited[src] = true;
        cycle.add(src);

        List<Integer> children = graph.get(src);

        for (Integer child : children) {
            if (!visited[child]) {
                cycle.add(child);
                if (topologicalSorting(child, graph, cycle, stack, visited)) return true;
            } else if (cycle.contains(child)) return true;
        }

        stack.add(src);
        cycle.remove(src);
        return false;
    }

}
