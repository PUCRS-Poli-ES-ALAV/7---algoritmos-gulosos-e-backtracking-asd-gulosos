package Troco;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Troco {
    public Troco(){}

    // Recebe ArrayList de moedas disponiveis e valor do troco (em centavos)
    // Retorna arraylist de moedas para valor fornecido
    public int run(List<Integer> moedas, int valor) {
        // ordena moedas
        Collections.sort(moedas);

        int current, i = moedas.size();
        List<Integer> r = new ArrayList<>();
        while (--i >= 0 && valor > 0) {
            current = moedas.get(i);
            if (current <= valor) {
                valor -= current;
                r.add(current);
            }
        }
        // System.out.println(r);
        if (valor > 0) System.out.println("Faltam " + valor + " centavos de troco");
        return r.size();
    }
}
