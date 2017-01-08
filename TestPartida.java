package juegoDelAlcohol;
import utiles.*;
/**
 * @author Javier Ponferrada Lopez
 * @version 1.0
 * */
public class TestPartida {
	/**
	 * Mensaje que se muestra al principio del juego
	 * */
	private static final String mensajePrincipal = "Bienvenido.\nEste juego consta de 4 jugadores. Cada jugador dispondra de un nivel (%) de borrachera.\nEl que aguante mas rondas sin caer en un coma etilico. ¡GANARA!";
	/**
	 * instancia de Jugador
	 * */
	private static Jugador jugador = new Jugador();
	
	public static void main(String[] args) {
		Menu menu = new Menu("\t---RULETA DEL ALCOHOL---" + "\n" + mensajePrincipal + "\n\t------------------------",
				new String[] { "-Jugar", "-Salir" });
		gestionarMenu(menu.gestionar());

	}
	
	/**
	 * Gestiona las opciones que ha indicado el usuario
	 * @param opcion,opcion que ha indicado el usuario
	 * */
	private static void gestionarMenu(int opcion) {
		switch (opcion) {
		case 1:
			Jugador jugador1 = new Jugador(jugador.pedirNombreJugador(1));
			Jugador jugador2 = new Jugador(jugador.pedirNombreJugador(2));
			Jugador jugador3 = new Jugador(jugador.pedirNombreJugador(3));
			Jugador jugador4 = new Jugador(jugador.pedirNombreJugador(4));
			Partida partida = new Partida(jugador1, jugador2, jugador3, jugador4);
			System.out.println(partida.jugar());
			break;
		case 2:
			System.out.println("Adios.");
			break;
		}

	}

}
