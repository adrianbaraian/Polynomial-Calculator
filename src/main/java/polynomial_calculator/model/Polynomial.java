package polynomial_calculator.model;

import polynomial_calculator.utils.PolynomialLogic;
import polynomial_calculator.utils.PrettyPrint;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Polynomial {
    private TreeMap<Integer, Monomial> terms;
    private int degree;

    public Polynomial() {
        this.terms = new TreeMap<>();
        this.degree = 0;
    }
    public void addMonomial(Monomial monomial) {
        this.terms.put(monomial.getPower(), monomial);
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public TreeMap<Integer, Monomial> getTerms() {
        return terms;
    }

    @Override
    public String toString() {
        String result = "";
        for(Map.Entry<Integer, Monomial> entry : this.terms.descendingMap().entrySet()) {
            if(entry.getValue().getPower() != 0) {
                if (entry.getValue().getCoeff().floatValue() > 0) {
                    if (entry.getValue().getPower() != PolynomialLogic.getLeadingTerm(this).getPower())
                        result = result + "+" + PrettyPrint.prettyPrint(entry.getValue().getCoeff()) + "*x^" + entry.getValue().getPower();
                    else {
                        result = result + PrettyPrint.prettyPrint(entry.getValue().getCoeff()) + "*x^" + entry.getValue().getPower();
                    }
                } else if(entry.getValue().getCoeff().floatValue() < 0){
                    result = result + PrettyPrint.prettyPrint(entry.getValue().getCoeff()) + "*x^" + entry.getValue().getPower();
                }
            } else {
                if(entry.getValue().getCoeff().floatValue() != 0)
                    result = result + ((entry.getValue().getCoeff().floatValue() > 0) ? ("+" + PrettyPrint.prettyPrint(entry.getValue().getCoeff())) : (PrettyPrint.prettyPrint(entry.getValue().getCoeff())));

            }
        }

        if(Objects.equals(result, "") && !this.terms.isEmpty()) result = "0";
        return result;
    }
}
