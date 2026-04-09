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
    TreeNode* helper(vector<int>& preorder, vector<int>& inorder, int start, int end, int &idx){
        //base
        if(start > end || idx == inorder.size()) return nullptr;

        int current_root = preorder[idx++];
        int inorder_idx;
        for(int i = start;i<=end;i++){
            if(inorder[i] == current_root){
                inorder_idx = i;
                break;
            }
        }
        TreeNode* root = new TreeNode(current_root);
        TreeNode* leftTree = helper(preorder, inorder, start, inorder_idx - 1, idx);
        TreeNode* rightTree = helper(preorder, inorder, inorder_idx + 1, end, idx);
        root->left = leftTree;
        root->right = rightTree;
        return root;

    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        const int n = preorder.size() - 1;
        int idx = 0;
        TreeNode* root = helper(preorder, inorder, 0, n, idx);
        return root;
    }
};
