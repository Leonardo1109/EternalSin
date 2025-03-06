package fes.aragon.modelo;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MensajeMuerte {
	private int puntaje;
	private int tiempoJuego;
	
	public MensajeMuerte() {
	}
	
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public void setTiempoJuego(int tiempoJuego) {
		this.tiempoJuego = tiempoJuego;
	}

	public void ventanaFinal() {
		JFrame ventanaMuerte = new JFrame();
		JOptionPane.showMessageDialog(ventanaMuerte,
		"Has Muerto\nTu puntuacion final ha sido de: " + puntaje +
		"\nTu tiempo de juego fue de " + tiempoJuego + " segundos");
	}
	
	public void windowClosing() {
		System.exit(0);
	}
	
}