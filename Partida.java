package juegoDelAlcohol;
import utiles.*;
/**
 * @author Javier Ponferrada Lopez
 * @version 1.0
 * */
public class Partida {
	/**
	 * numeoro de ronda actual
	 * */
	private int numeroRonda;
	/**
	 * vector de jugadores a jugar
	 * */
	private Jugador[] jugadores = new Jugador[4];
	/**
	 * vector de jugadores borrachos que es un jugador menos ya que el juego pararia a tener un solo jugador en la partida
	 * */
	private Jugador[] jugadorBorracho = new Jugador[3];
	/**
	 * El maximo nivel de borrachera que es soportado por el jugador
	 * */
	private final int MAXALCOHOL = 100;
	/**
	 * numero de jugadores que se encuentran en juego(no han tenido comaetilico)
	 * */
	private int numeroJugadores;
	
	/**
	 * Constructor de la clase
	 * @param jugador, cada jugador que particira el en la partida y sera asignado a cada espacio del vector Jugador
	 * */
	Partida(Jugador jugador1, Jugador jugador2, Jugador jugador3, Jugador jugador4) {
		jugadores[0] = jugador1;
		jugadores[1] = jugador2;
		jugadores[2] = jugador3;
		jugadores[3] = jugador4;
		setNumeroJugadores(jugadores.length);
	}
	
	/**
	 * @return mensaje del ranking
	 * */
	String jugar() {
		do {
			System.out.println(ronda());
		} while (DeseaContinuar.deseaContinuar("Otra ronda?(s/n)") && getNumeroJugadores() != 1 );
		return ranking();

	}
	/**
	 * RANKING DE LA PARTIDA QUE MUESTRA QUIEN HA GANADO
	 * @return ranking o resultado de la partida
	 * */
	private String ranking() {
		String cadena = "\t\tRANKING";
		for (int i = 0; i < jugadores.length; i++) {
			cadena += "\n----------------------------------------";
			if (jugadores[i] != null)
				cadena += "\n" + jugadores[i].getNombre() + "---" + jugadores[i].getAlcoholSangre() + "%\n"
						+ "Rondas Jugadas : " + jugadores[i].getRondasJugadas() + "\n";
			else if (i > 0) {
				cadena += "\n" + jugadorBorracho[i - 1].getNombre() + "---" + jugadorBorracho[i - 1].getAlcoholSangre()
						+ "%\n" + "Rondas Jugadas : " + jugadorBorracho[i - 1].getRondasJugadas() + "-ComaEticlico-"
						+ "\n";
			} else {
				cadena += "\n" + jugadorBorracho[i].getNombre() + "---" + jugadorBorracho[i].getAlcoholSangre() + "%\n"
						+ "Rondas Jugadas : " + jugadorBorracho[i].getRondasJugadas() + "-ComaEticlico-" + "\n";
			}
		}
		if (ganador().getAlcoholSangre() > MAXALCOHOL)
			cadena += "No ha ganado nadie";
		else
			cadena += "\nHa ganado: " + ganador().getNombre();
		return cadena;
	}
	
	/**
	 * GENERA UNA BEBIDA Y UN JUGADOR DE FORMA ALEATORIA Y CONTROLA QUE NO SE GENERE UN JUGADOR SI YA ESTA BORRACHO
	 * @return mensaje de la ronda.
	 * */
	private String ronda() {
		String cadena = "";
		numeroRonda++;
		int idJugador;
		cadena += "RONDA " + numeroRonda + "\n";
		
		Bebida bebida = Bebida.values()[(int) Math.round(Math.random() * (Bebida.values().length - 1))];
		
		do {
			idJugador = (int) Math.round(Math.random() * (jugadores.length - 1));
		} while (getNumeroJugadores() != 1 && jugadores[idJugador] == null);
		
		if (jugadores[idJugador] != null && jugadores[idJugador].getAlcoholSangre() >= MAXALCOHOL) {
			cadena += "Se encuentra con coma etilico :  " + jugadores[idJugador].getNombre() + "\n";
			if (idJugador > 0)
				jugadorBorracho[idJugador - 1] = jugadores[idJugador];
			jugadores[idJugador] = null;
			setNumeroJugadores(getNumeroJugadores() - 1);
		} else if (jugadores[idJugador] != null) {
			jugadores[idJugador].incrementarJugadas();
			jugadores[idJugador].incrementarAlcohol(bebida.getGrado());
			cadena += "Ha bebido : " + " " + jugadores[idJugador].getNombre() + " (" + bebida.name() + ")\n";
		}
		cadena += dibujarJugador();
		return cadena;

	}
	/**
	 * INDICA QUIEN ES EL JUGADOR GANADOR
	 * @return jugador ganador
	 * */
	private Jugador ganador() {
		Jugador jugadorGanador;
		int j=0;
		do{
			jugadorGanador = jugadores[j];
			j++;
		}while(jugadorGanador==null && j<jugadores.length);
		
		for (int i = 0; i < jugadores.length; i++) {
			if (jugadores[i] != null && jugadores[i].getAlcoholSangre() < jugadorGanador.getAlcoholSangre())
				jugadorGanador = jugadores[i];
			else if (i > 0)
				if (jugadorBorracho[i - 1] != null
						&& jugadorBorracho[i - 1].getAlcoholSangre() < jugadorGanador.getAlcoholSangre())
					jugadorGanador = jugadorBorracho[i - 1];
		}
		return jugadorGanador;
	}
	
	/**
	 * Dibuja los jugadores que se encuentran en juego(no estan borracho)
	 * @return dibujo de jugadores
	 * */
	private String dibujarJugador() {
		String cadena = "";
		for (int i = 0; i < getNumeroJugadores(); i++) {
			cadena += "\n   o\n--[]--\n  /\\";
		}
		return cadena;
	}
	
	/**
	 * @return numero de jugadores en juego
	 * */
	private int getNumeroJugadores() {
		return numeroJugadores;
	}
	
	/**
	 * asigna el nuemero de jugadores en juego
	 * @param numeroJugadores, a asignar
	 * */
	private void setNumeroJugadores(int numeroJugadores) {
		this.numeroJugadores = numeroJugadores;
	}
}
