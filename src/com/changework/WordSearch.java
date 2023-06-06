package com.changework;

//boolean[][] used 记录这个位置是否使用过
//int x记录当前行
//int y记录当前列
//temp 记录当前匹配了几个word中的字符
//dfs中： 上下左右进行遍历，注意下返回条件和 行列 范围就可以了
public class WordSearch {

    boolean res = false;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new  boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == word.charAt(0) && !visited[i][j]){
                    dfs(i,j,1,word,board,visited);
                }
            }
        }
        return res;
    }

    private  void  dfs(int i,int j, int nextchar,String word,char[][] board,boolean[][] visited){
        int m = board.length;
        int n = board[0].length;
        if(nextchar == word.length() ){
            res = true;
            return;
        }
        visited[i][j] = true;

        if(res==false&&i-1>=0 && board[i-1][j]==word.charAt(nextchar)&&!visited[i-1][j]){
            dfs(i-1,j,nextchar+1,word,board,visited);
        }
        if(res==false&&i+1<m && board[i+1][j]==word.charAt(nextchar)&&!visited[i+1][j]){
            dfs(i+1,j,nextchar+1,word,board,visited);
        }
        if(res==false&&j-1>=0 && board[i][j-1]==word.charAt(nextchar)&&!visited[i][j-1]){
            dfs(i,j-1,nextchar+1,word,board,visited);
        }
        if(res==false&&j+1<n && board[i][j+1]==word.charAt(nextchar)&&!visited[i][j+1]){
            dfs(i,j+1,nextchar+1,word,board,visited);
        }
        visited[i][j] = false;

    }


    public static void main(String[] args) {

        // write your code here
        WordSearch wordSearch =  new WordSearch();
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean validparentheses = wordSearch.exist(board,"ABCCED");
        System.out.println(validparentheses);
    }
}
