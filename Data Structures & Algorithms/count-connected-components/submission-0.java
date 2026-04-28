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
        List<List<Integer>> adj = buildAdjacencyList(edges, n);
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(i, adj, vis);
                ans++;
            }
        }
        return ans;
    }
}
