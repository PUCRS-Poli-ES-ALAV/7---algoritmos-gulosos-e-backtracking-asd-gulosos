package nRainhas;
import java.util.Arrays;

public class Board {
    public char[][] board;
    public int length;

    public Board(int n) {
        board = new char[n][n];
        length = n;
        for (char[] row : board)
            Arrays.fill(row, '.');
    }

    public boolean checkPartialBoard() {
        return checkPartialBoard(false);
    }
    // Gerado por ChatGPT, ajustado
    public boolean checkPartialBoard(boolean debug) {
        int n = board.length;
        // Verifica cada linha e coluna
        for (int i = 0; i < n; i++) {
            String rainhasLinha = "";
            String rainhasColuna = "";

            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'x')
                    rainhasLinha += board[i][j];
                if (board[j][i] == 'x')
                    rainhasColuna += board[j][i];

                // Verifica se há valores inválidos (diferentes de x ou .)
                if (board[i][j] != '.' && board[i][j] != 'x') {
                    if (debug) System.out.printf("Valor inválido em [%d][%d]\n", i, j);
                    return false;
                }
            }

            // Cada linha e cada coluna deve ter no máximo 1 rainha
            if (rainhasLinha.length() > 1 || rainhasColuna.length() > 1) {
                if (debug) System.out.println("Linha ou coluna com mais de uma rainha!");
                return false;
            }
        }

        // Verifica diagonais principais e secundárias
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'x') {
                    // Verifica diagonais ↘ e ↙
                    for (int k = 1; k < n; k++) {
                        if (i + k < n && j + k < n && board[i + k][j + k] == 'x'){
                            if (debug) System.out.printf("Diagonal inválida: [%d][%d]\n", i, j);
                            return false;
                        }
                        if (i + k < n && j - k >= 0 && board[i + k][j - k] == 'x'){
                            if (debug) System.out.printf("Diagonal inválida: [%d][%d]\n", i, j);
                            return false;
                        }
                        if (i - k >= 0 && j + k < n && board[i - k][j + k] == 'x'){
                            if (debug) System.out.printf("Diagonal inválida: [%d][%d]\n", i, j);
                            return false;
                        } 
                        if (i - k >= 0 && j - k >= 0 && board[i - k][j - k] == 'x') {
                            if (debug) System.out.printf("Diagonal inválida: [%d][%d]\n", i, j);
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean verifyBoard() {
        return verifyBoard(false);
    }
    // Gerado por ChatGPT, ajustado
    public boolean verifyBoard(boolean debug) {
        int n = board.length;

        // Verifica conflitos entre rainhas
        if (!checkPartialBoard()) return false;

        // Verifica quantidade de rainhas
        String totalRainhas = "";
        for (char[] linha : board)
            for (char valor : linha)
                if(valor == 'x')
                    totalRainhas += valor;
        if (!(totalRainhas.length() == n) && debug) System.out.println("Número de rainhas inválido!");
        return totalRainhas.length() == n;
    }

    public void print() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}