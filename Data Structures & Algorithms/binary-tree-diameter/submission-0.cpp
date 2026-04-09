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
    int f(TreeNode* root, int &ans){
        if(!root) return 0;
        int leftDepth = f(root->left, ans);
        int rightDepth = f(root->right, ans);
        int height = 1 + max(leftDepth, rightDepth);
        ans = max(ans, 1 + leftDepth + rightDepth);
        return height;
    }
    int diameterOfBinaryTree(TreeNode* root) {
       int ans = 0;
       f(root, ans);
       return ans - 1; 
    }
};
