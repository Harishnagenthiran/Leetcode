class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count =0;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    trav(i,j,grid);
                }
            }
        }
        return count;
    }
    private void trav(int row,int col,char[][]grid){
         int m = grid.length;
         int n = grid[0].length;
         int dx[]={-1,0,1,0};
         int dy[]= {0,-1,0,1};
         if(row>=0 && row<m && col>=0 && col<n && grid[row][col] =='1'){
            grid[row][col]='#';
            for(int i =0;i<4;i++)trav(row+dx[i],col+dy[i],grid);
         }
    }
}