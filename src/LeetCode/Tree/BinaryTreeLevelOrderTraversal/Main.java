package LeetCode.Tree.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

    }


    public class TreeNode {
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

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {

            if (root == null) return new ArrayList<>();

            List<List<Integer>> solution = new ArrayList<>();
            Map<Integer, List<Integer>> map = new HashMap<>();
            levelOrder(root, map, 0);

            for(Integer itr: map.keySet()){
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

}
