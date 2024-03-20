package polynomial_calculator.gui;

import polynomial_calculator.businesslogic.Operations;
import polynomial_calculator.utils.PolynomialParse;
import polynomial_calculator.utils.PolynomialValidation;
import polynomial_calculator.model.Polynomial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Controller implements ActionListener {
    private View view;
    public Controller(View v) {
        this.view = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(Objects.equals(command, "COMPUTE")) {
            String sFirstPolynomial = String.valueOf(this.view.getFirstTextField().getText());
            String sSecondPolynomial = String.valueOf(this.view.getSecondTextField().getText());
            if(PolynomialValidation.isValid(sFirstPolynomial) && PolynomialValidation.isValid(sSecondPolynomial)) {
                view.errorLabel.setVisible(false);
                String operation = String.valueOf(this.view.getOperationComboBox().getSelectedItem());

                Polynomial polynomialResult;
                Polynomial[] divResult;
                Polynomial p1 = new Polynomial();
                PolynomialParse.parsePolynomial(p1, sFirstPolynomial);
                Polynomial p2 = new Polynomial();
                PolynomialParse.parsePolynomial(p2, sSecondPolynomial);
                switch (operation) {
                    case "addition":
                        polynomialResult = Operations.addition(p1, p2);
                        this.view.getResultPolynomialLabel().setText(polynomialResult.toString());
                        break;
                    case "subtraction":
                        polynomialResult = Operations.subtraction(p1, p2);
                        this.view.getResultPolynomialLabel().setText(polynomialResult.toString());
                        break;
                    case "multiplication":
                        polynomialResult = Operations.multiplication(p1, p2);
                        this.view.getResultPolynomialLabel().setText(polynomialResult.toString());
                        break;
                    case "division":
                        try {
                            divResult = Operations.division(p1, p2);
                            this.view.getResultPolynomialLabel().setText("Q: " + divResult[0].toString() + ";       R: " + divResult[1].toString());
                        } catch (IllegalArgumentException exc) {
                            view.errorLabel.setText("Division by zero!!!");
                            view.errorLabel.setVisible(true);
                        }
                        break;
                    case "derivative":
                        polynomialResult = Operations.derivative(p1);
                        this.view.getResultPolynomialLabel().setText(polynomialResult.toString());
                        break;
                    case "integration":
                        polynomialResult = Operations.integration(p1);
                        this.view.getResultPolynomialLabel().setText(polynomialResult.toString());
                        break;
                    default:
                        break;
                }
            } else {
                view.errorLabel.setText("<html>" + "WRONG INPUT! Enter something like this: +-(coeff)*x^(power) +- free term. Make sure to fill both inputs " + "</html>");
                view.errorLabel.setVisible(true);
            }
        }
    }
}
