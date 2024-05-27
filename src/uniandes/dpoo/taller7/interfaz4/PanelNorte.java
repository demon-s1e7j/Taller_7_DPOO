package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelNorte extends JPanel {
	private JComboBox comboBoxTamanos;
	private ButtonGroup group;
	
	public PanelNorte() {
		this.setLayout(new FlowLayout());
		JLabel tamano = new JLabel("Tamaño");
		JLabel dificultad = new JLabel("Dificultad");
		String tamanos[] = {"5x5", "6x6", "7x7", "8x8"};
		this.comboBoxTamanos = new JComboBox<String>(tamanos);
		JRadioButton facil = new JRadioButton();
		facil.setText("Facil");
		facil.setSelected(true);
		facil.setActionCommand("Facil");
		JRadioButton medio = new JRadioButton();
		medio.setText("Medio");
		medio.setActionCommand("Medio");
		JRadioButton dificil = new JRadioButton();
		dificil.setText("Dificil");
		dificil.setActionCommand("Dificil");
		this.group = new ButtonGroup();
		group.add(facil);
		group.add(medio);
		group.add(dificil);
		this.add(tamano);
		this.add(comboBoxTamanos);
		this.add(dificultad);
		this.add(facil);
		this.add(medio);
		this.add(dificil);

		setVisible(true);
		}
	public int[] getValores() {
		String tamano = (String) this.comboBoxTamanos.getSelectedItem();
		int primerValor = tamano.charAt(0) - '0';
		int segundoValor = getDificultad(this.group.getSelection().getActionCommand());
		int[] ret = { primerValor, segundoValor };
		return ret;
	}
	
	public int getDificultad(String string) {
		switch (string) {
		case "Facil":
			return 5;
		case "Medio":
			return 15;
		default:
			return 35;
		}
	}
}
