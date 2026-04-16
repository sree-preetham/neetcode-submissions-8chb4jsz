class NumMatrix {
public:
    vector<vector<int>> prefix;
    vector<vector<int>> original;
    NumMatrix(vector<vector<int>>& matrix) {
        original = matrix;
        const int m = matrix.size(), n = matrix[0].size();
        for(const vector<int> &row: matrix) prefix.push_back(row);
        prefixSum(prefix);
    }
    
    int sumRegion(int row1, int col1, int row2, int col2) {
        int total = prefix[row2][col2];
        int top = (row1 > 0) ? prefix[row1 - 1][col2] : 0;
        int left = (col1 > 0) ? prefix[row2][col1 - 1] : 0;
        // Sum from (0,0) to (row1-1, col1-1)
        int topLeftOverlap = (row1 > 0 && col1 > 0) ? prefix[row1 - 1][col1 - 1] : 0;
        return total - top - left + topLeftOverlap;
    }
    
    void prefixSum(vector<vector<int>>& matrix){
        const int m = matrix.size(), n = matrix[0].size();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int leftSum = 0, topSum = 0, diagSum = 0;
                if(j > 0) leftSum = matrix[i][j-1];
                if(i > 0) topSum = matrix[i-1][j];
                if(i > 0 && j > 0) diagSum = matrix[i-1][j-1];
                matrix[i][j] = matrix[i][j] + (leftSum + topSum - diagSum);
            }
        }
        return;
    }
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix* obj = new NumMatrix(matrix);
 * int param_1 = obj->sumRegion(row1,col1,row2,col2);
 */