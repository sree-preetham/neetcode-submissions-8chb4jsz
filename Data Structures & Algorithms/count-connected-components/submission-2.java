class DisjointSet{
    public int[] parent;
    public int[] size;
    public DisjointSet(int n){
        this.parent = new int[n];
        this.size = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
    }
    public int findPar(int node){
        if(parent[node] == node) return node;
        return parent[node] = findPar(parent[node]);
    }
    public void union(int u, int v){
        int parent_u = findPar(u);
        int parent_v = findPar(v);
        if(size[parent_u] >= size[parent_v]){
            size[parent_u]+=size[parent_v];
            parent[parent_v] = parent_u;
        }
        else{
            size[parent_v]+=size[parent_u];
            parent[parent_u] = parent_v;
        }
    }
}
class Solution {
    private List<List<Integer>> buildAdjacencyList(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }
        return adj;
    }
    private void dfs(int node,  List<List<Integer>> adj, boolean[] vis){
        vis[node] = true;
        for(Integer neighbor: adj.get(node)){
            if(!vis[neighbor]) dfs(neighbor, adj, vis);
        }
        return;
    }
    public int countComponents(int n, int[][] edges) {
        boolean[] vis = new boolean[n];
        int ans = 0;
        // List<List<Integer>> adj = buildAdjacencyList(edges, n);
        // for(int i = 0; i < n; i++){
        //     if(!vis[i]){
        //         dfs(i, adj, vis);
        //         ans++;
        //     }
        // }
        DisjointSet ds = new DisjointSet(n);
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            ds.union(u, v);
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < ds.parent.length;i++) {
            ds.parent[i] = ds.findPar(i);
            set.add(ds.parent[i]);
        }
        return set.size();
    }
}
