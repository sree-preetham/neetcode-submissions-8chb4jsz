class Cell{
    public int row;
    public int col;
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    private int gridBfs(int[][] grid, int rows, int cols){
        ArrayDeque<Cell> queue = new ArrayDeque<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    queue.offerLast(new Cell(i, j));
                    grid[i][j] = -1;
                    break;
                }
            }
        }
        int ans = 0;
        int[] dirX = new int[]{-1,1,0,0};
        int[] dirY = new int[]{0,0,-1,1};
        while(!queue.isEmpty()){
            Cell cell = queue.pollFirst();
            int row = cell.row;
            int col = cell.col;
            for(int dir = 0; dir < 4; dir++){
                int nrow = row + dirX[dir];
                int ncol = col + dirY[dir];
                if((nrow < 0 || ncol < 0 || nrow == rows || ncol == cols) || grid[nrow][ncol] == 0) {
                    ans++;
                }
                else if(grid[nrow][ncol] != -1) {
                    grid[nrow][ncol] = -1;
                    queue.offerLast(new Cell(nrow, ncol));
                }
            }
        }
        return ans;
    }
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        // int ans = gridBfs(grid, rows, cols);
        int ans = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    ans = ans + 4;
                    if(i > 0 && grid[i-1][j] == 1) ans = ans - 2;
                    if(j > 0 && grid[i][j-1] == 1) ans = ans - 2;
                }
            }
        }
        return ans;
    }
}