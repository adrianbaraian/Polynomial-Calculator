package polynomial_calculator.gui;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    private JPanel contentPane;
    private JPanel resultPanel;
    private JLabel resultTextLabel;
    private JLabel resultPolynomialLabel;
    private JPanel calculationsPanel;
    private JLabel firstLabel;
    private JLabel secondLabel;
    private JTextField firstTextField;
    private JTextField secondTextField;
    private JLabel selectOpLabel;
    private JComboBox<String> operationComboBox;
    private JButton computeButton;

    Controller controller = new Controller(this);
    public View(String name) {
        super(name);
        this.prepareGUI();
    }

    public void prepareGUI() {
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.contentPane = new JPanel(new GridLayout(2, 2));
        this.contentPane.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        this.prepareCalculationPanel();
        this.prepareResultPanel();
        this.setContentPane(this.contentPane);
    }

    public void prepareResultPanel() {
        this.resultPanel = new JPanel();
        this.resultPanel.setLayout(new GridLayout(1, 2));
        this.resultTextLabel = new JLabel("Result", JLabel.CENTER);
        this.resultPolynomialLabel = new JLabel("", JLabel.CENTER);
        this.resultPanel.add(this.resultTextLabel);
        this.resultPanel.add(this.resultPolynomialLabel);
        this.contentPane.add(this.resultPanel);
    }

    public void prepareCalculationPanel() {
        this.calculationsPanel = new JPanel();
        this.calculationsPanel.setLayout(new GridLayout(5, 2));
        this.firstLabel = new JLabel("First Polynomial", JLabel.CENTER);
        this.secondLabel = new JLabel("Second Polynomial", JLabel.CENTER);
        this.selectOpLabel = new JLabel("Select Operation", JLabel.CENTER);
        this.firstTextField = new JTextField();
        this.secondTextField = new JTextField();
        String [] operations = {"addition", "subtraction", "division", "multiplication", "derivative", "integration"};
        this.operationComboBox = new JComboBox<String>(operations);
        this.computeButton = new JButton("Compute");
        this.computeButton.setActionCommand("COMPUTE");
        this.computeButton.addActionListener(this.controller);
        this.calculationsPanel.add(this.firstLabel);
        this.calculationsPanel.add(this.firstTextField);
        this.calculationsPanel.add(this.secondLabel);
        this.calculationsPanel.add(this.secondTextField);
        this.calculationsPanel.add(this.selectOpLabel);
        this.calculationsPanel.add(this.operationComboBox);
        this.calculationsPanel.add(this.computeButton);
        this.contentPane.add(calculationsPanel);
    }

    public JTextField getFirstTextField() {
        return firstTextField;
    }

    public JTextField getSecondTextField() {
        return secondTextField;
    }

    public JComboBox<String> getOperationComboBox() {
        return operationComboBox;
    }

    public JLabel getResultPolynomialLabel() {
        return resultPolynomialLabel;
    }
}
