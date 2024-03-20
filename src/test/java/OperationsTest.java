import org.junit.jupiter.api.Test;
import polynomial_calculator.businesslogic.Operations;
import polynomial_calculator.model.Monomial;
import polynomial_calculator.model.Polynomial;
import polynomial_calculator.utils.PolynomialLogic;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class OperationsTest {
    @Test
    public void additionTest() {
        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(4, 5));
        p1.addMonomial(new Monomial(-3, 4));
        p1.addMonomial(new Monomial(1, 2));
        p1.addMonomial(new Monomial(-8, 1));
        p1.addMonomial(new Monomial(1, 0));

        Polynomial p2 = new Polynomial();
        p2.addMonomial(new Monomial(3, 4));
        p2.addMonomial(new Monomial(-1, 3));
        p2.addMonomial(new Monomial(1, 2));
        p2.addMonomial(new Monomial(2, 1));
        p2.addMonomial(new Monomial(-1, 0));

        assertEquals(Operations.addition(p1, p2).toString(), "4*x^5-1*x^3+2*x^2-6*x^1");
    }

    @Test
    public void subtractionTest() {
        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(4, 5));
        p1.addMonomial(new Monomial(-3, 4));
        p1.addMonomial(new Monomial(1, 2));
        p1.addMonomial(new Monomial(-8, 1));
        p1.addMonomial(new Monomial(1, 0));

        Polynomial p2 = new Polynomial();
        p2.addMonomial(new Monomial(3, 4));
        p2.addMonomial(new Monomial(-1, 3));
        p2.addMonomial(new Monomial(1, 2));
        p2.addMonomial(new Monomial(2, 1));
        p2.addMonomial(new Monomial(-1, 0));

        assertEquals(Operations.subtraction(p1, p2).toString(), "4*x^5-6*x^4+1*x^3-10*x^1+2");
    }

    @Test
    public void multiplicationTest() {
        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(3, 2));
        p1.addMonomial(new Monomial(-1, 1));
        p1.addMonomial(new Monomial(1, 0));

        Polynomial p2 = new Polynomial();
        p2.addMonomial(new Monomial(1, 1));
        p2.addMonomial(new Monomial(-2, 0));

        assertEquals(Operations.multiplication(p1, p2).toString(), "3*x^3-7*x^2+3*x^1-2");
    }

    @Test
    public void divisionTest() {
        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(1, 3));
        p1.addMonomial(new Monomial(-2, 2));
        p1.addMonomial(new Monomial(6, 1));
        p1.addMonomial(new Monomial(-5, 0));

        p1.setDegree(PolynomialLogic.calculateDegree(p1));

        Polynomial p2 = new Polynomial();
        p2.addMonomial(new Monomial(1, 2));
        p2.addMonomial(new Monomial(-1, 0));

        p2.setDegree(PolynomialLogic.calculateDegree(p2));

        Polynomial[] res = Operations.division(p1, p2);

        Polynomial Q = new Polynomial();
        Q.addMonomial(new Monomial(1, 1));
        Q.addMonomial(new Monomial(-2, 0));

        Polynomial R = new Polynomial();
        R.addMonomial(new Monomial(7, 1));
        R.addMonomial(new Monomial(-7, 0));

        assertEquals(res[0].toString(), Q.toString());
        assertEquals(res[1].toString(), R.toString());
    }

    @Test
    public void derivativeTest() {
        Polynomial p = new Polynomial();

        p.addMonomial(new Monomial(1, 3));
        p.addMonomial(new Monomial(-2, 2));
        p.addMonomial(new Monomial(6, 1));
        p.addMonomial(new Monomial(-5, 0));

        assertEquals(Operations.derivative(p).toString(), "3*x^2-4*x^1+6");
    }

    @Test
    public void integrationTest() {
        Polynomial p = new Polynomial();

        p.addMonomial(new Monomial(1, 3));
        p.addMonomial(new Monomial(4, 2));
        p.addMonomial(new Monomial(5, 0));

        Polynomial res = new Polynomial();
        res.addMonomial(new Monomial(1.0/4, 4));
        res.addMonomial(new Monomial(4.0/3, 3));
        res.addMonomial(new Monomial(5, 1));

        assertEquals(Operations.integration(p).toString(), res.toString());
    }
}
