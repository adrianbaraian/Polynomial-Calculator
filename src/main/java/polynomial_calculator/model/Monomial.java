package polynomial_calculator.model;

public class Monomial {
    private Number coeff;
    private int power;

    public Monomial(Number coeff, int power) {
        this.coeff = coeff;
        this.power = power;
    }

    public Number getCoeff() {
        return coeff;
    }

    public int getPower() {
        return power;
    }

    public void setCoeff(Number coeff) {
        this.coeff = coeff;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
