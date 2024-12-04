N-Queen Problem:

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j]='.';
            }
        }
        backtrack(solution, board,0,n);
        return solution;
    }
    private void backtrack(List<List<String>> solution,char[][] board,int row, int n){
        if(row == n){
            solution.add(construct(board));
            return;
        }
        for(int col =0; col<n; col++){
            if(isSafe(board, row, col, n)){
                board[row][col]='Q';
                backtrack(solution, board, row+1,n);
                board[row][col]= '.';
            }
        }

    }
    private boolean isSafe(char[][] board, int row, int col, int n){
        for(int i =0; i<row; i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        for(int i = row-1, j = col-1; i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        for(int i = row-1, j = col+1; i>=0 && j<n; i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    private List<String> construct(char[][] board){
        List<String> solutions = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            solutions.add(new String(board[i]));
        }
        return solutions;
    }
}
