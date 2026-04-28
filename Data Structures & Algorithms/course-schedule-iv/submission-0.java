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
        }
        return adj;
    }
    private boolean bfs(int src, int dest, List<List<Integer>> adj, int n){
        boolean[] vis = new boolean[n];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offerLast(src);
        vis[src] = true;
        while(!q.isEmpty()){
            int node = q.pollFirst();
            for(Integer neighbour: adj.get(node)){
                if(neighbour == dest) return true;
                else if(!vis[neighbour]){
                    q.offerLast(neighbour);
                    vis[neighbour] = true;
                }
            }
        }
        return false;
    }
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        List<List<Integer>> adj = buildAdjacencyList(prerequisites, n);
        for(int[] query: queries){
            int u = query[0];
            int v = query[1];
            ans.add(bfs(u, v, adj, n));
        }
        return ans;
    }
}