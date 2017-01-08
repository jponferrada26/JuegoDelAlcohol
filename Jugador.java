package juegoDelAlcohol;

import utiles.Teclado;
/**
 * @author Javier Ponferrada Lopez
 * @version 1.0
 * */
public class Jugador {
	/**
	 * nombre del jugador
	 * */
	private String nombre;
	/**
	 * nivel de borrachera
	 * */
	private int alcoholSangre;
	/**
	 * rondas jugadas por el jugador
	 * */
	private int rondasJugadas;

	Jugador() {
	}

	/**
	 * EL JUGADOR DISPONDRA POR DEFECTO DE UN NOMBRE,ALCOHOL EN SANGRE A 0 Y
	 * RONDAS GANADAS A 0.
	 * 
	 * @param nombre,
	 *            nombre del jugador
	 */
	Jugador(String nombre) {
		setAlcoholSangre(0);
		setNombre(nombre);
		setRondasJugadas(0);
	}
	
	/**
	 * @return nombre del jugador
	 * */
	String getNombre() {
		return nombre;
	}
	
	/**
	 * @param nombre,asigna al jugador el nombre correspondiente
	 * */
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return nivel de borrachera que dispone el jugador
	 * */
	int getAlcoholSangre() {
		return alcoholSangre;
	}
	
	/**
	 * @param alcoholSangre, nivel de borrachera a asignar
	 * */
	private void setAlcoholSangre(int alcoholSangre) {
		this.alcoholSangre = alcoholSangre;
	}
	
	/**
	 * @return numero de rondas jugadas
	 * */
	int getRondasJugadas() {
		return rondasJugadas;
	}
	
	/**
	 * @param rondasJugadas, rondas jugadas a asignar
	 * */
	private void setRondasJugadas(int rondasJugadas) {
		this.rondasJugadas = rondasJugadas;
	}
	
	/**
	 * incrementa las rondas jugadas del jugador
	 * */
	void incrementarJugadas() {
		setRondasJugadas(getRondasJugadas() + 1);
	}
	
	/**
	 * @param incremento, el incremento de nivel de borrachera
	 * */
	void incrementarAlcohol(int incremento) {
		setAlcoholSangre(getAlcoholSangre() + incremento);
	}
	
	/**
	 * @return el nombre del jugador
	 * @param numeroDeJugador, a pedir el nombre
	 * */
	String pedirNombreJugador(int numeroDeJugador) {
		String nombre = "";
		do {
			nombre = Teclado.leerCadena("Nombre del jugador" + numeroDeJugador + ": ");
		} while (nombre.length() < 1);
		return nombre;
	}
}
