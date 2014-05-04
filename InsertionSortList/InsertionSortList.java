//============================================================================
// Insertion Sort List 
// Sort a linked list using insertion sort.
//
// Complexity:
// O(n^2) time
//============================================================================

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
    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(-1);
        while (head != null) {
            ListNode newNode = head;
            head = head.next;
            insert(res, newNode);
        }
        return res.next;
    }

    private void insert(ListNode head, ListNode newNode) {
        ListNode preNode = head, curNode = head.next;
        while (curNode != null && curNode.val < newNode.val) {
            preNode = curNode;
            curNode = curNode.next;
        }
        newNode.next = curNode;
        preNode.next = newNode;
    }

    private static void print(ListNode head) {
        for (; head != null; head = head.next)
            System.out.print(head.val + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head;

        head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        print(sol.insertionSortList(head));

        head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        print(sol.insertionSortList(head));

        head = new ListNode(2);
        head.next = new ListNode(1);
        print(sol.insertionSortList(head));
    }
}