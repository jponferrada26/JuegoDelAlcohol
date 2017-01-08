package juegoDelAlcohol;
/**
 * Bebidas que se usaran en el juego, junto con su nivel de borrachera que se le anadira al jugador.
 * @author Javier Ponferrada Lopez
 * @version 1.0
 * */
public enum Bebida {
	BEEFEATER(40),
	LICOR_43(30),
	LEGENDARIO(25),
	RON_BARCELO(28);
	private int nivelDeBorrachera;
	private Bebida(int nivelDeBorrachera) {
		setGrado(nivelDeBorrachera);
	}
	/**
	 * @return nivel de borrachera que se anadira al jugador
	 * */
	int getGrado() {
		return nivelDeBorrachera;
	}
	/**
	 * @param nivelDeBorrachera, nivel de borrachera que asignara al campo
	 * */
	private void setGrado(int nivelDeBorrachera) {
		this.nivelDeBorrachera = nivelDeBorrachera;
	}
	
	
}
