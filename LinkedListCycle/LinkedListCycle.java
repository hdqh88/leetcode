//============================================================================
// Linked List Cycle 
// Given a linked list, determine if it has a cycle in it.
//
// Follow up:
// Can you solve it without using extra space?
//
// Complexity
// O(n)
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
    public boolean hasCycle(ListNode head) {
        return hasCycle2(head);
    }

    private boolean hasCycle1(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>();
        for (ListNode curNode = head; curNode != null; curNode = curNode.next) {
            if (visited.contains(curNode))
                return true;
            visited.add(curNode);
        }
        return false;
    }

    private boolean hasCycle2(ListNode head) {
        ListNode slowNode = head, fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
        System.out.println(sol.hasCycle(head));
    }
}