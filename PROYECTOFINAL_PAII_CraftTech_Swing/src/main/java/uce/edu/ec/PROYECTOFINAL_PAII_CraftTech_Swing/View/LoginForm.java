package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_Swing.View;

import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_Swing.View.page.AdminPage;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_Swing.View.page.ClientePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LoginForm extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginForm() {
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Username:", SwingConstants.RIGHT));
        inputPanel.add(usernameField);
        inputPanel.add(new JLabel("Password:", SwingConstants.RIGHT));
        inputPanel.add(passwordField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                // Lógica de autenticación
                autenticarUsuario(username, password);
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterForm registerForm = new RegisterForm();
                registerForm.setVisible(true);
            }
        });
    }

    private void autenticarUsuario(String username, String password) {
        // Verificar si el usuario es el administrador predefinido
        if (username.equals("@root") && password.equals("@root")) {
            JOptionPane.showMessageDialog(LoginForm.this, "Login successful as Admin!");
            AdminPage adminPage = new AdminPage();
            adminPage.setVisible(true);
            dispose();  // Cierra la ventana actual
            return;  // No continuar con la autenticación en el servidor
        }

        // JSON de la solicitud de autenticación
        String jsonLogin = "{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}";

        System.out.println("Autenticando usuario con JSON: " + jsonLogin);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/users/login"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonLogin))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Código de respuesta: " + response.statusCode());
            System.out.println("Respuesta del servidor: " + response.body());

            if (response.statusCode() == 200) {
                String role = response.body();

                if (role.equals("admin")) {
                    JOptionPane.showMessageDialog(LoginForm.this, "Login successful as Admin!");
                    AdminPage adminPage = new AdminPage();
                    adminPage.setVisible(true);
                } else if (role.equals("cliente")) {
                    JOptionPane.showMessageDialog(LoginForm.this, "Login successful as Client!");
                    ClientePage clientePage = new ClientePage();
                    clientePage.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(LoginForm.this, "Unknown role: " + role);
                }

                dispose();  // Cierra la ventana actual
            } else {
                JOptionPane.showMessageDialog(LoginForm.this, "Invalid username or password!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(LoginForm.this, "Error al autenticar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Limpia los campos después del intento de login
            usernameField.setText("");
            passwordField.setText("");
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
}
