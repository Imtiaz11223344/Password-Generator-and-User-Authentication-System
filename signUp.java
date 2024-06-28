import javax.swing.*;
import java.awt.event.*;

public class signUp extends login implements ActionListener {

    JTextField tf1, tf2, tf3, tf4;
    JPasswordField pf1, pf2;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    static String first_name, last_name, username, password, confirm_password, hint;
    JFrame f = new JFrame("Password Generator");

    signUp() {
        // Title Label
        l1 = new JLabel("SIGN UP");
        l1.setBounds(200, 10, 100, 30);
        l1.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
        l1.setForeground(java.awt.Color.black);
        f.add(l1);
 
        // First Name Label
        l2 = new JLabel("First Name");
        l2.setBounds(50, 45, 100, 20);
        l2.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
        f.add(l2);

        // First Name TextField
        tf1 = new JTextField();
        tf1.setBounds(170, 45, 200, 25);
        f.add(tf1);

        // Last Name Label
        l3 = new JLabel("Last Name");
        l3.setBounds(50, 95, 100, 20);
        l3.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
        f.add(l3);

        // Last Name TextField
        tf2 = new JTextField();
        tf2.setBounds(170, 95, 200, 25);
        f.add(tf2);

        // Username Label
        l4 = new JLabel("Username");
        l4.setBounds(50, 145, 100, 20);
        l4.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
        f.add(l4);

        // Username TextField
        tf4 = new JTextField();
        tf4.setBounds(170, 145, 200, 25);
        f.add(tf4);

        // Username Availability Label
        l5 = new JLabel();
        l5.setBounds(380, 145, 250, 20);
        l5.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
        l5.setForeground(java.awt.Color.RED);
        f.add(l5);

        // Password Label
        l6 = new JLabel("Password");
        l6.setBounds(50, 195, 100, 20);
        l6.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
        f.add(l6);

        // Password Field
        pf1 = new JPasswordField();
        pf1.setBounds(170, 195, 200, 25);
        f.add(pf1);

        // Confirm Password Label
        l7 = new JLabel("Con/Password");
        l7.setBounds(50, 245, 150, 20);
        l7.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
        f.add(l7);

        // Confirm Password Field
        pf2 = new JPasswordField();
        pf2.setBounds(170, 245, 200, 25);
        f.add(pf2);

        // Password Mismatch Label
        l8 = new JLabel();
        l8.setBounds(380, 245, 150, 20);
        l8.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
        l8.setForeground(java.awt.Color.RED);
        f.add(l8);

        // Hint Label
        l9 = new JLabel("Hint");
        l9.setBounds(50, 295, 100, 20);
        l9.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
        f.add(l9);

        // Hint TextField
        tf3 = new JTextField();
        tf3.setBounds(170, 295, 200, 25);
        f.add(tf3);

        // Register Button
        JButton b1 = new JButton("Register");
        b1.setBounds(180, 350, 100, 30);
        b1.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
        b1.setForeground(java.awt.Color.cyan);
        b1.setBackground(java.awt.Color.gray);
        b1.addActionListener(this);  // Registering the same ActionListener
        f.add(b1);

        // Status Label
        l10 = new JLabel();
        l10.setBounds(150, 395, 200, 20);
        l10.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
        l10.setForeground(java.awt.Color.RED);
        f.add(l10);

        // Frame Settings
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Clear previous messages
        l5.setText("");
        l8.setText("");
        l10.setText("");

        // Gather user input
        first_name = tf1.getText();
        last_name = tf2.getText();
        username = tf4.getText();
        password = new String(pf1.getPassword());
        confirm_password = new String(pf2.getPassword());
        hint = tf3.getText();

        // Validate input
        if (first_name.isEmpty() || last_name.isEmpty() || username.isEmpty() || password.isEmpty() || confirm_password.isEmpty() || hint.isEmpty()) {
            l10.setText("All fields must be filled!");
            return;
        }

        // Check password match
        if (password.equals(confirm_password)) {
            JOptionPane.showMessageDialog(f, "Registration Successful! Redirecting to login page.");
            f.setVisible(false);
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new login();
                }
            });
        } else {
            //l8.setText("Passwords do not match");
            JOptionPane.showMessageDialog(f, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] abc) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new signUp();
            }
        });
    }
}