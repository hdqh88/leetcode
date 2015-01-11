//==============================================================================================================================
//Write a program to find the node at which the intersection of two singly linked lists begins.
//For example, the following two linked lists:
//A:          a1 → a2
//                   ↘
//                     c1 → c2 → c3
//                   ↗            
//B:     b1 → b2 → b3
//begin to intersect at node c1.
//Notes:
//If the two linked lists have no intersection at all, return null.
//The linked lists must retain their original structure after the function returns.
//You may assume there are no cycles anywhere in the entire linked structure.
//Your code should preferably run in O(n) time and use only O(1) memory.
//Credits:
//Special thanks to @stellari for adding this problem and creating all test cases.
//==============================================================================================================================
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        int c1 = getCount(headA);
        int c2 = getCount(headB);
        int d;
 
        if(c1 > c2)
        {
            d = c1 - c2;
            return _getIntesectionNode(d, headA, headB);
        }
        else
        {
            d = c2 - c1;
            return _getIntesectionNode(d, headB, headA);
        }
    }
 
/* function to get the intersection point of two linked
   lists head1 and head2 where head1 has d more nodes than
   head2 */
    public ListNode _getIntesectionNode(int d, ListNode headA, ListNode headB)
    {
        int i;
        ListNode current1 = headA;
        ListNode current2 = headB;
 
        for(i = 0; i < d; i++)
        {
            if(current1 == null)
            {return null;}
            current1 = current1.next;
        }
 
        while(current1 !=  null && current2 != null)
        {
            if(current1 == current2)
            return current1;
            current1= current1.next;
            current2= current2.next;
        }
 
        return null;
    }
 
/* Takes head pointer of the linked list and
   returns the count of nodes in the list */
    public int getCount(ListNode head)
    {
        ListNode current = head;
        int count = 0;
 
        while (current != null)
        {
            count++;
            current = current.next;
        }
 
        return count;
    }
}
