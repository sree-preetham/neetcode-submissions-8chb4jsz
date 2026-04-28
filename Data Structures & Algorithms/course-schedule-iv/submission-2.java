class Solution {
     private List<List<Integer>> buildAdjacencyList(int[][] edges, int n, int[] indegree) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            adj.get(src).add(dest);
            indegree[dest]++;
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
        boolean[][] isReachable = new boolean[n][n];
        int[] indegree = new int[n];
        List<List<Integer>> adj = buildAdjacencyList(prerequisites, n, indegree);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i++) if(indegree[i] == 0)  queue.offerLast(i);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Integer v : adj.get(u)) {
                isReachable[u][v] = true;
                for (int i = 0; i < n; i++) {
                    if (isReachable[i][u]) isReachable[i][v] = true;
                }
                if (--indegree[v] == 0) queue.offer(v);
            }
        }
        for (int[] query : queries) {
            ans.add(isReachable[query[0]][query[1]]);
        }
        return ans;
    }
}