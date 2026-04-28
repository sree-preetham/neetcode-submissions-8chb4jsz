class Solution {
private:
    vector<int> dirX = {-1,1,0,0};
    vector<int> dirY = {0,0,-1,1};
    bool check(int i, int j, int m, int n){
        return i >= 0 && j >= 0 && i < m && j < n;
    }
    bool dfsP(int i, int j, vector<vector<int>>& heights, vector<vector<bool>> &vis, int m, int n, vector<vector<int>> &pacific){
        if(pacific[i][j]) return true;
        else if(vis[i][j]) return false;
        vis[i][j] = true;
        bool ans = false;
        // cout<<"dfs pacific started "<<i<<" "<<j<<endl;
        for(int dir = 0; dir < 4; dir++){
            int ni = i + dirX[dir];
            int nj = j + dirY[dir];
            // cout<<ni<<"  "<<nj<<endl;
            if(check(ni, nj, m, n) && heights[ni][nj] <= heights[i][j]){
                // cout<<ni<<" pacific dfs "<<nj<<endl;
                ans = ans || dfsP(ni, nj, heights, vis, m, n, pacific);
            }
        }
        return pacific[i][j] = ans;
    }
    bool dfsA(int i, int j, vector<vector<int>>& heights, vector<vector<bool>> &vis, int m, int n, vector<vector<int>> &atlantic){
        if(atlantic[i][j]) return true;
        else if(vis[i][j]) return false;
        vis[i][j] = true;
        bool ans = false;
        for(int dir = 0; dir < 4; dir++){
            int ni = i + dirX[dir];
            int nj = j + dirY[dir];
            if(check(ni, nj, m, n) && heights[ni][nj] <= heights[i][j]){
                ans = ans || dfsA(ni, nj, heights, vis, m, n, atlantic);
            }
        }
        return atlantic[i][j] = ans;
    }
    bool dfs(int i, int j, vector<vector<int>>& heights, vector<vector<bool>> &vis, int m, int n, vector<vector<int>> &sea){
        if(sea[i][j]) return true;
        else if(vis[i][j]) return false;
        vis[i][j] = true;
        bool ans = false;
        for(int dir = 0; dir < 4; dir++){
            int ni = i + dirX[dir];
            int nj = j + dirY[dir];
            if(check(ni, nj, m, n) && heights[ni][nj] <= heights[i][j]){
                ans = ans || dfsA(ni, nj, heights, vis, m, n, sea);
            }
        }
        return sea[i][j] = ans;
    }
public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        int m = heights.size(), n = heights[0].size();
        vector<vector<int>> pacific(m, vector<int>(n, 0));
        vector<vector<int>> atlantic(m, vector<int>(n, 0));
        for(int i = 0; i < m; i++){
            pacific[i][0] = 1;
            atlantic[i][n-1] = 1;
        }
        for(int i = 0; i < n; i++){
            pacific[0][i] = 1;
            atlantic[m-1][i] = 1;
        }
        vector<vector<bool>> visP(m, vector<bool>(n,0));
        vector<vector<bool>> visA(m, vector<bool>(n,0));
        vector<vector<int>> ans;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!pacific[i][j]) {
                    // cout<<i<<" pacific "<<j<<endl;
                    dfs(i, j, heights, visP, m, n, pacific);
                }
                if(!atlantic[i][j]) {
                    // cout<<i<<" atlantic "<<j<<endl;
                    dfs(i, j, heights, visA, m, n, atlantic);
                }
                if(pacific[i][j] && atlantic[i][j]) ans.push_back({i,j});
            }
        }
        return ans;
    }
};