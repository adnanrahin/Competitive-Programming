package LeetCode.Tree.BinaryTreeLevelOrderTraversal;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        DepthFirstSearchSolution dfs = new DepthFirstSearchSolution();
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class BreadthFirstSearch {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) return new ArrayList<>();

        List<List<Integer>> solution = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> local = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode u = queue.poll();
                local.add(u.val);
                if (u.left != null) queue.add(u.left);
                if (u.right != null) queue.add(u.right);
            }
            solution.add(local);
        }

        return solution;
    }

}


class DepthFirstSearchSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) return new ArrayList<>();

        List<List<Integer>> solution = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        levelOrder(root, map, 0);

        for (Integer itr : map.keySet()) {
            solution.add(map.get(itr));
        }

        return solution;
    }

    public void levelOrder(TreeNode root, Map<Integer, List<Integer>> map, int level) {

        if (root == null) return;

        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(root.val);
        levelOrder(root.left, map, level + 1);
        levelOrder(root.right, map, level + 1);
    }
}
