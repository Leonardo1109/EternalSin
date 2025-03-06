package fes.aragon.modelo;

public class ControladoresMuerte {

	private int puntaje;
	private int puntajeAsteroide1;
	private int puntajeAsteroide2;
	private int puntajeAsteroide3;
	private int puntajeAsteroide4;
	private int puntajeAsteroide5;

	public void setPuntajeAsteroide1(int puntajeAsteroide1) {
		this.puntajeAsteroide1 = puntajeAsteroide1;
	}

	public void setPuntajeAsteroide2(int puntajeAsteroide2) {
		this.puntajeAsteroide2 = puntajeAsteroide2;
	}

	public void setPuntajeAsteroide3(int puntajeAsteroide3) {
		this.puntajeAsteroide3 = puntajeAsteroide3;
	}

	public void setPuntajeAsteroide4(int puntajeAsteroide4) {
		this.puntajeAsteroide4 = puntajeAsteroide4;
	}

	public void setPuntajeAsteroide5(int puntajeAsteroide5) {
		this.puntajeAsteroide5 = puntajeAsteroide5;
	}

	public int getPuntaje() {
		this.puntaje = puntajeAsteroide1 + puntajeAsteroide2 + puntajeAsteroide3 + puntajeAsteroide4
				+ puntajeAsteroide5;
		return puntaje;
	}

}
