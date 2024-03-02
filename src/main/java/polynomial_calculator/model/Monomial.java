package polynomial_calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Monomial {
    private int coeff;
    private int power;

    public Monomial(int coeff, int power) {
        this.coeff = coeff;
        this.power = power;
    }

    public int getCoeff() {
        return coeff;
    }

    public int getPower() {
        return power;
    }
}
