package polynomial_calculator.logic;

import polynomial_calculator.model.Monomial;
import polynomial_calculator.model.Polynomial;

import java.util.Map;

public class Operations {
    public Polynomial addition(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();

        if(p1.getTerms().size() >= p2.getTerms().size()) {
            for (Map.Entry<Integer, Monomial> entry : p1.getTerms().entrySet()) {
                result.addMonomial(new Monomial(entry.getValue().getCoeff() + ((p2.getTerms().get(entry.getKey()) != null) ? p2.getTerms().get(entry.getKey()).getCoeff() : 0) , entry.getValue().getPower()));
            }
        } else {
            for (Map.Entry<Integer, Monomial> entry : p2.getTerms().entrySet()) {
                result.addMonomial(new Monomial(entry.getValue().getCoeff() + ((p1.getTerms().get(entry.getKey()) != null) ? p1.getTerms().get(entry.getKey()).getCoeff() : 0) , entry.getValue().getPower()));
            }
        }


        return result;
    }

    public Polynomial subtraction(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();

        if(p1.getTerms().size() >= p2.getTerms().size()) {
            for (Map.Entry<Integer, Monomial> entry : p1.getTerms().entrySet()) {
                result.addMonomial(new Monomial(entry.getValue().getCoeff() - ((p2.getTerms().get(entry.getKey()) != null) ? p2.getTerms().get(entry.getKey()).getCoeff() : 0) , entry.getValue().getPower()));
            }
        } else {
            for (Map.Entry<Integer, Monomial> entry : p2.getTerms().entrySet()) {
                result.addMonomial(new Monomial(entry.getValue().getCoeff() - ((p1.getTerms().get(entry.getKey()) != null) ? p1.getTerms().get(entry.getKey()).getCoeff() : 0) , entry.getValue().getPower()));
            }
        }


        return result;
    }

   /* public void division(Polynomial p1, Polynomial p2) {

    }

    public void multiplication(Polynomial p1, Polynomial p2) {

    }

    public void derivative(Polynomial p1, Polynomial p2) {

    }

    public void integration(Polynomial p1, Polynomial p2) {

    }*/
}
