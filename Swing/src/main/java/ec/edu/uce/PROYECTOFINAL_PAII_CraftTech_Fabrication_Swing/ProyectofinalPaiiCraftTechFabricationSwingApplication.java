package ec.edu.uce.PROYECTOFINAL_PAII_CraftTech_Fabrication_Swing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import view.MainFrame;

import javax.swing.*;

@SpringBootApplication
public class ProyectofinalPaiiCraftTechFabricationSwingApplication {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
	}

}
