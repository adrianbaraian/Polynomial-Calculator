package polynomial_calculator.gui;

import polynomial_calculator.logic.Operations;
import polynomial_calculator.model.Monomial;
import polynomial_calculator.model.Polynomial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Objects;

public class Controller implements ActionListener {
    private View view;

    private Operations operations = new Operations();
    public Controller(View v) {
        this.view = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(Objects.equals(command, "COMPUTE")) {
            String sFirstPolynomial = String.valueOf(this.view.getFirstTextField().getText());
            String sSecondPolynomial = String.valueOf(this.view.getSecondTextField().getText());
            if(Polynomial.isValid(sFirstPolynomial) && Polynomial.isValid(sSecondPolynomial)) {
                String operation = String.valueOf(this.view.getOperationComboBox().getSelectedItem());

                Polynomial polynomialResult = new Polynomial();
                Polynomial p1 = new Polynomial();
                p1.parsePolynomial(sFirstPolynomial);
                Polynomial p2 = new Polynomial();
                p2.parsePolynomial(sSecondPolynomial);
                switch (operation) {
                    case "addition":
                        polynomialResult = operations.addition(p1, p2);
                        this.view.getResultPolynomialLabel().setText(polynomialResult.toString());
                        break;
                    case "subtraction":
                        polynomialResult = operations.subtraction(p1, p2);
                        this.view.getResultPolynomialLabel().setText(polynomialResult.toString());
                        break;
                    /*case "multiplication":
                        operations.multiplication();
                        break;
                    case "division":
                        operations.division();
                        break;
                    case "derivative":
                        operations.derivative();
                        break;
                    case "integration":
                        operations.integration();
                        break;*/
                    default:
                        break;
                }
            } else {
                System.out.println("Wrong input");
            }
        }
    }
}
