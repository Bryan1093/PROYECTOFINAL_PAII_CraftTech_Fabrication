package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_Swing.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RegisterForm extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public RegisterForm() {
        setTitle("Register Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        registerButton = new JButton("Register");

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Username:", SwingConstants.RIGHT));
        inputPanel.add(usernameField);
        inputPanel.add(new JLabel("Password:", SwingConstants.RIGHT));
        inputPanel.add(passwordField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(registerButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                registrarUsuario(username, password);
            }
        });
    }

    private void registrarUsuario(String username, String password) {
        // JSON de la solicitud de registro
        String jsonRegister = "{\"username\": \"" + username + "\", \"password\": \"" + password + "\", \"role\": \"cliente\"}";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/users/register"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRegister))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                JOptionPane.showMessageDialog(this, "User registered successfully!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error registering user: " + response.body());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
