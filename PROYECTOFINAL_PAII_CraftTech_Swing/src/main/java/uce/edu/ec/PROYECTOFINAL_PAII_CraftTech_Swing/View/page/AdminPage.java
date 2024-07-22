package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_Swing.View.page;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class AdminPage extends JFrame {

    private JTable pedidosTable;
    private JScrollPane scrollPane;

    public AdminPage() {
        setTitle("Admin Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        pedidosTable = new JTable();
        pedidosTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pedidosTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPane = new JScrollPane(pedidosTable);
        add(scrollPane, BorderLayout.CENTER);

        obtenerPedidosDelServidor(); // Obtener los pedidos del servidor al abrir la página
    }

    private void obtenerPedidosDelServidor() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/pedidos")) // Endpoint de tu servidor Spring Boot
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Código de estado HTTP: " + response.statusCode());
            System.out.println("Respuesta del servidor: " + response.body());

            if (response.statusCode() == 200) {
                // Convertir la respuesta JSON en una lista de objetos genéricos
                List<List<Object>> data = convertirJSONATabla(response.body());

                // Crear un DefaultTableModel con columnas específicas
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("ID");
                model.addColumn("Producto");
                model.addColumn("Cliente");

                // Llenar el modelo con los datos obtenidos
                for (List<Object> row : data) {
                    model.addRow(row.toArray());
                }

                // Establecer el modelo en la tabla
                pedidosTable.setModel(model);
            } else {
                JOptionPane.showMessageDialog(this, "Error al obtener los pedidos del servidor.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al obtener los pedidos: " + e.getMessage());
            e.printStackTrace();
        } finally {
            client = null;  // Liberar recursos del cliente HTTP
        }
    }

    // Método para convertir el JSON en datos de tabla genéricos
    private List<List<Object>> convertirJSONATabla(String jsonResponse) {
        List<List<Object>> data = new ArrayList<>();

        // Usar Gson para analizar la respuesta JSON
        JsonArray jsonArray = JsonParser.parseString(jsonResponse).getAsJsonArray();

        for (JsonElement element : jsonArray) {
            List<Object> row = new ArrayList<>();
            // Agregar los campos específicos que necesites mostrar en la tabla
            row.add(element.getAsJsonObject().get("id").getAsLong());
            row.add(element.getAsJsonObject().get("producto").getAsString());
            row.add(element.getAsJsonObject().get("cliente").getAsString());
            data.add(row);
        }

        return data;
    }

    public static void main(String[] args) {
        // Ejecutar la ventana Swing en el hilo de despacho de eventos
        SwingUtilities.invokeLater(() -> {
            new AdminPage().setVisible(true);
        });
    }
}
