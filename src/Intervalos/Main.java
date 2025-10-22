import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        baseCase();
    }

    private static void baseCase () {
        Escalonamento e = new Escalonamento();
        Integer[] auxS = {4 ,6 ,13, 4, 2,6,7,9,1,3,9};
        Integer[] auxF = {8 ,7, 14, 5, 4, 9 ,10 ,11, 6, 13, 12};
        List<IntervaloObj> intervalos = new ArrayList<>();
        IntervaloObj temp;

        for (int i = 0; i < auxS.length; i++) {
            temp = new IntervaloObj(auxS[i], auxF[i], i+1);
            intervalos.add(temp);
        }
        
        System.out.println(e.SDM_guloso(intervalos));
    }
}
