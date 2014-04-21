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
        auto it = lists.begin();
        while (it != lists.end()) it = *it ? it + 1 : lists.erase(it);
        auto cmp = [](ListNode * p, ListNode * q) { return p->val > q->val; };
        make_heap(lists.begin(), lists.end(), cmp);
        ListNode * head = pushDummy(NULL), *cur = head, *top = NULL;
        while (!lists.empty()) {
            pop_heap(lists.begin(), lists.end(), cmp), top = lists.back(), lists.pop_back();
            if (top->next) lists.push_back(top->next), push_heap(lists.begin(), lists.end(), cmp);
            cur->next = top, cur = cur->next;
        }
        return popDummy(head);
    }
};

int main() {
    return 0;
}
