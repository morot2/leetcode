package java.easy;

import java.common.ListNode;
import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;

        Stack<ListNode> stack = new Stack();

        ListNode curr = head;
        stack.push(curr);
        while(curr.next != null){
            curr = curr.next;
            stack.push(curr);
        }

        curr = stack.pop();
        head = curr;
        while(!stack.isEmpty()){
            ListNode next = stack.pop();
            curr.next = next;
            curr = next;
        }
        curr.next = null;

        return head;
    }

    public static void main(String[] args){
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode listNode = reverseList(node1);
    }


}
