package polynomial_calculator.model;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private TreeMap<Integer, Monomial> terms;

    public Polynomial() {
        this.terms = new TreeMap<>();
    }

    public void addMonomial(Monomial monomial) {
        this.terms.put(monomial.getPower(), monomial);
    }

    public static boolean isValid(String sPolynomial) {
        String patternRegex = "^\\s*([+-]?\\s*\\d*\\*?x(\\^\\d+)?\\s*)+[+-]?\\s*\\d*\\s*$";
        Pattern pattern = Pattern.compile(patternRegex);

        Matcher matcher = pattern.matcher(sPolynomial);
        return matcher.matches();
    }

    public void parsePolynomial(String sPolynomial) {
        String patternRegex = "([+-]?\\s*\\d*)\\*?x(\\^(\\d+))?\\s*|([+-]?\\s*\\d+)\\s*";
        Pattern pattern = Pattern.compile(patternRegex);

        Matcher matcher = pattern.matcher(sPolynomial);
        while(matcher.find()) {
            String matchedMonomial = matcher.group().trim();
            String sCoeff = matcher.group(1);
            String sPower = matcher.group(3);

            if(sCoeff != null) {
                Integer coeff = (sCoeff.isEmpty()) ? 1 : Integer.parseInt(sCoeff);
                Integer power = (sPower == null) ? 1 : Integer.parseInt(sPower);
                this.addMonomial(new Monomial(coeff, power));
            } else {
                int freeTerm = Integer.parseInt(matcher.group(4));
                this.addMonomial(new Monomial(freeTerm, 0));
            }


        }
    }

    public TreeMap<Integer, Monomial> getTerms() {
        return terms;
    }

    @Override
    public String toString() {
        String result = "";
        for(Map.Entry<Integer, Monomial> entry : this.terms.descendingMap().entrySet()) {
            if(entry.getValue().getPower() != 0) {
                if (entry.getValue().getCoeff() > 0 ) {
                    result = result + "+" + entry.getValue().getCoeff() + "*x^" + entry.getValue().getPower();
                } else {
                    result = result + entry.getValue().getCoeff() + "*x^" + entry.getValue().getPower();
                }
            } else {
                result = result + ((entry.getValue().getCoeff() > 0) ? ("+" + entry.getValue().getCoeff()) : ("-" + entry.getValue().getCoeff()));
            }
        }

        return result;
    }
}
