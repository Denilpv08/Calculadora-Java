import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorVS extends JFrame {
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultLabel;

    public CalculatorVS() {
        setTitle("Calculadora");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(new BorderLayout(10, 10));

        // Crear paneles
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Crear título
        JLabel titleLabel = new JLabel("Calculadora");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);

        // Crear componentes de entrada
        JLabel num1Label = new JLabel("Número 1:");
        num1Field = new JTextField();
        JLabel num2Label = new JLabel("Número 2:");
        num2Field = new JTextField();

        // Añadir componentes de entrada al panel de entrada
        inputPanel.add(num1Label);
        inputPanel.add(num1Field);
        inputPanel.add(num2Label);
        inputPanel.add(num2Field);

        // Crear botones de operación
        JButton addButton = new JButton("Sumar");
        JButton subtractButton = new JButton("Restar");
        JButton multiplyButton = new JButton("Multiplicar");
        JButton divideButton = new JButton("Dividir");
        JButton clearButton = new JButton("Borrar");

        // Añadir botones al panel de botones
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(clearButton);

        // Crear y añadir la etiqueta de resultado
        resultLabel = new JLabel("Resultado:");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultPanel.add(resultLabel);

        // Añadir paneles al frame
        add(titlePanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);
        add(resultPanel, BorderLayout.SOUTH);

        // Añadir ActionListeners a los botones
        addButton.addActionListener(new OperationActionListener(new AdditionFactory()));
        subtractButton.addActionListener(new OperationActionListener(new SubtractionFactory()));
        multiplyButton.addActionListener(new OperationActionListener(new MultiplicationFactory()));
        divideButton.addActionListener(new OperationActionListener(new DivisionFactory()));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
    }

    private class OperationActionListener implements ActionListener {
        private OperationFactory factory;

        public OperationActionListener(OperationFactory factory) {
            this.factory = factory;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                Operation operation = factory.createOperation(num1, num2);
                double result = operation.calculate();
                resultLabel.setText("Resultado: " + result);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese números válidos.");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    private void clearFields() {
        num1Field.setText("");
        num2Field.setText("");
        resultLabel.setText("Resultado:");
    }
}

