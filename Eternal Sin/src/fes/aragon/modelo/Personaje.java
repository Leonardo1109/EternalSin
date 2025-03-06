package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class Personaje extends ComponentesJuego {
	private int gravedad = 1;
	private Rectangle rectangulo;
	private Image imagen;
	private boolean salto = false;
	private boolean derecha = false;
	private boolean izquierda = false;
	private boolean arriba = false;
	private boolean abajo = false;

	public Personaje(int x, int y, String imagen, int velocidad) {
		super(x, y, imagen, velocidad);
		this.imagen = new Image(imagen);
		rectangulo = new Rectangle(x, y, this.imagen.getWidth(), this.imagen.getHeight());
	}

	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(imagen, x, y);
	}

	@Override
	public void teclado(KeyEvent evento, boolean presiona) {
		if (presiona) {
			switch (evento.getCode().toString()) {
			case "RIGHT":
				derecha = true;
				break;
			case "LEFT":
				izquierda = true;
				break;
			case "UP":
				arriba = true;
				break;
			case "DOWN":
				abajo = true;
				break;
			case "SPACE":
				this.salto = true;
				break;
			}
		} else {
			switch (evento.getCode().toString()) {
			case "RIGHT":
				derecha = false;
				break;
			case "LEFT":
				izquierda = false;
				break;
			case "UP":
				arriba = false;
				break;
			case "DOWN":
				abajo = false;
				break;
			case "SPACE":
				this.salto = false;
				break;
			}
		}

	}

	@Override
	public void raton(KeyEvent evento) {
	}

	@Override
	public void logicaCalculos() {
		y += gravedad;
		if (derecha) {
			x += velocidad;
		}
		if (izquierda) {
			x -= velocidad;
		}
		if (arriba) {
			y -= velocidad;
		}
		if (abajo) {
			y += velocidad;
		}
		if (salto) {
			y += -5;
		}
		this.rectangulo.setX(x);
		this.rectangulo.setY(y);
		
		if (x < 0) {
			x += velocidad;
		}
		if (x + this.imagen.getWidth() > 600) {
			x -= velocidad;
		}
		if (y < 0) {
			y += velocidad;
				if (salto == true) {
					y += 5;
				}
		}
		if (y + this.imagen.getHeight() > 600) {
			y -= gravedad;
				if (abajo == true) {
					y -= velocidad;
				}
		}

	}

	public Rectangle getRectangulo() {
		return rectangulo;
	}

}
