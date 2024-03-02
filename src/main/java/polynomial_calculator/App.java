package polynomial_calculator;

import polynomial_calculator.gui.View;
import polynomial_calculator.model.Monomial;
import polynomial_calculator.model.Polynomial;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.TreeMap;

public class App {

    public App() {
        JFrame frame = new View("Polynomial Calculator");
        //frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new App();

        //System.out.println(Polynomial.isValid("3x^2+5x"));
    }
}
