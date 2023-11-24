import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class RegistrationForm {
    JFrame frame;
    JTextField nameField, usernameField, passwordField, emailField, phoneField, addressField;
    JButton submitButton, resetButton, closeButton;

    RegistrationForm() {
        frame = new JFrame("Registration Form");
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameField = new JTextField();
        nameField.setBounds(50, 50, 150, 20);
        usernameField = new JTextField();
        usernameField.setBounds(50, 75, 150, 20);
        passwordField = new JTextField();
        passwordField.setBounds(50, 100, 150, 20);
        emailField = new JTextField();
        emailField.setBounds(50, 125, 150, 20);
        phoneField = new JTextField();
        phoneField.setBounds(50, 150, 150, 20);
        addressField = new JTextField();
        addressField.setBounds(50, 175, 150, 20);

        submitButton = new JButton("Submit");
        submitButton.setBounds(50, 200, 150, 20);
        resetButton = new JButton("Reset");
        resetButton.setBounds(50, 225, 150, 20);
        closeButton = new JButton("Close");
        closeButton.setBounds(50, 250, 150, 20);

        frame.add(nameField);
        frame.add(usernameField);
        frame.add(passwordField);
        frame.add(emailField);
        frame.add(phoneField);
        frame.add(addressField);
        frame.add(submitButton);
        frame.add(resetButton);
        frame.add(closeButton);

        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String username = usernameField.getText();
                String password = passwordField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();

                try {
                    Class.forName("com.mysql.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cat2", "root", "atlantis001.");

                    PreparedStatement stmt = con.prepareStatement("INSERT INTO registration VALUES (?, ?, ?, ?, ?, ?)");
                    stmt.setString(1, name);
                    stmt.setString(2, username);
                    stmt.setString(3, password);
                    stmt.setString(4, email);
                    stmt.setString(5, phone);
                    stmt.setString(6, address);

                    stmt.executeUpdate();

                    con.close();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                usernameField.setText("");
                passwordField.setText("");
                emailField.setText("");
                phoneField.setText("");
                addressField.setText("");
            }
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}
