package LeetCode.MergeTwoSortedList;

public class Main {


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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            ListNode result = new ListNode(0);
            ListNode resultReference = result.next;

            while (l1 != null && l2 != null) {

                if (l1.val == l2.val) {
                    result.next = new ListNode(l1.val);
                    result = result.next;
                    result.next = new ListNode(l2.val);
                    result = result.next;
                    l1 = l1.next;
                    l2 = l2.next;
                } else if (l1.val > l2.val) {
                    result.next = new ListNode(l2.val);
                    result = result.next;
                    l2 = l2.next;
                } else {
                    result.next = new ListNode(l1.val);
                    result = result.next;
                    l1 = l1.next;
                }
            }

            ListNode reminder = (l1 != null) ? l1 : l2;

            while (reminder != null) {
                result.next = new ListNode(reminder.val);
                result = result.next;
                reminder = reminder.next;
            }

            return resultReference;
        }
    }

}
