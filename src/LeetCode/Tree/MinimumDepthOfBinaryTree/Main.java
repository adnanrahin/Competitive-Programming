package LeetCode.Tree.MinimumDepthOfBinaryTree;

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

        int minDepth = Integer.MAX_VALUE;

        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            minLevel(root, 1);
            return minDepth;
        }

        public void minLevel(TreeNode root, int level) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                minDepth = Math.min(minDepth, level);
                return;
            }
            minLevel(root.left, level + 1);
            minLevel(root.right, level + 1);
        }

    }

}
