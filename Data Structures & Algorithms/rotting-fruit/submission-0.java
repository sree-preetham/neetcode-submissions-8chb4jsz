class Cell {
    public int row;
    public int col;
    public int time;
    public Cell(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}


class Solution {
    private static class Answer{
        public int totalFreshFruits;
        public int minimumTime;
        public Answer(int totalFreshFruits, int minimumTime){
            this.totalFreshFruits = totalFreshFruits;
            this.minimumTime = minimumTime;
        }
    }
    private boolean check(int row, int col, int[][] grid){
        return row >=0 && col>=0 && row < grid.length && col < grid[0].length && grid[row][col] == 1;
    }
    private Answer gridBfs(int[][] grid, ArrayDeque<Cell> queue, int totalFreshFruits){
        int[] dirX = new int[]{-1,1,0,0};
        int[] dirY = new int[]{0,0,-1,1};
        int miniTime = 0;
        while(!queue.isEmpty()){
            Cell cell = queue.pollFirst();
            int row = cell.row, col = cell.col, time = cell.time;
            miniTime = time;
            for(int i = 0; i < 4; i++){
                int nrow = cell.row + dirX[i];
                int ncol = cell.col + dirY[i];
                if(check(nrow, ncol, grid)){
                    grid[nrow][ncol] = 2;
                    totalFreshFruits--;
                    queue.offerLast(new Cell(nrow, ncol, 1 + time));
                }
            }
        }
        return new Answer(totalFreshFruits, miniTime);
    }
    public int orangesRotting(int[][] grid) {
        int totalFreshFruits = 0;
        ArrayDeque<Cell> queue = new ArrayDeque<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2){
                   queue.offer(new Cell(i, j, 0));
                }
                else if(grid[i][j] == 1) totalFreshFruits++;
            }
        }
        Answer answer = gridBfs(grid, queue, totalFreshFruits);
        return answer.totalFreshFruits == 0 ? answer.minimumTime : -1;
    }
}
