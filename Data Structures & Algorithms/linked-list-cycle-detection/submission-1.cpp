/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    bool hasCycle(ListNode* head) {
        if(!head || !head->next) return false;
        ListNode* slowPtr = head;
        ListNode* fastPtr = head;
        do{
            slowPtr = slowPtr->next;
            fastPtr = fastPtr->next->next;
        } while(fastPtr && fastPtr!=slowPtr);

        if(fastPtr && fastPtr == slowPtr) return true;
        return false;
    }
};
