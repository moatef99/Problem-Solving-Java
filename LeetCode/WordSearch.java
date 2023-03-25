package LeetCode;

class WordSearch {

    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                boolean found = existHelper(0, row, column, word, board);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean existHelper(int currentWordIndex, int boardRowIndex, int boardColumnIndex, String word, char[][] board) {

        if (boardRowIndex < 0 || boardColumnIndex < 0 || currentWordIndex >= word.length() || boardRowIndex >= board.length)
            return false;
        if (boardColumnIndex >= board[0].length)
            return false;
        if (visited[boardRowIndex][boardColumnIndex] == true)
            return false;
        if (word.charAt(currentWordIndex) != board[boardRowIndex][boardColumnIndex])
            return false;

        visited[boardRowIndex][boardColumnIndex] = true;

        if (currentWordIndex == word.length() - 1)
            return true;


        boolean up = existHelper(currentWordIndex + 1, boardRowIndex, boardColumnIndex - 1, word, board);
        boolean down = existHelper(currentWordIndex + 1, boardRowIndex, boardColumnIndex + 1, word, board);

        boolean right = existHelper(currentWordIndex + 1, boardRowIndex + 1, boardColumnIndex, word, board);
        boolean left = existHelper(currentWordIndex + 1, boardRowIndex - 1, boardColumnIndex, word, board);
        if (up || down || right || left)
            return true;
        else {
            visited[boardRowIndex][boardColumnIndex] = false;
            return false;
        }
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();

        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(ws.exist(board, "SEE"));

        for (int i = 0; i < ws.visited.length; i++) {
            for (int j = 0; j < ws.visited[0].length; j++) {
                System.out.print(ws.visited[i][j] + " ");
            }
            System.out.println();
        }
    }
}