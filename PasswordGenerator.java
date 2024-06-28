import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.*;

public class PasswordGenerator extends login {

    int a = 1;
    static JCheckBox cb1;
    static JCheckBox cb2;
    
    static JCheckBox cb3;
    static JCheckBox cb4;
    static JTextPane pane;
    static String password = "";
    static String passwordStrength;
    static LocalDate currentDate = LocalDate.now();

    static JFrame f = new JFrame("Password Generator");

    static String username = login.username;

    PasswordGenerator() {
        String punctuations = "^$*.[]{}()?-\"!@#%&/\\,><':;|_~`";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";

        StringBuilder stb = new StringBuilder();

        // Fields Initialization
        JLabel l1, l2, l3, l4, l5, lp1, rL, ls;
        JTextField tf1, resu;
        JButton b1;

        // Fields declaration
        l1 = new JLabel("Password Length:");
        l1.setBounds(50, 50, 150, 20);
        l1.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
        
        tf1 = new JTextField();
        tf1.setBounds(200, 52, 100, 20);
        lp1 = new JLabel("(b/w 6-64)");
        lp1.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));

        lp1.setBounds(320, 52, 100, 20);

        rL = new JLabel("GENERATED PASSWORDS : ");
        //rL.setBounds(500, 50, 200, 20);
        rL.setBounds(500, 50, 250, 20);
        rL.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
        
        resu = new JTextField();
        resu.setBounds(500, 70, 300, 30);
        resu.setEditable(false);

        ls = new JLabel("Password Strength : ");
        //ls.setBounds(500, 200, 120, 20);
        ls.setBounds(500, 200, 250, 20);
        ls.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
        pane = new JTextPane();
        pane.setBounds(500, 220, 200, 30);

        l2 = new JLabel("Include Small Letters:");
       
        l2.setBounds(50, 100, 250, 20);
        l2.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
        cb1 = new JCheckBox("(e.g:abcd)");
        cb1.setBounds(250, 100, 200, 20);
        cb1.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));

        l3 = new JLabel("Include Capital Letters:");
        //l3.setBounds(50, 150, 120, 20);
        l3.setBounds(50, 150, 250, 20);
        l3.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
        cb2 = new JCheckBox("(e.g:ABCD)");
        cb2.setBounds(250, 150, 200, 20);
        cb2.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));


        l4 = new JLabel("Include Numbers:");
        //l4.setBounds(50, 200, 120, 20);
        l4.setBounds(50, 200, 250, 20);
        l4.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
        cb3 = new JCheckBox("(e.g:01234)");
        cb3.setBounds(250, 200, 200, 20);
        cb3.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));

        l5 = new JLabel("Include Punctuations:");
        l5.setBounds(50, 250, 120, 20);
        l5.setBounds(50, 250, 250, 20);
        l5.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
        cb4 = new JCheckBox("(e.g:!@#$%^)");
        cb4.setBounds(250, 250, 200, 20);
        cb4.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));

        b1 = new JButton("Create Password(s)");
        b1.setBounds(260, 350, 190, 35);
        b1.setForeground(java.awt.Color.cyan);
        b1.setBackground(java.awt.Color.gray);
        b1.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));

        f.add(l1);
        f.add(tf1);
        f.add(lp1);
        f.add(ls);
        f.add(rL);
        f.add(resu);
        f.add(pane);
        f.add(l2);
        f.add(cb1);
        f.add(l3);
        f.add(cb2);
        f.add(l4);
        f.add(cb3);
        f.add(l5);
        f.add(cb4);
        f.add(b1);

        f.setSize(1100, 700);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // These actionListeners are for the CheckBoxes of the Password Generator
        // For LowerCase
        cb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cb1.isSelected()) {
                    stb.append(lowercase);
                }
            }
        });

        // For upperCase
        cb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cb2.isSelected()) {
                    stb.append(uppercase);
                }
            }
        });

        // For Numbers
        cb3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cb3.isSelected()) {
                    stb.append(numbers);
                }
            }
        });

        // For Punctuations
        cb4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cb4.isSelected()) {
                    stb.append(punctuations);
                }
            }
        });

        // Password Generation
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                password = "";
                int passLength = 1;

                if (!tf1.getText().isEmpty()) {
                    passLength = Integer.parseInt(tf1.getText());
                }

                // Check if at least one checkbox is selected
                if (!(cb1.isSelected() || cb2.isSelected() || cb3.isSelected() || cb4.isSelected())) {
                    JOptionPane.showMessageDialog(f, "Please select at least one option for password criteria.",
                            "Password Criteria Missing", JOptionPane.ERROR_MESSAGE);
                    return; // Exit method if criteria are not met
                }

                // Generate password
                for (int i = 0; i < passLength; i++) {
                    int rand = (int) (stb.length() * Math.random());
                    password += String.valueOf(stb.charAt(rand));
                }
                resu.setText("PASSWORD : " + password);
                checking();

                // Clearing fields
                stb.setLength(0);
                tf1.setText("");
                cb1.setSelected(false);
                cb2.setSelected(false);
                cb3.setSelected(false);
                cb4.setSelected(false);
            }
        });
    }

    // Portion for declaring the values to the strength of the password
    static void checking() {
        if (cb1.isSelected() && cb2.isSelected() && cb3.isSelected() && cb4.isSelected()) {
            passwordStrength = "Very High";
            pane.setText(passwordStrength);
            pane.setVisible(true);
            pane.setForeground(Color.green);
        } else if (cb1.isSelected() && cb2.isSelected() && cb3.isSelected()) {
            passwordStrength = "Good";
            pane.setText(passwordStrength);
            pane.setVisible(true);
            pane.setForeground(Color.yellow);
        } else if (cb1.isSelected() && cb2.isSelected() && cb4.isSelected()) {
            passwordStrength = "Good";
            pane.setText(passwordStrength);
            pane.setVisible(true);
            pane.setForeground(Color.yellow);
        } else if (cb1.isSelected() && cb3.isSelected() && cb4.isSelected()) {
            passwordStrength = "High";
            pane.setText(passwordStrength);
            pane.setVisible(true);
            pane.setForeground(Color.orange);
        } else if (cb2.isSelected() && cb3.isSelected() && cb4.isSelected()) {
            passwordStrength = "High";
            pane.setText(passwordStrength);
            pane.setVisible(true);
            pane.setForeground(Color.orange);
        } else if (cb1.isSelected() && cb2.isSelected()) {
            passwordStrength = "Weak";
            pane.setText(passwordStrength);
            pane.setVisible(true);
            pane.setForeground(Color.red);
        } else if (cb1.isSelected() && cb3.isSelected()) {
            passwordStrength = "Weak";
            pane.setText(passwordStrength);
            pane.setVisible(true);
            pane.setForeground(Color.red);
        } else if (cb1.isSelected() && cb4.isSelected()) {
            passwordStrength = "Moderate";
            pane.setText(passwordStrength);
            pane.setVisible(true);
            pane.setForeground(Color.black);
        } else if (cb2.isSelected() && cb3.isSelected()) {
            passwordStrength = "Moderate";
            pane.setText(passwordStrength);
            pane.setVisible(true);
            pane.setForeground(Color.black);
        } else if (cb2.isSelected() && cb4.isSelected()) {
            passwordStrength = "Moderate";
            pane.setText(passwordStrength);
            pane.setVisible(true);
            pane.setForeground(Color.black);
        } else if (cb3.isSelected() && cb4.isSelected()) {
            passwordStrength = "Good";
            pane.setText(passwordStrength);
            pane.setVisible(true);
            pane.setForeground(Color.yellow);
        } else if (cb2.isSelected()) {
            passwordStrength = "Too weak";
            pane.setText(passwordStrength);
            pane.setVisible(true);
            pane.setForeground(Color.red);
        } else if (cb1.isSelected()) {
            passwordStrength = "Too weak";
            pane.setText(passwordStrength);
            pane.setVisible(true);
            pane.setForeground(Color.red);
        } else if (cb3.isSelected()) {
            passwordStrength = "Too weak";
            pane.setText(passwordStrength);
            pane.setVisible(true);
            pane.setForeground(Color.red);
        } else if (cb4.isSelected()) {
            passwordStrength = "Too weak";
            pane.setText(passwordStrength);
            pane.setVisible(true);
            pane.setForeground(Color.red);
        }
    }

    public static void main(String[] args) {
        new PasswordGenerator();
    }
}