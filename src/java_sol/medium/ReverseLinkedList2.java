package java_sol.medium;

import java_sol.comm.ListNode;
import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedList2 {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        Stack<ListNode> stack = new Stack();

        ListNode leftOfLeft = null;

        int idx = 1;

        ListNode current = head;
        while(idx < left){
            if(idx + 1 == left){
                leftOfLeft = current;
            }
            current = current.next;
            idx++;
        }

        while(idx < right){
            stack.push(current);
            current = current.next;

            if(idx + 1 == right && current != null)
                stack.push(current);
            idx++;
        }

        ListNode rightOfRight = null;
        if(current.next != null){
            rightOfRight = current.next;
        }

        if(leftOfLeft == null) {
            current = stack.pop();
            head = current;
        } else {
            current = leftOfLeft;
        }

        while(!stack.isEmpty()){
            current.next = stack.pop();
            current = current.next;
        }

        if(rightOfRight == null)
            current.next = null;
        else
            current.next = rightOfRight;

        return head;
    }

    public static void main(String[] args){
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(3, node5);
        //ListNode node3 = new ListNode(3, node4);
        //ListNode node2 = new ListNode(2, node3);
        //ListNode node1 = new ListNode(1, node2);

        ListNode listNode = reverseBetween(node4, 1, 2);
    }
}

