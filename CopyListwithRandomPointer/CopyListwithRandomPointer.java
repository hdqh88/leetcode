//============================================================================
// A linked list is given such that each node contains an additional random 
// pointer which could point to any node in the list or null.
//
// Return a deep copy of the list. 
// 
// Complexity:
// hash table with original and copy nodes pair O(n) time O(n) space
// original node -> copy node -> original node O(n) time O(1) space
//============================================================================

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list with a random pointer.
 */
class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        return copyRandomList1(head);
    }

    private RandomListNode copyRandomList1(RandomListNode head) {
        Map<RandomListNode, RandomListNode> tb = new HashMap<RandomListNode, RandomListNode>();
        for (RandomListNode curNode = head; curNode != null; curNode = curNode.next)
            tb.put(curNode, new RandomListNode(curNode.label));
        for (RandomListNode curNode = head; curNode != null; curNode = curNode.next) {
            tb.get(curNode).next = curNode.next == null ? null : tb.get(curNode.next);
            tb.get(curNode).random = curNode.random == null ? null : tb.get(curNode.random);
        }
        return tb.get(head);
    }

    private RandomListNode copyRandomList2(RandomListNode head) {
        for (RandomListNode oldNode = head; oldNode != null; oldNode = oldNode.next.next) {
            RandomListNode newNode = new RandomListNode(oldNode.label);
            newNode.next = oldNode.next;
            oldNode.next = newNode;
        }
        for (RandomListNode oldNode = head; oldNode != null; oldNode = oldNode.next.next)
            oldNode.next.random = oldNode.random == null ? null
                    : oldNode.random.next;
        RandomListNode newHead = head.next, oldNode = head, newNode = newHead;
        while (true) {
            oldNode.next = newNode.next;
            oldNode = oldNode.next;
            if (oldNode == null)
                break;
            newNode.next = oldNode.next;
            newNode = newNode.next;
        }
        return newHead;
    }

    private static void print(RandomListNode head) {
        for (; head != null; head = head.next) {
            System.out.println(head.label + ","
                    + (head.random == null ? "#" : head.random.label));
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.next.next = new RandomListNode(4);
        head.next.next.next.next = new RandomListNode(5);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.next.random = head.next;
        print(sol.copyRandomList(head));
    }
}