package java_sol.medium;

import java_sol.comm.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

    public static  ListNode swapPairs(ListNode head) {
        ListNode current = head;
        while(current != null){
            if(current.next != null){
                int temp = current.val;
                current.val = current.next.val;
                current.next.val = temp;

                current = current.next.next;
            } else {
                break;
            }
        }

        return head;
    }

    public static void main(String[] args){
        ListNode l4 = new ListNode(4, null);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        swapPairs(l1);
    }
}
