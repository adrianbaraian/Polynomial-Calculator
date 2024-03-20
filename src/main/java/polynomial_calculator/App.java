package polynomial_calculator;

import polynomial_calculator.gui.View;


import javax.swing.*;


public class App {

    public App() {
        JFrame frame = new View("Polynomial Calculator");
        //frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new App();

    }
}
