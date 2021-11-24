package LeetCode.LinkedList.ReverseKGroup;

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
        public ListNode reverseKGroup(ListNode head, int k) {

            ListNode tail = head;

            for (int i = 0; i < k; i++) {
                if (tail == null) {
                    return head;
                }
                tail = tail.next;
            }

            ListNode reverseNode = reverse(head, tail);

            tail.next = reverseKGroup(tail, k);

            return reverseNode;
        }

        public ListNode reverse(ListNode head, ListNode tail) {
            ListNode headOfTailNode = tail;
            while (head != tail) {
                ListNode temp = head.next;
                head.next = headOfTailNode;
                headOfTailNode = head;
                head = temp;
            }
            return headOfTailNode;
        }

    }

}
