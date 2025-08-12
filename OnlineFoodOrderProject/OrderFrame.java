
package onlinefoodorderr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OrderFrame extends JFrame {
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
            new PaymentFrame(totalAmount);
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
