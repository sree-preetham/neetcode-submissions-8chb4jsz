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
    int postorder(TreeNode* root, int &ans){
        // base
        int leftMax = -1001, rightMax = -1001;
        if(root->left) leftMax = postorder(root->left, ans);
        if(root->right) rightMax = postorder(root->right, ans);

        int returnValue = max(root->val, max(root->val + leftMax, root->val + rightMax));
        ans = max(ans, max(returnValue, root->val + leftMax + rightMax));
        return returnValue;
    }
    int maxPathSum(TreeNode* root) {
        int ans = -1001;
        postorder(root, ans);
        return ans;
    }
};