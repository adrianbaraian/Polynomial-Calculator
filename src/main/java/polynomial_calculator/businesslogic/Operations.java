package polynomial_calculator.businesslogic;

import polynomial_calculator.model.Monomial;
import polynomial_calculator.model.Polynomial;
import polynomial_calculator.utils.PolynomialLogic;
import polynomial_calculator.utils.PolynomialParse;

import java.util.Map;

public class Operations {
    public static Polynomial addition(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Monomial> entry : p1.getTerms().entrySet()) {
            result.addMonomial(new Monomial(entry.getValue().getCoeff().floatValue() + ((p2.getTerms().get(entry.getKey()) != null) ? p2.getTerms().get(entry.getKey()).getCoeff().floatValue() : 0), entry.getValue().getPower()));
        }
        for (Map.Entry<Integer, Monomial> entry : p2.getTerms().entrySet()) {
            if (!result.getTerms().containsKey(entry.getValue().getPower())) {
                result.addMonomial(new Monomial(entry.getValue().getCoeff().floatValue(), entry.getValue().getPower()));
            }
        }

        result.setDegree(PolynomialLogic.calculateDegree(result));
        return result;
    }

    public static Polynomial subtraction(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Monomial> entry : p1.getTerms().entrySet()) {
            result.addMonomial(new Monomial(entry.getValue().getCoeff().floatValue() - ((p2.getTerms().get(entry.getKey()) != null) ? p2.getTerms().get(entry.getKey()).getCoeff().floatValue() : 0), entry.getValue().getPower()));
        }
        for (Map.Entry<Integer, Monomial> entry : p2.getTerms().entrySet()) {
            if (!result.getTerms().containsKey(entry.getValue().getPower())) {
                result.addMonomial(new Monomial((-1) * entry.getValue().getCoeff().floatValue(), entry.getValue().getPower()));
            }
        }

        result.setDegree(PolynomialLogic.calculateDegree(result));
        return result;
    }

    public static Polynomial[] division(Polynomial p1, Polynomial p2) {
        Polynomial[] result = new Polynomial[2];
        result[0] = new Polynomial();
        result[1] = new Polynomial();

        if (PolynomialLogic.calculateDegree(p2) == 0 && PolynomialLogic.getLeadingTerm(p2).getCoeff().floatValue() == 0) {
            throw new IllegalArgumentException("Division by ZERO!!!");
        }

        Polynomial Q = new Polynomial();
        Polynomial R = new Polynomial();

        PolynomialParse.parsePolynomial(R, p1.toString());


        while (R.getDegree() >= p2.getDegree() && R.getDegree() > 0){
            Monomial t = new Monomial((PolynomialLogic.getLeadingTerm(R).getCoeff().floatValue() / PolynomialLogic.getLeadingTerm(p2).getCoeff().floatValue()), PolynomialLogic.getLeadingTerm(R).getPower() - PolynomialLogic.getLeadingTerm(p2).getPower());
            Polynomial tP = new Polynomial();
            tP.addMonomial(t);
            Q.addMonomial(t);
            R = subtraction(R, multiplication(tP, p2));
        }

        Q.setDegree(PolynomialLogic.calculateDegree(Q));
        R.setDegree(PolynomialLogic.calculateDegree(R));

        result[0] = Q;
        result[1] = R;

        return result;
    }

    public static Polynomial multiplication(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Monomial> entry1 : p1.getTerms().descendingMap().entrySet()) {
            for (Map.Entry<Integer, Monomial> entry2 : p2.getTerms().descendingMap().entrySet()) {
                if (result.getTerms().containsKey(entry1.getValue().getPower() + entry2.getValue().getPower())) {
                    result.addMonomial(new Monomial(entry1.getValue().getCoeff().floatValue() * entry2.getValue().getCoeff().floatValue() + result.getTerms().get(entry1.getValue().getPower() + entry2.getValue().getPower()).getCoeff().floatValue(), entry1.getValue().getPower() + entry2.getValue().getPower()));
                } else {
                    result.addMonomial(new Monomial(entry1.getValue().getCoeff().floatValue() * entry2.getValue().getCoeff().floatValue(), entry1.getValue().getPower() + entry2.getValue().getPower()));
                }
            }
        }

        result.setDegree(PolynomialLogic.calculateDegree(result));
        return result;
    }

    public static Polynomial derivative(Polynomial p) {
        Polynomial result = new Polynomial();
        for(Map.Entry<Integer, Monomial> entry : p.getTerms().descendingMap().entrySet()) {
            result.addMonomial(new Monomial(entry.getValue().getCoeff().floatValue() * entry.getValue().getPower(), entry.getValue().getPower() - 1));
        }

        result.setDegree(PolynomialLogic.calculateDegree(result));
        return result;
    }

    public static Polynomial integration(Polynomial p) {
        Polynomial result = new Polynomial();
        for(Map.Entry<Integer, Monomial> entry : p.getTerms().descendingMap().entrySet()) {
            result.addMonomial(new Monomial(entry.getValue().getCoeff().floatValue() / (entry.getValue().getPower() + 1), entry.getValue().getPower() + 1));
        }

        result.setDegree(PolynomialLogic.calculateDegree(result));
        return result;
    }
}
