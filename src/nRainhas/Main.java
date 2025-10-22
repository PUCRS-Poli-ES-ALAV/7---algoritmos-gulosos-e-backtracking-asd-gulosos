package nRainhas;
import java.util.Scanner;

public class Main {
    private static Board board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Forneça o número de rainhas: ");
        int n = sc.nextInt();
        sc.close();

        board = new Board(n);

        Solve.run(board);

        board.print();
        boolean validate = board.verifyBoard(true);
        if (validate) System.out.println("Solução correta!");
        else System.out.println("Solução incorreta!");
    }
}
