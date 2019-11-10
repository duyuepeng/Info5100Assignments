package A8_5100.Calculator;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class Calculator extends JFrame {
    private JButton cancelButton;
    private JTextField outputText;
    private Map<String, JButton> numButtons = new HashMap<>();
    private Map<String, JButton> opButtons = new HashMap<>();
    private Double last = 0.0;
    private String lastCommand = "+";
    private boolean flag = false;
    private boolean done = false;


    public Calculator(String title) {
        super(title);
        JPanel main = new JPanel(), control = new JPanel();
        InputMap inputMap = main.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = main.getActionMap();
        this.outputText = new JTextField("0");
        this.outputText.setEditable(false);
        this.outputText.setHorizontalAlignment(JTextField.RIGHT);

        Action buttonAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String output = outputText.getText();
                String command = e.getActionCommand();
                if (command.equals("\n"))
                    command = "=";
                else if (command.equals("c"))
                    command = "C";
                if (output.equals("Error") && !command.equals("C")) {
                    appendDigit(command, output);
                    return;
                }
                if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
                    if (!flag)
                        outputText.setText(calculate(lastCommand));
                    lastCommand = command;
                    flag = true;
                } else if (command.equals("=") || command.equals("C")) {
                    if (command.equals("=")) {
                        if (!flag)
                            outputText.setText(calculate(lastCommand));
                        done = true;
                    } else
                        outputText.setText("0");
                    last = 0.0;
                    lastCommand = "+";
                } else {
                    appendDigit(command, output);
                }
            }
        };


        this.cancelButton = new JButton("C");
        inputMap.put(KeyStroke.getKeyStroke("C"), "C");
        actionMap.put("C", buttonAction);
        this.cancelButton.addActionListener(buttonAction);

        for (int i = 0; i < 10; i++) {
            JButton numButton = new JButton("" + i);
            numButton.addActionListener(buttonAction);
            inputMap.put(KeyStroke.getKeyStroke(String.valueOf(i)), String.valueOf(i));
            inputMap.put(KeyStroke.getKeyStroke("NUMPAD" + i), String.valueOf(i));
            actionMap.put(String.valueOf(i), buttonAction);

            numButtons.put("" + i, numButton);
        }


        String[][] keys = new String[][]{{"ADD"}, {"MINUS", "SUBTRACT"}, {"MULTIPLY"}, {"SLASH", "DIVIDE"}, {"ENTER"}, {"PERIOD", "DECIMAL"}};
        String[] operators = new String[]{"+", "-", "*", "/", "=", "."};
        for (int i = 0; i < operators.length; i++) {
            String s = operators[i];
            JButton opButton = new JButton(s);
            opButton.addActionListener(buttonAction);
            for (String key : keys[i]) {
                inputMap.put(KeyStroke.getKeyStroke(key), s);
            }
            actionMap.put(s, buttonAction);
            opButtons.put(s, opButton);
        }

        this.setLayout(new BorderLayout());
        this.add(this.outputText, BorderLayout.NORTH);


        main.setLayout(new BorderLayout());
        control.setLayout(new GridLayout(4, 4, 3, 3));
        main.add(this.cancelButton, BorderLayout.NORTH);
        this.add(main, BorderLayout.CENTER);
        main.add(control, BorderLayout.CENTER);
        for (String s : new String[]{"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"}) {
            JButton b = this.numButtons.get(s);
            if (b == null)
                b = this.opButtons.get(s);
            control.add(b);
        }

        this.pack();
    }

    private String calculate(String command) {
        Double current = Double.valueOf(this.outputText.getText());
        if (command.equals("+")) {
            return printDouble(current + last);
        } else if (command.equals("/")) {
            if (current == 0) {
                this.lastCommand = "+";
                this.last = 0.0;
                this.flag = true;
                return "Error";
            }
            return printDouble(last / current);
        } else if (command.equals("*")) {
            return printDouble(last * current);
        }
        return printDouble(last - current);
    }

    private static String printDouble(double d) {
        if (d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);
    }

    private void appendDigit(String command, String output) {
        try {
            if (this.flag) {
                this.last = Double.valueOf(output);
                output = "0";
                this.flag = false;
            } else if (this.done) {
                output = "0";
                this.done = false;
            }

            if (command.equals(".")) {
                if (output.contains("."))
                    return;
            } else {
                if (output.equals("0"))
                    output = "";
            }
            this.outputText.setText(output + command);
        } catch (NumberFormatException ignored) {

        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            final Calculator calculator = new Calculator("Calculator");
            calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            calculator.setVisible(true);
        });
    }
}
