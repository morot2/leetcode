package java_sol.easy;

import java_sol.comm.ListNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedList {
    public static void main(String[] args) {
        ListNode l1_3 = new ListNode(4);
        ListNode l1_2 = new ListNode(2, l1_3);
        ListNode l1_1 = new ListNode(1, l1_2);

        ListNode l2_3 = new ListNode(4);
        ListNode l2_2 = new ListNode(3, l2_3);
        ListNode l2_1 = new ListNode(1, l2_2);

        //ListNode listNode = mergeTwoLists(l1_1, l2_1);
        ListNode listNode = mergeTwoLists(null, new ListNode());
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> mergeList = new LinkedList<>();

        if (l1 != null) {
            while (l1.next != null) {
                mergeList.add(l1.val);
                l1 = l1.next;
            }
            mergeList.add(l1.val);
        }

        if (l2 != null) {
            while (l2.next != null) {
                mergeList.add(l2.val);
                l2 = l2.next;
            }
            mergeList.add(l2.val);
        }

        if (mergeList.isEmpty()) { return null; }

        Collections.sort(mergeList);

        ListNode head = new ListNode(mergeList.get(0));

        if(mergeList.size() == 1)
            return head;

        ListNode curr = new ListNode();
        head.next = curr;

        for (int i = 1; i < mergeList.size(); i++) {
            curr.val = mergeList.get(i);

            if (i == mergeList.size() - 1) {
                curr.next = null;
                break;
            }

            curr.next = new ListNode();
            curr = curr.next;
        }
        return head;
    }
}




