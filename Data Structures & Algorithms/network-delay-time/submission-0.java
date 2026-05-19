class Edge {
    int target;
    int weight;

    Edge(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

class Solution {
    private List<Edge>[] buildAdjacencyList(int n, int[][] times){
        List<Edge>[] adj = new ArrayList[n+1];
        for (int i = 0; i <=n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] time: times){
            int u = time[0];
            int v = time[1];
            int k = time[2];
            Edge edge = new Edge(v, k);
            adj[u].add(edge);
        }
        return adj;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distances = new int[n+1];
        for(int i = 1;i<=n;i++) distances[i] = Integer.MAX_VALUE;
        distances[k] = 0;
        List<Edge>[] adj = buildAdjacencyList(n, times);
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(k, 0));
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int node = edge.target;
            int currentTime = edge.weight;
            for(Edge neighborEdge: adj[node]){
                int neighbor = neighborEdge.target;
                int time = neighborEdge.weight;
                if(distances[neighbor] > currentTime + time){
                    distances[neighbor] = currentTime + time;
                    pq.add(new Edge(neighbor, distances[neighbor]));
                }
            }
        }
        int ans = 0;
        for(int distance: distances) {
            if(distance == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, distance);
        }
        return ans;
    }   
}