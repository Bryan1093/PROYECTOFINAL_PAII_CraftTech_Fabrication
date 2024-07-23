package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_Swing.View.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminWindow extends JFrame {

    private JTable pedidosTable;
    private JScrollPane scrollPane;
    private JButton createProductButton;

    public AdminWindow() {
        setTitle("Admin Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Initialize components
        pedidosTable = new JTable();
        pedidosTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pedidosTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPane = new JScrollPane(pedidosTable);

        // Create buttons
        createProductButton = new JButton("Create Product");

        // Set layout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createProductButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners for buttons
        createProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCreateProductWindow();
            }
        });

        // Load orders from the server
        obtenerPedidosDelServidor();
    }

    private void openCreateProductWindow() {
        // Create and show the CreateProductWindow
        SwingUtilities.invokeLater(() -> new CreateProductWindow().setVisible(true));
    }

    private void obtenerPedidosDelServidor() {
        // ... (existing implementation)
    }
}
