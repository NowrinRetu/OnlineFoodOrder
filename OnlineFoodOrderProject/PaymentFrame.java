
package onlinefoodorderr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaymentFrame extends JFrame {
    public PaymentFrame(int totalAmount) {
        setTitle("Payment Page");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));
        setLocationRelativeTo(null);

        add(new JLabel("Total Amount: " + totalAmount + " Taka", SwingConstants.CENTER));

        JButton cashButton = new JButton("Pay with Cash");
        JButton cardButton = new JButton("Pay with Card");

        add(cashButton);
        add(cardButton);

        ActionListener paymentListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Payment Successful! Thank you for your order.");
                System.exit(0);
            }
        };

        cashButton.addActionListener(paymentListener);
        cardButton.addActionListener(paymentListener);

        setVisible(true);
    }
}
