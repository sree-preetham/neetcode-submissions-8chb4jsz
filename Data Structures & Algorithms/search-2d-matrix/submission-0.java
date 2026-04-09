class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, total = m * n, low = 0, high = total - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int i = mid/n;
            int j = mid%n;
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}