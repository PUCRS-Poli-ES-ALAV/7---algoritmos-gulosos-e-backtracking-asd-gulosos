import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Escalonamento {
    public Escalonamento(){}

    public List<IntervaloObj> SDM_guloso (List<IntervaloObj> intervalos) {
        intervalos = ordenarPorFim(intervalos);
        List<IntervaloObj> X = new ArrayList<>();
        int k = Integer.MIN_VALUE;
        for (IntervaloObj i : intervalos) {
            if (i.s > k) {
                X.add(i);
                k = i.f;
            }
        }
        return X;
    }

    private List<IntervaloObj> ordenarPorFim (List<IntervaloObj> intervalos) {
        List<IntervaloObj> ordenado = new ArrayList<>(intervalos);
        ordenado.sort(Comparator.comparingInt(i -> i.f));
        return ordenado;
    }
}
