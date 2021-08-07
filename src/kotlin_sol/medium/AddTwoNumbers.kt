package kotlin_sol.medium

import java_sol.comm.ListNode

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if(l1==null && l2==null)
            return null
        else if(l1!=null && l2==null)
            return l1
        else if(l1==null && l2!=null)
            return l2

        val addResult = getAddResult(l1,l2)
        return convertToListNode(addResult)
    }

    private fun convertToListNode(addResult: String): ListNode {
        var idx = 0
        var currentNode = ListNode()

        while (idx <= addResult.lastIndex) {
            currentNode.`val` = addResult.substring(idx, idx + 1).toIntOrDefault()

            if (idx == addResult.lastIndex) break

            idx++
            var previousNode = ListNode()
            previousNode.next = currentNode
            currentNode = previousNode
        }
        return currentNode
    }

    fun getAddResult(l1: ListNode?, l2: ListNode?): String {
        var a = l1
        var b = l2

        var l1Str = ""
        var l2Str = ""

        if(a?.next == null)
            l1Str = a?.`val`.toString()
        else{
            while(a?.next != null){
                l1Str = a?.`val`.toString() + l1Str
                a = a?.next

                if(a?.next == null) l1Str = a?.`val`.toString() + l1Str
            }
        }

        if(b?.next == null)
            l2Str = b?.`val`.toString()
        else {
            while (b?.next != null) {
                l2Str = b?.`val`.toString() + l2Str
                b = b?.next

                if (b?.next == null) l2Str = b?.`val`.toString() + l2Str
            }
        }

        var x = l1Str.toIntOrDefault()
        var y = l2Str.toLong()
        return ((l1Str.toIntOrDefault()) + l2Str.toIntOrDefault()).toString()
    }
}

fun String?.toIntOrDefault(default: Int = 0): Int {
    return this?.toIntOrNull()?:default
}

fun main(){
    val listNode13 = ListNode(9, null)
    val listNode12 = ListNode(9, listNode13)
    val listNode11 = ListNode(9, listNode12)
    val listNode10 = ListNode(9, listNode11)
    val listNode9 = ListNode(9, listNode10)
    val listNode8 = ListNode(9, listNode9)
    val listNode7 = ListNode(9, listNode8)
    val listNode6 = ListNode(9, listNode7)
    val listNode5 = ListNode(9, listNode6)
    val listNode4 = ListNode(1, listNode5)

    val listNode3 = ListNode(3, null)
    val listNode2 = ListNode(4, listNode3)
    val listNode1 = ListNode(2, listNode2)

    val atn = AddTwoNumbers()
   // val addTwoNumbers = atn.addTwoNumbers(listNode1, listNode4)
    val addTwoNumbers = atn.addTwoNumbers(ListNode(9), listNode4)
}