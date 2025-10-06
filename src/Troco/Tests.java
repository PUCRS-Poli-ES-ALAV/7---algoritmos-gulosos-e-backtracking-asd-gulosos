package Troco;
import java.util.List;
import java.util.Arrays;

public class Tests {
    private static final Troco t = new Troco();
    public static void main(String[] args) {
        System.out.println("testCase1: " + testCase1());
        System.out.println("testCase2: " + testCase2());
        System.out.println("testCase3: " + testCase3());
        System.out.println("testCase4: " + testCase4());
        System.out.println("testCase5: " + testCase5());

    }

    // standard test case
    private static boolean testCase1() {
        Integer[] valores = {5,5,5,10,25,25,50,50,100,100};
        List<Integer> moedas = Arrays.asList(valores);

        int troco = 150;

        return 2 == t.run(moedas, troco);
    }

    // not enough coins
    private static boolean testCase2() {
        Integer[] valores = {5,5,5,5,5};
        List<Integer> moedas = Arrays.asList(valores);

        int troco = 30;

        return 5 == t.run(moedas, troco);
    }

    // uses all coins
    private static boolean testCase3() {
        Integer[] valores = {5,10,25,50,100};
        List<Integer> moedas = Arrays.asList(valores);

        int troco = 190;

        return moedas.size() == t.run(moedas, troco);
    }

    // bad case: small value, big coins
    private static boolean testCase4() {
        Integer[] valores = {5, 100, 100, 100, 100, 100};
        List<Integer> moedas = Arrays.asList(valores);

        int troco = 5;

        return 1 == t.run(moedas, troco);
    }

    // test sorting
    private static boolean testCase5() {
        Integer[] valores = {5, 100, 50, 25, 10, 10, 5, 25};
        List<Integer> moedas = Arrays.asList(valores);

        int troco = 175;

        return 3 == t.run(moedas, troco);
    }
}