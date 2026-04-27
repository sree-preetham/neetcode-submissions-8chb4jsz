class Cell {
    public int row;
    public int col;
    public int dist;
    public Cell(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    private int INF = 2147483647;
    private boolean check(int row, int col, int[][] grid){
        return row >=0 && col>=0 && row < grid.length && col < grid[0].length && (grid[row][col] != 0 || grid[row][col] != -1);
    }
    private void gridBfs(int[][] grid, ArrayDeque<Cell> queue){
        int[] dirX = new int[]{-1,1,0,0};
        int[] dirY = new int[]{0,0,-1,1};
        while(!queue.isEmpty()){
            Cell cell = queue.pollFirst();
            int row = cell.row, col = cell.col, dist = cell.dist;
            for(int i = 0; i < 4; i++){
                int nrow = cell.row + dirX[i];
                int ncol = cell.col + dirY[i];
                if(check(nrow, ncol, grid)){
                    if(1 + dist < grid[nrow][ncol]){
                        grid[nrow][ncol] = 1 + dist;
                        queue.offerLast(new Cell(nrow, ncol, 1 + dist));
                    }
                }
            }
        }
        return;
    }
    public void islandsAndTreasure(int[][] grid) {
        ArrayDeque<Cell> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new Cell(i, j, 0));
                }
            }
        }
        gridBfs(grid, queue);
        return;
    }
}
