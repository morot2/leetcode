package java_sol.easy;

import java_sol.comm.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) { return head; }

        Set<Integer> bucket = new HashSet<>();
        ListNode before = head;
        ListNode current = head.next;

        bucket.add(before.val);
        while (current != null) {
            if (bucket.contains(current.val)) {
                before.next = current.next;
                current = current.next;
            } else {
                bucket.add(current.val);
                before = current;
                current = current.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(3, null);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(1, node2);

        deleteDuplicates(node1);
    }
}
