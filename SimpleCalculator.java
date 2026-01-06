import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends 
JFrame implements ActionListener {
     public static void main(String[] args) {
        new SimpleCalculator();
    }

    JTextField tf;
    double num1, result;
    String operator;

    public SimpleCalculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tf = new JTextField();
        tf.setFont(new Font("Arial", Font.BOLD, 20));
        tf.setHorizontalAlignment(JTextField.RIGHT);
        add(tf, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0","=","+","√",
            "AC",
        };

        for (String text : buttons) {
            JButton b = new JButton(text);
            b.setFont(new Font("Arial", Font.BOLD, 14));
            b.addActionListener(this);
            panel.add(b);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9]")) {
            tf.setText(tf.getText() + cmd);
        }
        else if (cmd.matches("[+\\-*/]")) {
            num1 = Double.parseDouble(tf.getText());
            operator = cmd;
            tf.setText("");
        }
        else if (cmd.equals("=")) {
            double num2 = Double.parseDouble(tf.getText());

            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = num1 / num2; break;
            }
            tf.setText(String.valueOf(result));
        }
        else if (cmd.equals("√")) {
            double n = Double.parseDouble(tf.getText());
            tf.setText(String.valueOf(Math.sqrt(n)));
        }
        else if (cmd.equals("AC")) {
            tf.setText("");
        }
    }

   
}
