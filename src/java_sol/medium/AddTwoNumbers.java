package java_sol.medium;

import java_sol.comm.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/submissions/
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node = new ListNode();
        ListNode head = node;

        int carry = 0;
        int sum = 0;
        while(l1 != null || l2 != null){
            sum = 0;

            if(l1 != null)
                sum += l1.val;

            if(l2 != null)
                sum += l2.val;

            sum += carry;
            node.val = sum % 10;
            carry = sum / 10;

            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;

            if(l1 == null && l2 == null && carry == 0){
                node.next = null;
                break;
            }

            node.next = new ListNode();
            node = node.next;
        }

        if(carry > 0){
            node.val += carry;
        }

        return head;
    }

    public static void main(String[] args){

        ListNode l6 = new ListNode(3, null);
        ListNode l5 = new ListNode(4, l6);
        ListNode l4 = new ListNode(2, l5);

        ListNode l3 = new ListNode(4, null);
        ListNode l2 = new ListNode(6, l3);
        ListNode l1 = new ListNode(5, l2);

        ListNode listNode = addTwoNumbers(l1, l4);
    }
}
