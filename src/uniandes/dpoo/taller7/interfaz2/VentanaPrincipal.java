package uniandes.dpoo.taller7.interfaz2;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.dpoo.taller7.modelo.RegistroTop10;
import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

public class VentanaPrincipal extends JFrame {
	private Tablero tablero;
	private Top10 top10;

	public VentanaPrincipal() {
		this.tablero = new Tablero(5);
		this.top10 = new Top10();
		File archivo = new File("data/top10.csv");
		this.top10.cargarRecords(archivo);
		salvarTop10();
		setTitle("Juego de LightsOut");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);

		setLayout(new BorderLayout());
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			salvarTop10();
		}
		});
		
		PanelNorte panelNorte = new PanelNorte();
		this.add(panelNorte, BorderLayout.NORTH);
		
		PanelEast panelEste = new PanelEast();
		this.add(panelEste, BorderLayout.EAST);
		
		PanelSouth panelSur = new PanelSouth();
		this.add(panelSur, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new VentanaPrincipal();
	}
	
	public void salvarTop10() {
		File registroTop10 = new File("data/top10.csv");
		try {
			this.top10.salvarRecords(registroTop10);
		} catch (FileNotFoundException e) {
			new DialogoDeError(this, TipoExcepciones.FileNotFound);
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			new DialogoDeError(this, TipoExcepciones.EncodingFileException);
			e.printStackTrace();
		}
	}
}
