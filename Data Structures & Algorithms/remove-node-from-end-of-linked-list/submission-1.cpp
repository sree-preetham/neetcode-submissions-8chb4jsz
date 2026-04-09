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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* curr = head;
        
        int i = 0;
        while(i < n){
            curr = curr->next;
            i++;
        }
        ListNode* ans = head;
        if(!curr) return head->next;
        while(curr->next){
            curr = curr->next;
            ans = ans->next;
            i++;
        }
        ans->next = ans->next->next;
        return head;
    }
};
