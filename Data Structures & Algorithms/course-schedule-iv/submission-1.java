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
    private boolean bfsPerQuery(int src, int dest, List<List<Integer>> adj, int n){
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
    private void bfs(int src, List<List<Integer>> adj, boolean[][] isReachable, int n, ArrayDeque<Integer> q){
        boolean[] vis = new boolean[n];
        vis[src] = true;
        q.offerLast(src);
        while(!q.isEmpty()){
            int node = q.pollFirst();
            for(Integer neighbour: adj.get(node)){
                if(!vis[neighbour]){
                    q.offerLast(neighbour);
                    vis[neighbour] = true;
                    isReachable[node][neighbour] = true;
                    isReachable[src][neighbour] = true;
                }
            }
        }
        return;
    }
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        List<List<Integer>> adj = buildAdjacencyList(prerequisites, n);
        boolean[][] isReachable = new boolean[n][n];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            bfs(i, adj, isReachable, n, q);
        }
        for(int[] query: queries){
            int u = query[0];
            int v = query[1];
            ans.add(isReachable[u][v]);
        }
        return ans;
    }
}