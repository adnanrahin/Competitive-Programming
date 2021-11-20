package LeetCode.Tree.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

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

        List<Integer> solution = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return solution;
            }
            solution = inorderTraversal(root.left);
            solution.add(root.val);
            solution = inorderTraversal(root.right);

            return solution;
        }

    }

}
