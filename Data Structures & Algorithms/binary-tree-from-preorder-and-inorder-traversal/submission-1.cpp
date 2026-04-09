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
    TreeNode* helper(vector<int>& preorder, vector<int>& inorder, int start, int end, int &idx, unordered_map<int,int> &mp){
        //base
        if(start > end || idx == inorder.size()) return nullptr;

        int current_root = preorder[idx++];
        int inorder_idx = mp[current_root];
       
        TreeNode* root = new TreeNode(current_root);
        TreeNode* leftTree = helper(preorder, inorder, start, inorder_idx - 1, idx, mp);
        TreeNode* rightTree = helper(preorder, inorder, inorder_idx + 1, end, idx, mp);
        root->left = leftTree;
        root->right = rightTree;
        return root;

    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        const int n = preorder.size() - 1;
        int idx = 0;
        unordered_map<int,int> mp;
        for(int i = 0;i<=n;i++){
            mp[inorder[i]] = i;
        }
        TreeNode* root = helper(preorder, inorder, 0, n, idx, mp);
        return root;
    }
};
