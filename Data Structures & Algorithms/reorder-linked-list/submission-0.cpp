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
    ListNode* reverseList(ListNode* head) {
        ListNode* prev = nullptr;
        ListNode* curr = head;
        while(curr){
            ListNode* nextNode = curr->next;
            curr->next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    void reorderList(ListNode* curr) {
        ListNode* head = curr;
        ListNode* newList = new ListNode(curr->val);
        ListNode* tempList = newList;
        curr = curr->next;
        int n = 1;
        while(curr){
            ListNode* temp = new ListNode(curr->val);
            tempList->next = temp;
            tempList = tempList->next;
            curr = curr->next;
            n++;
        }
        tempList->next = nullptr;
        curr = head;
        ListNode* reversedCurr = reverseList(newList);
        while(curr && reversedCurr){
            ListNode* nextNode = curr->next;
            ListNode* nextReversedNode = reversedCurr->next;

            curr->next = reversedCurr;
            curr = nextNode;

            reversedCurr->next = curr;
            reversedCurr = nextReversedNode;
        }
        curr = head;
        int i = 0;
        while(i < n - 1){
            i++;
            curr = curr->next;
        }
        curr->next = nullptr;
    }
};