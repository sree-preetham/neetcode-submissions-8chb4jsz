class DisjointSet{
    public:
        vector<int> parent;
        vector<int> size;
        DisjointSet(int n){
            parent.resize(n);
            size.resize(n,1);
            for(int i = 0;i <n;i++) parent[i] = i;
        }
        int findParent(int node){
            if(parent[node]==node) return node;
            return parent[node] = findParent(parent[node]);
        }

        bool isConnected(int u, int v){
            if(findParent(u)==findParent(v)) return true;
            return false;
        }

        void unionNode(int u, int v){
            int parent_u = parent[u];
            int parent_v = parent[v];
            if(size[parent_u] > size[parent_v]){
                size[parent_u]+=size[parent_v];
                parent[parent_v] = parent_u;
            }
            else{
                size[parent_v]+=size[parent_u];
                parent[parent_u] = parent_v;
            }
        }
};
class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        int n = edges.size();
        DisjointSet ds(n+1);
        vector<int> ans;
        for(const auto &edge:edges){
            int u = edge[0];
            int v = edge[1];
            if(ds.isConnected(u,v)){
                ans = {u,v};
                continue;
            } 
            else ds.unionNode(u,v);
        }
        return ans;
    }
};