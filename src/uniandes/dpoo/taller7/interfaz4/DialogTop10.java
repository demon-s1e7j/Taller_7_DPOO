package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Collection;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.SwingConstants;

import uniandes.dpoo.taller7.modelo.RegistroTop10;

public class DialogTop10 {
	public DialogTop10(VentanaPrincipal juego) {
		JDialog dialogo = new JDialog(juego, "Top 10");
		dialogo.setSize(100, 400);
		Collection<RegistroTop10> top10 = juego.getTop10();
		JList<JLabel> top10L = new JList<JLabel>();
		for (RegistroTop10 registro: top10) {
			JLabel reg = new JLabel("Usuario: "+ registro.darNombre()+" Puntos: "+ registro.darPuntos());
			top10L.add(reg);
		}
		dialogo.add(top10L);
		dialogo.setVisible(true);
	}
}
