package LeetCode.Tree.ConvertSortedArrayToBinarySearchTree;

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
        public TreeNode sortedArrayToBST(int[] nums) {
            return makeTree(nums, 0, nums.length - 1);
        }

        public TreeNode makeTree(int[] nums, int low, int high) {
            if (low > high) return null;
            int mid = low + (high - low) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = makeTree(nums, low, mid - 1);
            root.right = makeTree(nums, mid + 1, high);
            return root;
        }
    }

}
