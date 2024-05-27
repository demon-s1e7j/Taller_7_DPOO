package uniandes.dpoo.taller7.interfaz3;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.io.FileNotFoundException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DialogoDeError {

	public DialogoDeError(JFrame frame, TipoExcepciones e) {
		JDialog dialogo = new JDialog(frame, "Ocurrio un Error");
		dialogo.setSize(400, 100);
		String mensajeError = getMensajeError(e);
		JLabel error = new JLabel(mensajeError, SwingConstants.CENTER);
		dialogo.setBackground(Color.RED);
		error.setSize(300, 50);
		dialogo.add(error);
		dialogo.setVisible(true);
	}
	
	public String getMensajeError(TipoExcepciones e) {
		switch (e) {
		case FileNotFound:
			return "No se encontro el archivo buscado";
		case EncodingFileException:
			return "Hay un problema con la codificación";
		default:
			return "Ocurrio un error no determinado";
		}
		
	}
}
