class Solution {
      int m,n;
        int dir[][]={{1,0},{0,1},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
         m=board.length;
         n=board[0].length;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;  
    }
    private boolean dfs(char[][]board,String word,int row,int col,int index){
        if(index==word.length())return true;
        if(row<0||row>=m||col<0||col>=n)return false;
        if(board[row][col]!=word.charAt(index))return false;
        char original = board[row][col];
        board[row][col]='#';
        for(int d[]:dir){
            int newRow = row+d[0];
            int newCol = col+d[1];
           if(dfs(board,word,newRow,newCol,index+1))return true;
        }
           board[row][col]=original;
           return false;
        }
}