class Solution {
    private List<List<Integer>> buildAdjacencyList(int[][] edges, int n, int[] indegree) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            adj.get(dest).add(src);
            indegree[src]++;
        }
        return adj;
    }
    public boolean canFinish(int n, int[][] prerequisites) {
        int coursesCompleted = 0;
        int[] indegree = new int[n];
        List<List<Integer>> adj = buildAdjacencyList(prerequisites, n, indegree);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i++) if(indegree[i] == 0)  queue.offerLast(i);
        while(!queue.isEmpty()){
            int node = queue.pollFirst();
            coursesCompleted++;
            for(Integer neighbor: adj.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0)  queue.offerLast(neighbor);
            }
        }
        return coursesCompleted == n ? true : false;
    }
}
