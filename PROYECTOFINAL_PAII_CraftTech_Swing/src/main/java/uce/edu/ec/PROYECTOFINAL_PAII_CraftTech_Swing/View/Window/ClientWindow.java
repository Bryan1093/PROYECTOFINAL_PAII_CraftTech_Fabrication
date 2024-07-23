package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_Swing.View.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientWindow extends JFrame {

    private JTextField productoField;  // Campo para ingresar el producto
    private JTextField clienteField;   // Campo para ingresar el cliente
    private JButton enviarPedidoButton;  // Botón para enviar el pedido
    private JButton cambiarCuentaButton; // Botón para cambiar de cuenta

    public ClientWindow() {
        setTitle("Cliente Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);  // Tamaño ajustado para mostrar los componentes
        setLocationRelativeTo(null);  // Centrar en la pantalla

        // Creación de campos de texto
        productoField = new JTextField(20);
        clienteField = new JTextField(20);

        // Creación del botón para enviar pedido
        enviarPedidoButton = new JButton("Enviar Pedido");
        enviarPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarPedidoAlServidor();
            }
        });

        // Creación del botón para cambiar de cuenta
        cambiarCuentaButton = new JButton("Cambiar de Cuenta");
        cambiarCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirLogin();
            }
        });

        // Panel principal y configuración de layout
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));  // Grid layout con espacios entre componentes

        // Agregar componentes al panel
        panel.add(new JLabel("Producto:"));
        panel.add(productoField);
        panel.add(new JLabel("Cliente:"));
        panel.add(clienteField);
        panel.add(new JLabel());  // Espacio vacío para alinear botón con campos
        panel.add(enviarPedidoButton);
        panel.add(new JLabel());  // Espacio vacío para alinear botón con campos
        panel.add(cambiarCuentaButton);

        // Agregar panel al JFrame
        add(panel);

        // Este método esencial para mostrar los componentes
        setVisible(true);
    }

    // Método para enviar el pedido al servidor
    private void enviarPedidoAlServidor() {
        String producto = productoField.getText();
        String cliente = clienteField.getText();

        // Validación básica de campos
        if (producto.isEmpty() || cliente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.");
            return;
        }

        // JSON del pedido (constrúyelo según la estructura esperada por el backend)
        String jsonPedido = "{\"producto\": \"" + producto + "\", \"cliente\": \"" + cliente + "\"}";

        // Cliente HTTP para enviar la solicitud POST al servidor
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/pedidos/crear"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonPedido))
                .build();

        try {
            // Envío de la solicitud y recepción de la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Código de estado HTTP: " + response.statusCode());
            System.out.println("Respuesta del servidor: " + response.body());

            // Ejemplo de manejo de respuesta
            if (response.statusCode() == 200) {
                JOptionPane.showMessageDialog(this, "Pedido enviado correctamente al servidor.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al enviar el pedido al servidor.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al enviar el pedido: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Liberar recursos del cliente HTTP
            client = null;
        }
    }

    // Método para abrir la ventana de login
    private void abrirLogin() {
        LoginWindow loginWindow = new LoginWindow(); // Crea una instancia de LoginForm
        loginWindow.setVisible(true); // Hace visible la ventana de login
        dispose(); // Cierra la ventana actual (ClientePage)
    }

    public static void main(String[] args) {
        // Ejecutar la ventana Swing en el hilo de despacho de eventos
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientWindow();  // Crear una instancia de ClientePage y hacerla visible
            }
        });
    }
}
