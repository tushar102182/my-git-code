import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LoginRegister {

    static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login & Register");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton registerBtn = new JButton("Register");
        JButton loginBtn = new JButton("Login");

        frame.setLayout(new GridLayout(2, 1, 10, 10));
        frame.add(registerBtn);
        frame.add(loginBtn);

        registerBtn.addActionListener(e -> register());

        loginBtn.addActionListener(e -> login());

        frame.setVisible(true);
    }

    static void register() {
        String username = JOptionPane.showInputDialog("Enter username:");
        if (username == null) return;

        String password = JOptionPane.showInputDialog("Enter password:");
        if (password == null) return;

        users.add(new User(username, password));
        JOptionPane.showMessageDialog(null, "Registration successful!");
    }

    static void login() {
        String username = JOptionPane.showInputDialog("Enter username:");
        if (username == null) return;

        String password = JOptionPane.showInputDialog("Enter password:");
        if (password == null) return;

        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                JOptionPane.showMessageDialog(null, "Login successful! Welcome " + username);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Invalid username or password!");
    }
}
