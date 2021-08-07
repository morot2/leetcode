package kotlin_sol.medium

import java_sol.comm.ListNode

/**
 *
 */
class RemoveNthNode {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var size = 0
        var current = head

        while(current?.next != null) {
            size++
            current = current.next

            if(current.next == null)
                size++
        }

        if(size < 1)
            return null

        val idxOfSourceNode = size - n

        if(idxOfSourceNode < 0)
            return head
        else if(idxOfSourceNode == 0)
            return head?.next

        var idxCount = 1
        current = head
        while(idxCount < idxOfSourceNode){
            current = current?.next
            idxCount++
        }


        if(current?.next != null){
            current.next = current.next.next
        }

        return head
    }
}

fun main(){
    val listNode5 = ListNode(5, null)
    val listNode4 = ListNode(4, listNode5)
    val listNode3 = ListNode(3, listNode4)
    val listNode2 = ListNode(2, listNode3)
    val listNode1 = ListNode(1, listNode2)

    val rn = RemoveNthNode()
    val removeNthFromEnd = rn.removeNthFromEnd(listNode1, 2)
}