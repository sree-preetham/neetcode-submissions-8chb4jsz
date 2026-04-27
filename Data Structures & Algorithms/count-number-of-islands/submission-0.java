class Cell {
    public int row;
    public int col;
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    private boolean check(int row, int col, char[][] grid){
        return row >=0 && col>=0 && row < grid.length && col < grid[0].length && grid[row][col] == '1';
    }
    private void gridBfs(char[][] grid, int row, int col, ArrayDeque<Cell> queue){
        queue.offerLast(new Cell(row, col));
        grid[row][col] = '.';
        int[] dirX = new int[]{-1,1,0,0};
        int[] dirY = new int[]{0,0,-1,1};
        while(!queue.isEmpty()){
            Cell cell = queue.pollFirst();
            for(int i = 0; i < 4; i++){
                int nrow = cell.row + dirX[i];
                int ncol = cell.col + dirY[i];
                if(check(nrow, ncol, grid)){
                    grid[nrow][ncol] = '.';
                    queue.offerLast(new Cell(nrow, ncol));
                }
            }
        }
        return;
    }
    public int numIslands(char[][] grid) {
        int ans = 0;
        ArrayDeque<Cell> queue = new ArrayDeque<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    ans++;
                    gridBfs(grid, i, j, queue);
                }
            }
        }
        return ans;
    }
}
