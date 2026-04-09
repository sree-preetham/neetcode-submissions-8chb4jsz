class Solution {
public:
    bool check(int i, int j, int n){
        return i >=0 && j >=0 && i < n && j < n;
    }
    int swimInWater(vector<vector<int>>& grid) {
        priority_queue<tuple<int, int, int>, vector<tuple<int, int, int>>, greater<>> pq;
        int n = grid.size();
        vector<vector<int>> dist(n, vector<int>(n,INT_MAX));
        dist[0][0] = grid[0][0];
        pq.push({dist[0][0],0,0});
        vector<int> dirX = {-1,1,0,0};
        vector<int> dirY = {0,0,-1,1};
        while(!pq.empty()){
            auto [timeElapsed, x, y] = pq.top();
            pq.pop();
            for(int dir = 0; dir < 4; dir++){
                int nx = x + dirX[dir];
                int ny = y + dirY[dir];
                if(!check(nx,ny,n)) continue;
                int elevationRequired = max(timeElapsed, grid[nx][ny]);
                if(dist[nx][ny] > elevationRequired){
                    dist[nx][ny] = elevationRequired;
                    pq.push({elevationRequired, nx, ny});
                }
            }
        }
        return dist[n-1][n-1];
    }
};