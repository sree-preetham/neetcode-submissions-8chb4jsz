class Solution {
public:
    bool validTree(int n, vector<vector<int>>& edges) {
        if(edges.size()!=n-1) return false;
        // number of connected components = 1;
        vector<vector<int>> adj(n);
        for(const auto &edge:edges) adj[edge[0]].push_back(edge[1]), adj[edge[1]].push_back(edge[0]);
        int count = 0;
        queue<int> q;
        q.push(0);
        vector<bool> vis(n, false);
        vis[0] = true;
        while(!q.empty()){
            int node = q.front();
            q.pop();
            count++;
            for(const auto &neighbor:adj[node]){
                if(!vis[neighbor]){
                    vis[neighbor] = 1;
                    q.push(neighbor);
                }
            }
        }
        if(count!=n) return false;
        return true;
    }
};