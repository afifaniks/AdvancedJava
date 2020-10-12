package lambda;

import java.util.function.Function;

/**
 * Project: AdvancedJava
 * Author: AFIF AL MAMUN
 * Created in 10/12/20
 * Web: https://afifaniks.me
 */
class Calc {
    public double apply(double a, Function<Double, Double> function) {
        return function.apply(a);
    }
}
public class MethodReference {
    public static void main(String[] args) {
        System.out.println(new Calc().apply(30, Math::sin));
        System.out.println(new Calc().apply(30.53, Math::ceil));
        System.out.println(new Calc().apply(30, Math::cos));
    }
}
