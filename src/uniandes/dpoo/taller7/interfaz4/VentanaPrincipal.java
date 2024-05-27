package uniandes.dpoo.taller7.interfaz4;

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
	private PanelNorte panelNorte;
	private PanelSouth panelSur;
	private PanelEast panelEste;
	private PanelCenter cuadricula;
	private String usuario;
	

	public VentanaPrincipal() {
		this.usuario = "";
		this.tablero = new Tablero(5);
		this.top10 = new Top10();
		File archivo = new File("data/top10.csv");
		this.top10.cargarRecords(archivo);
		salvarTop10();
		setTitle("Juego de LightsOut");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);

		setLayout(new BorderLayout());
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			salvarTop10();
		}
		});
		this.panelNorte = new PanelNorte();
		this.add(panelNorte, BorderLayout.NORTH);
		
		this.panelEste = new PanelEast(this);
		this.add(panelEste, BorderLayout.EAST);
		
		this.panelSur = new PanelSouth();
		this.add(panelSur, BorderLayout.SOUTH);
		
		this.cuadricula = new PanelCenter(this.getWidth(), this.getHeight(), this.tablero, this);
		this.add(cuadricula, BorderLayout.CENTER);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new VentanaPrincipal();
	}
	
	public void salvarTop10() {
		this.top10.agregarRegistro(this.usuario, this.tablero.calcularPuntaje());
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
	
	
	
	public void crearNuevoJuego() {
		int[] valores = panelNorte.getValores();
		this.tablero = new Tablero(valores[0]);
		this.tablero.desordenar(valores[1]);
		this.cuadricula.setTablero(this.tablero);
		this.actualizarJugadas();
		actualizar();
	}
	
	public void actualizar() {
		this.setVisible(false);
		this.setVisible(true);
	}

	public void reiniciarJuego() {
		this.tablero.reiniciar();
		this.actualizarJugadas();
		actualizar();
	}

	public void actualizarJugadas() {
		this.panelSur.agregarJugada(Integer.toString(this.tablero.darJugadas()));
	}
	
	public Collection<RegistroTop10> getTop10() {
		return this.top10.darRegistros();
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
		this.panelSur.setUsuario(usuario);
	}
}
