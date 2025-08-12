
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
                new OrderFrame();
                dispose();
                JOptionPane.showMessageDialog(null, "Proceeding to order page...");
            }
        });

        setVisible(true);
    }
}
class OrderFrame extends JFrame {
    private JCheckBox pizzaBox, burgerBox, pastaBox;
    private JTextField pizzaQty, burgerQty, pastaQty;
    private JTextField deliveryField;
    private JTextArea summaryArea;
    private JButton orderButton, proceedPaymentButton;

    private int totalAmount = 0;

    public OrderFrame() {
        setTitle("Order Page");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        pizzaBox = new JCheckBox("Pizza - 800 Taka");
        pizzaBox.setBounds(50, 30, 150, 25);
        add(pizzaBox);

        pizzaQty = new JTextField("0");
        pizzaQty.setBounds(220, 30, 50, 25);
        pizzaQty.setEditable(false); 
        add(pizzaQty);

        burgerBox = new JCheckBox("Burger - 250 Taka");
        burgerBox.setBounds(50, 70, 150, 25);
        add(burgerBox);

        burgerQty = new JTextField("0");
        burgerQty.setBounds(220, 70, 50, 25);
        burgerQty.setEditable(false);
        add(burgerQty);

        pastaBox = new JCheckBox("Pasta - 400 Taka");
        pastaBox.setBounds(50, 110, 150, 25);
        add(pastaBox);

        pastaQty = new JTextField("0");
        pastaQty.setBounds(220, 110, 50, 25);
        pastaQty.setEditable(false);
        add(pastaQty);

        pizzaBox.addItemListener(e -> pizzaQty.setEditable(pizzaBox.isSelected()));
        burgerBox.addItemListener(e -> burgerQty.setEditable(burgerBox.isSelected()));
        pastaBox.addItemListener(e -> pastaQty.setEditable(pastaBox.isSelected()));

        JLabel locationLabel = new JLabel("Delivery Location:");
        locationLabel.setBounds(50, 160, 150, 25);
        add(locationLabel);

        deliveryField = new JTextField();
        deliveryField.setBounds(180, 160, 200, 25);
        add(deliveryField);

        orderButton = new JButton("Show Summary");
        orderButton.setBounds(160, 210, 150, 30);
        add(orderButton);

        summaryArea = new JTextArea();
        summaryArea.setBounds(50, 260, 380, 120);
        summaryArea.setEditable(false);
        add(summaryArea);

        proceedPaymentButton = new JButton("Proceed to Payment");
        proceedPaymentButton.setBounds(150, 400, 180, 30);
        proceedPaymentButton.setVisible(false);
        add(proceedPaymentButton);

        orderButton.addActionListener(e -> showSummary());
        proceedPaymentButton.addActionListener(e -> {
            dispose();
        });

        setVisible(true);
    }

    private void showSummary() {
        int total = 0;
        StringBuilder summary = new StringBuilder("Your Order:\n");
        boolean hasItem = false;

        if (pizzaBox.isSelected()) {
            int qty = Integer.parseInt(pizzaQty.getText());
            if (qty > 0) {
                int cost = qty * 800;
                summary.append("Pizza x").append(qty).append(" = ").append(cost).append(" Taka\n");
                total += cost;
                hasItem = true;
            }
        }

        if (burgerBox.isSelected()) {
            int qty = Integer.parseInt(burgerQty.getText());
            if (qty > 0) {
                int cost = qty * 250;
                summary.append("Burger x").append(qty).append(" = ").append(cost).append(" Taka\n");
                total += cost;
                hasItem = true;
            }
        }

        if (pastaBox.isSelected()) {
            int qty = Integer.parseInt(pastaQty.getText());
            if (qty > 0) {
                int cost = qty * 400;
                summary.append("Pasta x").append(qty).append(" = ").append(cost).append(" Taka\n");
                total += cost;
                hasItem = true;
            }
        }

        String location = deliveryField.getText().trim();

        if (!hasItem) {
            JOptionPane.showMessageDialog(null, "Please select at least one item with quantity more than 0.");
            proceedPaymentButton.setVisible(false);
            return;
        }

        if (location.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your delivery location.");
            proceedPaymentButton.setVisible(false);
            return;
        }

        summary.append("Delivery Location: ").append(location).append("\n");
        summary.append("Total = ").append(total).append(" Taka");

        summaryArea.setText(summary.toString());
        totalAmount = total;
        proceedPaymentButton.setVisible(true);
    }
}
public class LoginPage {
    public static void main(String[] args) {
        new LoginFrame();
    }
}
