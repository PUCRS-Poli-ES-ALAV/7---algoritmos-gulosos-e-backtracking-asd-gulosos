import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var sc = new Scanner (System.in);

        var t = new Troco();

        Integer valor, tamanho, moeda, r;
        ArrayList<Integer> moedas = new ArrayList<>();
        while (true) {
            // obtem valor do troco
            System.out.print("Valor do troco em centavos (-1 para sair): ");
            valor = sc.nextInt();
            if (valor < 0) break; // fim de execução

            // quantidade de moedas para loop
            System.out.print("Quantidade de moedas: ");
            tamanho = sc.nextInt();

            // adiciona moedas ao arraylist
            for (int i = 0; i < tamanho; i++) {
                System.out.printf("Forneça o valor da moeda (%d/%d): ", i, tamanho);
                moeda = sc.nextInt();
                moedas.add(moeda);
            }

            // executa algoritmo guloso
            r = t.run(moedas, valor);

            System.out.println("Quantidade de moedas: " + r);

            // limpa arraylist para nova iteração
            moedas.clear();
        }

        sc.close();
    }
}
