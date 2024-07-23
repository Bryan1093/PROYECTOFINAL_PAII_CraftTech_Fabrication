package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_Swing.View.Main;

import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_Swing.View.Window.AdminWindow;

import javax.swing.SwingUtilities;

public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AdminWindow().setVisible(true);
        });
    }
}
