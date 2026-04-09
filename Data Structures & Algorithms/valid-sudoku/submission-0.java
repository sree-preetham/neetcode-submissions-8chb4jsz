class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean [][] rows = new boolean[9][9];
        boolean [][] cols = new boolean[9][9];
        boolean [][] grid = new boolean[9][9];
        for(int i = 0;i < 9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                int number = board[i][j] - '0' - 1;
                int index = (i/3) * 3 + j/3;
                if(rows[i][number] || cols[j][number] || grid[index][number]) return false;
                rows[i][number] = true;
                cols[j][number] = true;
                grid[index][number] = true;
            }
            
        }
        return true;
    }
}
