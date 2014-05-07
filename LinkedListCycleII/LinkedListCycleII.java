//============================================================================
// Linked List Cycle II
// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
// Follow up:
// Can you solve it without using extra space?
//============================================================================

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        return detectCycle2(head);
    }

    private ListNode detectCycle1(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>();
        for (ListNode curNode = head; curNode != null; curNode = curNode.next) {
            if (visited.contains(curNode))
                return curNode;
            visited.add(curNode);
        }
        return null;
    }

    private ListNode detectCycle2(ListNode head) {
        ListNode slowNode = head, fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode)
                break;
        }
        if (fastNode != slowNode)
            return null;
        fastNode = head;
        while (fastNode != slowNode) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return fastNode;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
        ListNode res = sol.detectCycle(head);
        System.out.println(res.val);
    }
}