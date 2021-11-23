package LeetCode.Tree.BalancedBinaryTree;

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
        public boolean isBalanced(TreeNode root) {

            if (root == null) return true;

            int leftH = getDepth(root.left);
            int rightH = getDepth(root.right);

            if (Math.abs(leftH - rightH) > 1) return false;

            return isBalanced(root.left) && isBalanced(root.right);
        }

        public int getDepth(TreeNode root) {
            if (root == null) return 0;
            return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
        }

    }

}
