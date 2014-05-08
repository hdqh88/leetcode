//============================================================================
// Reorder List
//
// Given a singly linked list L: L0->L1->...->Ln-1->Ln,
// reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->...
//
// You must do this in-place without altering the nodes' values.
//
// For example,
// Given {1,2,3,4}, reorder it to {1,4,2,3}.
//
// Complexity:
// Random Access Cache, O(n) time, O(n) space
// Split, Reverse, Merge, O(n) time, O(1) space
//============================================================================

import java.util.ArrayList;
import java.util.List;

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
    public void reorderList(ListNode head) {
        reorderList2(head);
    }

    private void reorderList1(ListNode head) {
        if (head == null) return;
        List<ListNode> ls = new ArrayList<ListNode>();
        for (; head != null; head = head.next) ls.add(head);
        int i = 0, j = ls.size()-1;
        for (; i < j; i++, j--) {
            ls.get(i).next = ls.get(j);
            ls.get(j).next = ls.get(i+1);
        }
        ls.get(i).next = null;
    }

    private void reorderList2(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode[] splitted = split(head);
        splitted[1] = reverse(splitted[1]);
        merge(splitted);
    }

    private ListNode[] split(ListNode head) {
        ListNode frontNode = head, backNode = head;
        for (; frontNode.next != null && frontNode.next.next != null; frontNode = frontNode.next.next) {
            backNode = backNode.next;
        }
        ListNode[] res = new ListNode[]{head, backNode.next};
        backNode.next = null;
        return res;
    }

    private ListNode reverse(ListNode curNode) {
        ListNode preNode = null;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }

    private void merge(ListNode[] splitted) {
        ListNode backNode = splitted[0], frontNode = splitted[1];
        ListNode head = new ListNode(-1), curNode = head;
        while (backNode != null || frontNode != null) {
            if (backNode != null) {
                curNode.next = backNode;
                backNode = backNode.next;
                curNode = curNode.next;
            }
            if (frontNode != null) {
                curNode.next = frontNode;
                frontNode = frontNode.next;
                curNode = curNode.next;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        sol.reorderList(head);
        for (; head != null; head = head.next) {
            System.out.print(head.val + " ");
        }
        System.out.println();
    }
}