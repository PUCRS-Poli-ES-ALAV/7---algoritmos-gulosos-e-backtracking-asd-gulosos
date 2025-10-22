package nRainhas;
import java.util.Stack;

public class Solve {
    public static Board run (Board board) {
        if (board.length % 2 != 0)
            return oddSolution(board);
        else return evenSolution(board);
    }

    private static Board oddSolution (Board board) {
        int j = 0;
        for (int i = 0; i < board.length; i++, j += 2) {
            if (j >= board.length) j -= board.length;
            board.board[i][j] = 'x';
        }
        return board;
    }

    private static Board evenSolution (Board board) {
        int n = board.length, currentRow = 0, currentCol = 0;
        var stack = new Stack<Integer>();

        while (true) {
            boolean found = false;

            // try lines
            for (int col = currentCol; col < n; col++) {
                board.board[currentRow][col] = 'x';

                if (board.checkPartialBoard()) {
                    // valid position
                    stack.push(col);
                    currentRow++;
                    currentCol = 0; // so that next line starts on column 0
                    found = true;
                    break;
                }

                // invalid position
                board.board[currentRow][col] = '.';
            }

            if (!found) {
                // no valid solution, backtrack
                if (stack.isEmpty())
                    // no remaining solution
                    break;
                
                // goes back to previous row
                currentRow--;
                int lastCol = stack.pop();
                board.board[currentRow][lastCol] = '.';
                currentCol = lastCol + 1;
            }

            if (stack.size() == n) {
                // found full solution
                return board;
            }
        }
        return board;
    }
}
