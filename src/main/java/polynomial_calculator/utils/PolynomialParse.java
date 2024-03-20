package polynomial_calculator.utils;

import polynomial_calculator.model.Monomial;
import polynomial_calculator.model.Polynomial;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialParse {
    public static void parsePolynomial(Polynomial p, String sPolynomial) {
        String patternRegex = "(([+-]?\\s*\\d*)?\\*?x(\\^(\\d+))?\\s*)|([+-]?\\s*\\d+\\s*)?"; // Monomial pattern + FreeTerm
        Pattern pattern = Pattern.compile(patternRegex);

        Matcher matcher = pattern.matcher(sPolynomial);
        while(matcher.find()) {
            String sCoeff = matcher.group(2);
            String sPower = matcher.group(4);


            if(sCoeff != null) {
                Number coeff = 0;
                int power = 0;
                if(!Objects.equals(sCoeff, "-") && !Objects.equals(sCoeff, "+")) {
                    coeff = (sCoeff.isEmpty()) ? 1 : Integer.parseInt(sCoeff);
                } else if(Objects.equals(sCoeff, "-")) {
                    coeff = -1;
                } else if(Objects.equals(sCoeff, "+")) {
                    coeff = 1;
                }

                power = (sPower == null) ? 1 : Integer.parseInt(sPower);
                p.addMonomial(new Monomial(coeff, power));
            } else {
                if(matcher.group(5) != null) {
                    int freeTerm = Integer.parseInt(matcher.group(5));
                    p.addMonomial(new Monomial(freeTerm, 0));
                }
            }

        }

        p.setDegree(PolynomialLogic.calculateDegree(p));
    }
}
