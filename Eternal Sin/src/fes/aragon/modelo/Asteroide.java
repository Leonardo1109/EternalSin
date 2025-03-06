package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class Asteroide extends ComponentesJuego {
	private Rectangle rectangulo;
	private Image imagen;
	private boolean bandera = false;
	private int puntaje = 0;
	
	public Asteroide(int cantidad, int x, int y, String imagen, int velocidad) {
		super(cantidad, x, y, imagen, velocidad);
		int min = 0;
		int max = 0;
		if (cantidad == 1) {
			min = 0;
		} else if (cantidad == 2) {
			min = -150;
		} else if (cantidad == 3) {
			min = -300;
		} else if (cantidad == 4) {
			min = -450;
		} else if (cantidad == 5) {
			min = -600;
		}
		max = min - 50;
		int posicionY = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int posicionX = (int) Math.floor(Math.random() * (550 - 0 + 1) + 0);
		this.setY(posicionY);
		this.setX(posicionX);
		this.imagen = new Image(imagen);
		rectangulo = new Rectangle(posicionX, posicionY, this.imagen.getWidth(), this.imagen.getHeight());
	}

	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(imagen, x, y);
	}

	@Override
	public void teclado(KeyEvent evento, boolean presiona) {
	}

	@Override
	public void raton(KeyEvent evento) {
	}

	@Override
	public void logicaCalculos() {
		y += velocidad;		
		if (bandera == true) {
			velocidad = velocidad + 1;
			bandera = false;
		}
		if (y >= 600) {
			y -= 700;
			x = (int) Math.floor(Math.random() * (500 - 0 + 1) + 0);
			puntaje += 1;
			bandera = true;
		}
		this.rectangulo.setX(x);
		this.rectangulo.setY(y);
	}

	public int getPuntaje() {
		return puntaje;
	}

	public Rectangle getRectangulo() {
		return rectangulo;
	}
}
