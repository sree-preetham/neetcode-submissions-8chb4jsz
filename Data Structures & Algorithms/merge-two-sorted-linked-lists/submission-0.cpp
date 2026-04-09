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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        if(!list2) return list1;
        else if(!list1) return list2;
        
        ListNode* curr1 = list1;
        ListNode* curr2 = list2;
        ListNode* head = list1->val <= list2->val ? list1 : list2;
        ListNode* curr = head;

        if(head == list1) curr1 = curr1->next;
        else curr2 = curr2->next;

        while(curr1 && curr2){
            if(curr1->val <= curr2->val){
                curr->next = curr1;
                curr1=curr1->next;
            }
            else{
                curr->next = curr2;
                curr2=curr2->next;
            }
            curr=curr->next;
        }

        while(curr1){
            curr->next = curr1;
            curr1=curr1->next;
            curr=curr->next;
        }

        while(curr2){
            curr->next = curr2;
            curr2=curr2->next;
            curr=curr->next;
        }
        curr->next=nullptr;
        return head;
    }
};
