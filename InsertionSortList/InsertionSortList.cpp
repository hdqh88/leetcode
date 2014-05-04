//============================================================================
// Insertion Sort List 
// Sort a linked list using insertion sort.
//
// Complexity:
// O(n^2) time
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

ListNode * pushDummy(ListNode * head) {
    ListNode * newNode = new ListNode(-1);
    newNode->next = head;
    return newNode;
}

ListNode * popDummy(ListNode * head) {
    ListNode * delNode = head;
    head = head->next;
    delete delNode;
    return head;
}

class Solution {
public:
    ListNode *insertionSortList(ListNode *head) {
        ListNode * res = pushDummy(NULL);
        ListNode * curNode = head;
        while (curNode) {
            ListNode * nextNode = curNode->next;
            insert(res, curNode);
            curNode = nextNode;
        }
        return popDummy(res);
    }
    
    void insert(ListNode * head, ListNode * newNode) {
        ListNode * preNode = head, * curNode = head->next;
        while (curNode && curNode->val < newNode->val) preNode = curNode, curNode = curNode->next;
        preNode->next = newNode;
        newNode->next = curNode;
    }
};

int main() {
    Solution sol;
    ListNode *head;

    {
        head = new ListNode(3);
        head->next = new ListNode(2);
        head->next->next = new ListNode(4);
        head = sol.insertionSortList(head);
        for (; head; head = head->next) cout << head->val << " ";
        cout << endl;
    }

    return 0;
}
