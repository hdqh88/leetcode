//============================================================================
// Merge k sorted linked lists and return it as one sorted list.
// Analyze and describe its complexity.
//
// Complexity:
// O(nlog(k)) time
//============================================================================

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
* Definition for singly-linked list.
*/
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {};
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
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        auto it = begin(lists);
        while (it != end(lists)) {
            if (*it == NULL) it = lists.erase(it);
            else it++;
        }
        if (lists.empty()) return NULL;
        auto cmp = [](ListNode * p, ListNode * q) { return p->val > q->val; };
        make_heap(begin(lists), end(lists), cmp);
        ListNode * head = pushDummy(head), *curNode = head, *nextNode = NULL;
        while (!lists.empty()) {
            pop_heap(begin(lists), end(lists), cmp), nextNode = lists.back(), lists.pop_back();
            if (nextNode->next != NULL) lists.push_back(nextNode->next), push_heap(begin(lists), end(lists), cmp);
            curNode->next = nextNode;
            curNode = curNode->next;
        }
        return popDummy(head);
    }
};

int main() {
    return 0;
}
