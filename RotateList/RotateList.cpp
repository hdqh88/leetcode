//============================================================================
// Rotate List
// Given a list, rotate the list to the right by k places, where k is
// non-negative.
//
// For example:
// Given 1->2->3->4->5->NULL and k = 2,
// return 4->5->1->2->3->NULL.
//============================================================================

#include <iostream>
using namespace std;

/**
 * Definition for singly-linked list.
 */
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *rotateRight(ListNode *head, int k) {
        if (head == NULL || k < 0) return head;
        int l = 1;
        ListNode * curNode = head;
        for (; curNode->next != NULL; curNode = curNode->next) l++;
        curNode->next = head;
        l -= k%l;
        for (; l > 0; l--) curNode = curNode->next;
        head = curNode->next;
        curNode->next = NULL;
        return head;
    }
    
    
    // Hao
    ListNode *rotateRight2(ListNode *head, int k) {
        if(head == NULL || k == 0)
            return head;
        int len = 1;
        ListNode *p = head;
        while(p -> next){
            p = p -> next;
            len++;
        }
        k = len - k % len;
        if(k == len)
            return head;
        p -> next = head;
        
        for(int i = 0; i < k; i++)
            p = p -> next;
        head = p -> next;
        p -> next = NULL;
        return head;
    }
};

int main() {
    Solution sol;

    {
        ListNode * head = new ListNode(1);
        head->next = new ListNode(2);
        head->next->next = new ListNode(3);
        head->next->next->next = new ListNode(4);
        head->next->next->next->next = new ListNode(5);
        head = sol.rotateRight(head, 6);
        while (head != NULL) {
            cout << head->val << " ";
            head = head->next;
        }
        cout << endl;
    }

    return 0;
}
