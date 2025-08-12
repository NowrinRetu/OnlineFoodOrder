package onlinefoodorderr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginFrame() {
        setTitle("Login Page");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(255, 239, 213)); 

        JLabel titleLabel = new JLabel("Welcome! Please Login");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(new Color(128, 0, 0));
        titleLabel.setBounds(110, 60, 300, 40);
        add(titleLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        usernameLabel.setBounds(100, 150, 100, 25);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(200, 150, 180, 25);
        usernameField.setBackground(new Color(255, 250, 240));
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        passwordLabel.setBounds(100, 190, 100, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 190, 180, 25);
        passwordField.setBackground(new Color(255, 250, 240));
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(190, 250, 120, 35);
        loginButton.setBackground(new Color(255, 99, 71));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("admin") && password.equals("admin")) {
                    dispose();
                    new MenuFrame();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
            }
        });

        setVisible(true);
    }
}

class MenuFrame extends JFrame {
    private JButton proceedButton;

    public MenuFrame() {
        setTitle("Menu Page");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(255, 248, 220));

        JLabel menuLabel = new JLabel("Welcome to the Menu Page");
        menuLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        menuLabel.setForeground(new Color(128, 0, 0));
        menuLabel.setBounds(90, 30, 350, 30);
        add(menuLabel);

        JLabel pizzaLabel = new JLabel("Pizza - 800 Taka");
        pizzaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pizzaLabel.setBounds(160, 100, 200, 25);
        add(pizzaLabel);

        JLabel burgerLabel = new JLabel("Burger - 250 Taka");
        burgerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        burgerLabel.setBounds(160, 130, 200, 25);
        add(burgerLabel);

        JLabel pastaLabel = new JLabel("Pasta - 400 Taka");
        pastaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pastaLabel.setBounds(160, 160, 200, 25);
        add(pastaLabel);

        proceedButton = new JButton("Proceed to Order");
        proceedButton.setBounds(170, 250, 160, 35);
        proceedButton.setBackground(new Color(60, 179, 113));
        proceedButton.setForeground(Color.WHITE);
        proceedButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(proceedButton);

        proceedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null, "Proceeding to order page...");
            }
        });

        setVisible(true);
    }
}

public class LoginPage {
    public static void main(String[] args) {
        new LoginFrame();
    }
}
