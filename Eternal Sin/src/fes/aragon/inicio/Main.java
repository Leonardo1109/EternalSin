package fes.aragon.inicio;

import fes.aragon.extras.MusicaCiclica;
import fes.aragon.modelo.Asteroide;
import fes.aragon.modelo.ControladoresMuerte;
import fes.aragon.modelo.Fondo;
import fes.aragon.modelo.MensajeMuerte;
import fes.aragon.modelo.Personaje;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {
	private GraphicsContext graficos;
	private Group root;
	private Scene escena;
	private Canvas hoja;
	private Thread hiloFondo;
	private Fondo fondo;
	private Personaje personaje;
	private Asteroide asteroide1;
	private Asteroide asteroide2;
	private Asteroide asteroide3;
	private Asteroide asteroide4;
	private Asteroide asteroide5;
	private MensajeMuerte mensaje;
	private ControladoresMuerte controladoresMuerte;
	private int tiempoJuego = 0;

	@Override
	public void start(Stage ventana) {
		componentesIniciar();
		pintar();
		eventosTeclado();
		ventana.setScene(escena);
		ventana.setTitle("ETERNAL SIN");
		ventana.show();
		ciclo();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void stop() throws Exception {
		hiloFondo.stop();
	}

	/*
	public static void main(String[] args) { launch(args); }
	*/

	private void componentesIniciar() {
		root = new Group();
		escena = new Scene(root, 600, 600);
		hoja = new Canvas(600, 600);
		root.getChildren().add(hoja);
		graficos = hoja.getGraphicsContext2D();
		MusicaCiclica entrada = new MusicaCiclica("cancion");
		hiloFondo = new Thread(entrada);
		hiloFondo.start();
		fondo = new Fondo(0, 0, "/fes/aragon/recursos/fondo1.jpg", 5);
		personaje = new Personaje(275, 275, "/fes/aragon/recursos/naveEpica.png", 4);
		asteroide1 = new Asteroide(1, 0, 0, "/fes/aragon/recursos/1.png", 2);
		asteroide2 = new Asteroide(2, 0, 0, "/fes/aragon/recursos/2.png", 2);
		asteroide3 = new Asteroide(3, 0, 0, "/fes/aragon/recursos/3.png", 2);
		asteroide4 = new Asteroide(4, 0, 0, "/fes/aragon/recursos/4.png", 2);
		asteroide5 = new Asteroide(5, 0, 0, "/fes/aragon/recursos/1.png", 2);
		mensaje = new MensajeMuerte();
		controladoresMuerte = new ControladoresMuerte();
	}

	public void ciclo() {
		long tiempoInicio = System.nanoTime();
		AnimationTimer tiempo = new AnimationTimer() {
			@Override
			public void handle(long tiempoActual) {
				double t = (tiempoActual - tiempoInicio) / 1000000000.0;
				tiempoJuego = (int) t;
				calculosLogica();
				pintar();
			}
		};
		tiempo.start();
	}

	private void pintar() {
		this.fondo.pintar(graficos);
		this.personaje.pintar(graficos);
		this.asteroide1.pintar(graficos);
		this.asteroide2.pintar(graficos);
		this.asteroide3.pintar(graficos);
		this.asteroide4.pintar(graficos);
		this.asteroide5.pintar(graficos);
		}

	@SuppressWarnings("deprecation")
	private void calculosLogica() {
		if (personaje.getRectangulo().getBoundsInLocal().intersects((asteroide1.getRectangulo().getBoundsInLocal()))
				|| personaje.getRectangulo().getBoundsInLocal()
						.intersects((asteroide2.getRectangulo().getBoundsInLocal()))
				|| personaje.getRectangulo().getBoundsInLocal()
						.intersects((asteroide3.getRectangulo().getBoundsInLocal()))
				|| personaje.getRectangulo().getBoundsInLocal()
						.intersects((asteroide4.getRectangulo().getBoundsInLocal()))
				|| personaje.getRectangulo().getBoundsInLocal()
						.intersects((asteroide5.getRectangulo().getBoundsInLocal()))) {
			hiloFondo.stop();
			controladoresMuerte.setPuntajeAsteroide1(asteroide1.getPuntaje());
			controladoresMuerte.setPuntajeAsteroide2(asteroide2.getPuntaje());
			controladoresMuerte.setPuntajeAsteroide3(asteroide3.getPuntaje());
			controladoresMuerte.setPuntajeAsteroide4(asteroide4.getPuntaje());
			controladoresMuerte.setPuntajeAsteroide5(asteroide5.getPuntaje());
			mensaje.setPuntaje(controladoresMuerte.getPuntaje());
			mensaje.setTiempoJuego(tiempoJuego);
			mensaje.ventanaFinal();
			mensaje.windowClosing();
		} else {
			this.fondo.logicaCalculos();
			this.personaje.logicaCalculos();
			this.asteroide1.logicaCalculos();
			this.asteroide2.logicaCalculos();
			this.asteroide3.logicaCalculos();
			this.asteroide4.logicaCalculos();
			this.asteroide5.logicaCalculos();
		}
	}

	private void eventosTeclado() {
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				fondo.teclado(arg0, true);
				personaje.teclado(arg0, true);
			}
		});
		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				personaje.teclado(arg0, false);
			}
		});
	}
}
