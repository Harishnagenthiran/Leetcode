class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m= mat.length;
        int n=mat[0].length;
        int[][] dist= new int[m][n];
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                dist[i][j]=-1;
            }
        }
        Queue <int[]> q = new LinkedList<>();
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(mat[i][j]==0){
                    dist[i][j]=0;
                    q.offer(new int[]{i,j});
                }
            }
        }
        int dirr[][]={{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int curr[]=q.poll();
            int row = curr[0];
            int col = curr[1];
            for(int dir[]:dirr){
                int newRow = row+dir[0];
                int newCol =  col+dir[1];
            
            if(newRow>=0 && newCol>=0 && newRow<m && newCol<n && dist[newRow][newCol]==-1){
                dist[newRow][newCol]=dist[row][col]+1;
                q.offer(new int[]{newRow,newCol});
            }
        }
        }
        return dist;
        
    }
}