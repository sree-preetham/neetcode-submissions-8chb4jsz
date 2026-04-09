
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void preorder(TreeNode* root, int maxi, int &ans){
        if(!root) return;
        if(root->val >= maxi) ans++;
        preorder(root->left, max(maxi, root->val), ans);
        preorder(root->right, max(maxi, root->val), ans);
    }
    int goodNodes(TreeNode* root) {
        int maxi = INT_MIN;
        int ans = 0;
        preorder(root, maxi, ans);
        return ans;
    }
};