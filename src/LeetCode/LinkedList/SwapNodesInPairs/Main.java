package LeetCode.LinkedList.SwapNodesInPairs;

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
        public ListNode swapPairs(ListNode head) {

            ListNode headReference = head;
            ListNode prev = null;
            ListNode hand = head.next;
            while (headReference != null && headReference.next != null) {
                ListNode cur = headReference.next;
                headReference.next = headReference.next.next;
                cur.next = headReference;
                if(prev != null){
                    prev.next = cur;
                }
                prev = headReference;
                headReference = headReference.next;
            }

            hand.next = head;

            return hand;
        }
    }

}
