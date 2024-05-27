package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelNorte extends JPanel {
	
	public PanelNorte() {
		this.setLayout(new FlowLayout());
		JLabel tamano = new JLabel("Tamaño");
		JLabel dificultad = new JLabel("Dificultad");
		String tamanos[] = {"5x5", "6x6", "7x7", "8x8"};
		JComboBox<String> comboBoxTamanos = new JComboBox<String>(tamanos);
		JRadioButton facil = new JRadioButton();
		facil.setText("Facil");
		JRadioButton medio = new JRadioButton();
		medio.setText("Medio");
		JRadioButton dificil = new JRadioButton();
		dificil.setText("Dificil");
		this.add(tamano);
		this.add(comboBoxTamanos);
		this.add(dificultad);
		this.add(facil);
		this.add(medio);
		this.add(dificil);
		setVisible(true);
		}

}
