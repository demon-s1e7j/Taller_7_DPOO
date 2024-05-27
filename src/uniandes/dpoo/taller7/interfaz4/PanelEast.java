package uniandes.dpoo.taller7.interfaz4;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class PanelEast extends JPanel implements ActionListener {
	private VentanaPrincipal juego;
	
	public PanelEast(VentanaPrincipal juego) {
		this.juego = juego;
		JButton nuevo = configurarBoton("nuevo");
		JButton reiniciar = configurarBoton("reiniciar");
		JButton top10 = configurarBoton("top-10");
		JButton cambiarJugador = configurarBoton("cambiar Jugador");
		nuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.crearNuevoJuego();
			}
		});
		reiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.reiniciarJuego();
			}
		});
		top10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DialogTop10(juego);
			}
		});
		cambiarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.setUsuario("S1e7J");
			}
		});
		JSeparator s0 = new JSeparator();
		JSeparator s1 = new JSeparator();
		JSeparator s2 = new JSeparator();
		JSeparator s3 = new JSeparator();
		JSeparator s4 = new JSeparator();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(s0);
		this.add(nuevo);
		this.add(s1);
		this.add(reiniciar);
		this.add(s2);
		this.add(top10);
		this.add(s3);
		this.add(cambiarJugador);
		this.add(s4);
	}
	
	public JButton configurarBoton(String valor) {
		JButton btn = new JButton(valor.toUpperCase());
		btn.setMaximumSize(new Dimension(150, 20));
		btn.setMargin(new Insets(5, 5, 5, 5));
		btn.setAlignmentY(JButton.CENTER_ALIGNMENT);
		return btn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}