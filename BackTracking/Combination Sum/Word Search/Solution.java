class Solution {
    /**
     * Time: O(m*n*4^L)
     * Space: O(m*n)
     * where m is the number of rows and n is the number of columns in the board
     * and L is the length of the word
     * Approach: Backtracking
     * @param board The 2D board of characters
     * @param word The word to search for in the board
     * @return true if the word exists in the board, false otherwise
     */
    Set<Pair<Integer, Integer>> hSet = new HashSet<>();
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++) {
                if (checkBoard(board, i, j, word, 0) == true) return true;
            }

        return false;
    }
    public boolean checkBoard(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) return true;
        if (i<0 || i>=board.length
            || j<0 || j>=board[0].length
            || board[i][j] != word.charAt(index)
            || hSet.contains(new Pair<>(i,j))) return false;
        
        
        hSet.add(new Pair<>(i,j));

        boolean res = checkBoard(board, i+1, j, word, index+1)
            || checkBoard(board, i-1, j, word, index+1)
            || checkBoard(board, i, j+1, word, index+1)
            || checkBoard(board, i, j-1, word, index+1);
        hSet.remove(new Pair<>(i,j));
        return res;
        
    }
}