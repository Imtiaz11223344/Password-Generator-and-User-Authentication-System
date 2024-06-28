import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login implements ActionListener {

    JTextField tf1;
    JPasswordField pf1;
    JLabel l1, l4;
    static String username;

    login() {
        JFrame f = new JFrame("Password Generator");

        // Set the layout manager
        f.setLayout(null);

        // Username label
        l1 = new JLabel("Username:");
        l1.setFont(new Font("Times New Roman", java.awt.Font.BOLD, 18));
        l1.setBounds(50, 50, 120, 30);
        f.add(l1);

        // Username text field
        tf1 = new JTextField();
        tf1.setFont(new Font("Times New Roman", java.awt.Font.BOLD, 18));
        tf1.setBounds(180, 50, 200, 30);
        f.add(tf1);

        // Password label
        l4 = new JLabel("Password:");
        l4.setFont(new Font("Times New Roman",java.awt.Font.BOLD, 18));
        l4.setBounds(50, 100, 120, 30);
        f.add(l4);

        // Password field
        pf1 = new JPasswordField();
        pf1.setFont(new Font("Times New Roman",java.awt.Font.BOLD, 18));
        pf1.setBounds(180, 100, 200, 30);
        f.add(pf1);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Times New Roman", java.awt.Font.BOLD, 18));
        loginButton.setBounds(80, 180, 120, 40);
        loginButton.setForeground(java.awt.Color.cyan);
        loginButton.setBackground(java.awt.Color.gray);
        f.add(loginButton);

        // Sign Up button
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Times New Roman", java.awt.Font.BOLD, 18));
        signUpButton.setBounds(220, 180, 120, 40);
        signUpButton.setForeground(java.awt.Color.cyan);
        signUpButton.setBackground(java.awt.Color.gray);
        
        f.add(signUpButton);

        // Add action listeners
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginUser(f);
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new signUp();
            }
        });

        // Set frame properties
        f.setSize(450, 300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void loginUser(JFrame f) {
        String password = new String(pf1.getPassword());
        username = tf1.getText();
        boolean usrExist = false;

        // Hardcoded user credentials for demonstration
        if (username.equals("admin") && password.equals("admin123")) {
            usrExist = true;
        }

        if (usrExist) {
            new PasswordGenerator();
            f.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(f, "Invalid login or Sign Up first", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] abc) {
        new login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
}

