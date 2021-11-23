package LeetCode.LinkedList.MergeKSortedList;

public class Main {

    public static void main(String[] args) {

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) return new ListNode().next;
            return merge(0, lists.length - 1, lists);
        }

        public ListNode merge(int low, int high, ListNode[] lists) {
            if (low < high) {
                int mid = (low + high) / 2;
                return mergeSortedList(merge(low, mid, lists), merge(mid + 1, high, lists));
            }
            return lists[low];
        }


        public ListNode mergeSortedList(ListNode one, ListNode two) {

            ListNode solution = new ListNode(0);
            ListNode reference = solution;

            while (one != null && two != null) {

                if (one.val == two.val) {
                    solution.next = new ListNode(one.val, solution.next);
                    solution = solution.next;
                    one = one.next;
                    solution.next = new ListNode(two.val, solution.next);
                    solution = solution.next;
                    two = two.next;
                } else if (one.val > two.val) {
                    solution.next = new ListNode(two.val, solution.next);
                    solution = solution.next;
                    two = two.next;
                } else {
                    solution.next = new ListNode(one.val, solution.next);
                    solution = solution.next;
                    one = one.next;
                }
            }

            ListNode rest = (one != null) ? one : two;

            while (rest != null) {
                solution.next = new ListNode(rest.val, solution.next);
                solution = solution.next;
                rest = rest.next;
            }

            return reference.next;
        }

    }

}
