class Solution {
    public boolean issafe(char[][] board , int row , int col , int n ){

        // horizontaly 
        for(int i = 0 ; i<n ; i++){
            if(board[row][i]=='Q'){
                return false;
            }
        }

        //vertically 
        for(int i = 0 ; i<n ; i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        // left diagonally 
        for(int i=row,j=col ;i>=0&&j>=0 ; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //right vertically
        for(int i=row,j=col ;i>=0&&j<n ; i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;

    }

    public void nQueens(char[][] board , List<List<String>> ans, int n , int row){
        if (row == n) {
            List<String> temp = new ArrayList<>();

            for (int i = 0; i < board.length; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }
        for(int j =0 ; j<n;j++){
            if(issafe(board ,row , j , n)){
                board[row][j]='Q';
                nQueens(board , ans , n , row+1);
                board[row][j]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();;
        int row =0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        nQueens(board , ans , n , row);
        return ans;
    }
}