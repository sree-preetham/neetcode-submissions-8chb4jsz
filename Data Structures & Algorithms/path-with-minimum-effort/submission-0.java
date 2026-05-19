class Solution {
    private static class Node{
        int effort;
        int row;
        int col;
        private Node(int effort, int row, int col){
            this.effort = effort;
            this.row = row;
            this.col = col;
        }
    }
    private int INF = 1000000000;
    private int[] dirX = {-1,1,0,0};
    private int[] dirY = {0,0,-1,1};
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.effort, b.effort));
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] dist = new int[rows][cols];
        for (int[] row : dist) {
            Arrays.fill(row, INF);
        }
        dist[0][0] = 0;
        pq.add(new Node(0, 0, 0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int row = node.row, col = node.col, effort = node.effort;
            if(row == rows - 1 && col == cols - 1) return effort;
            for(int dir = 0; dir < 4; dir++){
                int i = row + dirX[dir];
                int j = col + dirY[dir];
                if(check(i, j, rows, cols)){
                    int neweffort = Math.max(effort, Math.abs(heights[i][j] - heights[row][col]));
                    if(dist[i][j] > neweffort){
                        dist[i][j] = neweffort;
                        pq.add(new Node(neweffort, i, j));
                    }
                }
            }
        }
        return dist[rows-1][cols-1];
    }
    private boolean check(int i, int j, int m, int n){
        return i>=0 && j>=0 && i < m && j < n;
    }
}