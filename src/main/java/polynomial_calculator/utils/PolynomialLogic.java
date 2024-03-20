package polynomial_calculator.utils;

import polynomial_calculator.model.Monomial;
import polynomial_calculator.model.Polynomial;

import java.util.Map;

public class PolynomialLogic {
    public static Monomial getLeadingTerm(Polynomial p) {
        Monomial leadingTerm = new Monomial(0, 0);

        for(Map.Entry<Integer, Monomial> entry : p.getTerms().descendingMap().entrySet()) {
            if(entry.getValue().getCoeff().floatValue() != 0) {
                leadingTerm.setCoeff(entry.getValue().getCoeff());
                leadingTerm.setPower(entry.getValue().getPower());
                break;
            }
        }

        return leadingTerm;
    }

    public static int calculateDegree(Polynomial p) {
        return getLeadingTerm(p).getPower();
    }
}
