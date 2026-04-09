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
    bool validate(TreeNode* root, int maxima, int minima){
        if(!root) return true;
        if(root && (root->val <= minima || root->val >= maxima)) return false;
        return validate(root->left, root->val, minima) &&  validate(root->right, maxima, root->val);
    }
    bool isValidBST(TreeNode* root) {
        return validate(root, INT_MAX, INT_MIN);
    }
};
