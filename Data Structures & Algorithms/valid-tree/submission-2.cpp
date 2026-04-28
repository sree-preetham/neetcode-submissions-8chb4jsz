class Solution {
public:
    vector<vector<int>> buildAdj(vector<vector<int>>& edges, int n){
        vector<vector<int>> adj(n);
        for(const vector<int> &edge: edges){
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }
        return adj;
    }
    bool dfsCheckCycle(int src, vector<vector<int>>& adj, vector<int> &vis, vector<int> &dfsVis){
        vis[src] = true;
        for(int &neighbour: adj[src]){
            if(dfsVis[neighbour]) return true;
            else if (!vis[neighbour]) if(dfsCheckCycle(neighbour, adj, vis, dfsVis)) return true;
        }
        dfsVis[src] = true;
        return false;
    }
    bool validTree(int n, vector<vector<int>>& edges) {
        if(edges.size()!=n-1) return false;
        // cycle
        vector<vector<int>> adj = buildAdj(edges, n);
        vector<int> vis(n, false);
        vector<int> dfsVis(n, false);
        int component = 0;
        bool ans = true;
        for(int i = 0; i < n; i++){
            if(!vis[i]) {
                ans = !dfsCheckCycle(i, adj, vis, dfsVis);
                component++;
            }
        }
        return ans && (component == 1);
    }
};
