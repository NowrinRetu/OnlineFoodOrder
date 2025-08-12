
package onlinefoodorderr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuFrame extends JFrame {
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
