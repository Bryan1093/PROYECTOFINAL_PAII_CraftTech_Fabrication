package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_Swing.View.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CreateProductWindow extends JFrame {

    private JTextField nameField;
    private JTextField descriptionField;
    private JTextField priceField;
    private JComboBox<String> categoryComboBox;
    private JButton saveButton;
    private JButton cancelButton;

    public CreateProductWindow() {
        setTitle("Create Product");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize components
        nameField = new JTextField(20);
        descriptionField = new JTextField(20);
        priceField = new JTextField(20);
        categoryComboBox = new JComboBox<>();
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        // Set layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add components to layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Description:"), gbc);
        gbc.gridx = 1;
        add(descriptionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Price:"), gbc);
        gbc.gridx = 1;
        add(priceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Category:"), gbc);
        gbc.gridx = 1;
        add(categoryComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(saveButton, gbc);

        gbc.gridx = 1;
        add(cancelButton, gbc);

        // Add action listeners
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProduct();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Load categories from server or local source
        loadCategories();
    }

    private void loadCategories() {
        // Replace with actual category fetching from server or local source
        // Example categories
        List<String> categories = List.of("Madera", "Metal", "Textil");
        for (String category : categories) {
            categoryComboBox.addItem(category);
        }
    }

    private void saveProduct() {
        String name = nameField.getText();
        String description = descriptionField.getText();
        String priceText = priceField.getText();
        String category = (String) categoryComboBox.getSelectedItem();

        // Validate inputs
        if (name.isEmpty() || description.isEmpty() || priceText.isEmpty() || category == null) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Double price;
        try {
            price = Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid price format.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create and send the product to the server
        // Example of creating a Product object and sending it to the server
        // Replace with actual server communication code
        JOptionPane.showMessageDialog(this, "Product saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}
