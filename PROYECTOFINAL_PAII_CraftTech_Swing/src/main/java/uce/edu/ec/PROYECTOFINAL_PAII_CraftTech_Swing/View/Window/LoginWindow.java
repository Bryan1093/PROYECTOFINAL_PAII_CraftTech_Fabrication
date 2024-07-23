package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_Swing.View.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginWindow() {
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        setLayout(new GridLayout(3, 1));
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(new JLabel("Username:"));
        panel1.add(usernameField);

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(new JLabel("Password:"));
        panel2.add(passwordField);

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.add(loginButton);

        add(panel1);
        add(panel2);
        add(panel3);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                // Lógica de autenticación
                if (username.equals("admin") && password.equals("admin")) {
                    JOptionPane.showMessageDialog(LoginWindow.this, "Login successful as Admin!");

                    // Abre la ventana de administrador
                    AdminWindow adminWindow = new AdminWindow();
                    adminWindow.setVisible(true);

                    // Cierra la ventana de login
                    dispose();  // Cierra la ventana actual
                } else if (username.equals("cliente") && password.equals("cliente")) {
                    JOptionPane.showMessageDialog(LoginWindow.this, "Login successful as Client!");

                    // Abre la ventana de cliente
                    ClientWindow clientWindow = new ClientWindow();
                    clientWindow.setVisible(true);

                    // Cierra la ventana de login
                    dispose();  // Cierra la ventana actual
                } else {
                    JOptionPane.showMessageDialog(LoginWindow.this, "Invalid username or password!");
                }

                // Limpia los campos después del intento de login
                usernameField.setText("");
                passwordField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginWindow().setVisible(true);
            }
        });
    }
}
