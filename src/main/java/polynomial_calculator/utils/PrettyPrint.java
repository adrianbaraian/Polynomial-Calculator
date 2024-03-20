package polynomial_calculator.utils;

public class PrettyPrint {
    public static Number prettyPrint(Number n) {
        if(n.floatValue() == n.intValue())
            return n.intValue();

        return n.floatValue();
    }
}
