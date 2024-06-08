import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private JButton[] numButtons;

    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton;
    private JPanel panel;
    private Font myFont = new Font("Ink Free", Font.BOLD, 30);

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculator() {
        // Sets the title of the window to "Calculator".
        setTitle("Calculator");
        // Ensures the application exits when the window is closed.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Sets the size of the window to 400 pixels wide and 550 pixels tall.
        setSize(400, 500);
        // Sets the layout manager to null, allowing for absolute positioning of components.
        setLayout(null);
        // Set background color
        getContentPane().setBackground(Color.darkGray);
        // Initialize components
        new Display();
        new NumButtons();
        new Function_Buttons();
        new Panel();
        // Set the frame to be visible
        setVisible(true);
    }

    private class Display {
        public Display() {
            display = new JTextField();
            display.setBounds(50, 25, 300, 50);
            display.setFont(myFont);
            display.setEditable(false);
            display.setBackground(new Color(50, 70, 70));
            display.setForeground(new Color(0xDF6CFF)); // Display text color
            add(display);
        }
    }

    private class NumButtons {
        public NumButtons() {
            // Initialize number buttons (0-9)
            numButtons = new JButton[10];
            for (int i = 0; i < 10; i++) {
                numButtons[i] = new JButton(String.valueOf(i));
                numButtons[i].addActionListener(Calculator.this);
                numButtons[i].setFont(myFont);
                numButtons[i].setFocusable(false);
                numButtons[i].setBackground(new Color(50, 50, 50)); // Button background color
                numButtons[i].setForeground(Color.CYAN); // Button text color
            }
        }
    }

    private class Function_Buttons {
        public Function_Buttons() {
            // Initialize function buttons (+, -, *, /, ., =, Del, Clr)
            addButton = new JButton("+");
            subButton = new JButton("-");
            mulButton = new JButton("*");
            divButton = new JButton("/");
            decButton = new JButton(".");
            equButton = new JButton("=");
            delButton = new JButton("Del");
            clrButton = new JButton("Clr");

            JButton[] functionButtons = {addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton};

            for (JButton button : functionButtons) {
                button.addActionListener(Calculator.this);
                button.setFont(myFont);
                button.setFocusable(false);
                button.setBackground(new Color(50, 50, 50)); // Button background color
                button.setForeground(Color.CYAN); // Button text color
            }

            delButton.setBounds(50, 430, 145, 50);
            clrButton.setBounds(205, 430, 145, 50);
            add(delButton);
            add(clrButton);
        }
    }

    private class Panel {
        public Panel() {
            panel = new JPanel();
            panel.setBounds(50, 100, 300, 300);
            panel.setLayout(new GridLayout(4, 4, 10, 10));
            // Panel background color
            panel.setBackground(Color.darkGray);

            panel.add(numButtons[1]);
            panel.add(numButtons[2]);
            panel.add(numButtons[3]);
            panel.add(addButton);
            panel.add(numButtons[4]);
            panel.add(numButtons[5]);
            panel.add(numButtons[6]);
            panel.add(subButton);
            panel.add(numButtons[7]);
            panel.add(numButtons[8]);
            panel.add(numButtons[9]);
            panel.add(mulButton);
            panel.add(decButton);
            panel.add(numButtons[0]);
            panel.add(equButton);
            panel.add(divButton);

            add(panel);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButtons[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            display.setText(display.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(display.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }
            display.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            display.setText("");
        }
        if (e.getSource() == delButton) {
            String string = display.getText();
            display.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                display.setText(display.getText() + string.charAt(i));
            }
        }
    }

}
