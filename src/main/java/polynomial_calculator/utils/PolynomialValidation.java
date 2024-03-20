package polynomial_calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialValidation {

    public static boolean isValid(String sPolynomial) {
        String patternRegex = "^\\s*([+-]?\\s*\\d*\\*?x(\\^\\d+)?\\s*)+[+-]?\\s*\\d*\\s*$";
        Pattern pattern = Pattern.compile(patternRegex);

        Matcher matcher = pattern.matcher(sPolynomial);
        return matcher.matches();
    }
}
