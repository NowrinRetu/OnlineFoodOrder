package onlinefoodorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuFrame extends JFrame{

    private JButton proceedButton;

    public MenuFrame() {
        setTitle("Menu Page");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel menuLabel = new JLabel("Welcome to the Menu Page");
        menuLabel.setFont(new Font("Arial", Font.BOLD, 18));
        menuLabel.setBounds(100, 30, 300, 30);
        add(menuLabel);

        JLabel pizzaLabel = new JLabel("Pizza - 800 Taka");
        pizzaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        pizzaLabel.setBounds(160, 100, 200, 25);
        add(pizzaLabel);

        JLabel burgerLabel = new JLabel("Burger - 250 Taka");
        burgerLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        burgerLabel.setBounds(160, 130, 200, 25);
        add(burgerLabel);

        JLabel pastaLabel = new JLabel("Pasta - 400 Taka");
        pastaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        pastaLabel.setBounds(160, 160, 200, 25);
        add(pastaLabel);

        proceedButton = new JButton("Proceed to Order");
        proceedButton.setBounds(170, 250, 150, 35);
        add(proceedButton);

        proceedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Proceed button clicked!");
               
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuFrame();
    }
}
