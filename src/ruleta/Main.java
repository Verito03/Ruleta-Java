package ruleta;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static int jugadores=3;
	public static int rondas = 4; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//VARIABLES

		Scanner sc = new Scanner(System.in);
		ArrayList <Jugador> arrayJugadores = new ArrayList <Jugador>();
		int jugador =0;
		int panel = 0;

		//INSERTAR JUGADORES 

		for(int i=1;i<=jugadores;i++) {
			arrayJugadores.add( new Jugador(0,i));
			System.out.println("Se ha añadido el jugador " + i);
		}
		
		//COMIENZO DEL JUEGO 
		
		do {
			
			//DAR VALOR A FRASE Y PISTA 
			
			System.out.println("--- PRESENTADOR ---");
			System.out.println("Estamos en la ronda: " + (panel+1));
			System.out.println("Ingresa la frase deseada: ");
			String frase = sc.nextLine();

			System.out.println("Ingrese la pista para esta frase: ");
			String pista = sc.nextLine();
			System.out.println("-----------------------------");
			panel++;

			//FRASE OCULTA

			String asteriscos = convertirFrase(frase);

			System.out.println("FRASE: ");
			System.out.println(asteriscos);
			System.out.println("PISTA:");
			System.out.println(pista);

			//EMPIEZA LOS PANELES

			while (asteriscos.contains("*")) {
				int valorRuleta=tirarRuleta(arrayJugadores, jugador);
				imprimirRuleta();
				System.out.println("Esta jugando el jugador: "+ (jugador+1));
				System.out.println("La ruleta ha caido en: " + valorRuleta);
				if(valorRuleta==7){
					System.out.println("Has caído en la quiebra. Pierdes el turno y todo tus puntos");
					arrayJugadores.get(jugador).setDinero(0);
				}else {
					
					//PEDIMOS SI QUIERE RESOLVER O DECIR UNA LETRA
					
					System.out.println("¿Desea resolver o dar una letra? (Resolver/Letra)");
					String opcion=sc.nextLine();

					if(opcion.equalsIgnoreCase("resolver")) {
						System.out.println("¿Cuál es la respuesta del panel?: ");
						String respuesta = sc.nextLine();
						if(respuesta.equalsIgnoreCase(frase)) {
							arrayJugadores.get(jugador).setDinero(arrayJugadores.get(jugador).getDinero()+valorRuleta);
							System.out.println("El dinero del jugador "+(jugador+1)+" es "+arrayJugadores.get(jugador).getDinero());
							System.out.println("FELICIDADES, HAS RESUELTO EL PANEL");
							break;
						}else {
							System.out.println("La respuesta es incorrecta. Se pasa el turno al siguiente jugador");
							jugador++;
							if (jugador>=jugadores) {
								jugador=0;
							}
						}
					}else if(opcion.equalsIgnoreCase("letra")) {
						System.out.println("¿Qué letra eliges?");
						String letra = sc.nextLine();

						if(letra.length() != 1) {
							System.out.println("Introduce una sola letra");
						}
						char letraChar = letra.charAt(0);
						if(frase.contains(letra)) {
							System.out.println("Enhorabuena, la frase contiene esa letra");

							// ACTUALIZAMOS LA FRASE OCULTA
							
							asteriscos = revelarLetras(frase, asteriscos, letraChar, arrayJugadores,jugador,valorRuleta);
						}else {
							System.out.println("La frase no contiene esa letra");
							jugador++;
							if (jugador>=jugadores) {
								jugador=0;
							}
						}
					}
				}
				System.out.println("FRASE: " + asteriscos);
			}
			
		}while(panel < rondas);
		ganador(arrayJugadores);
	}

	public static void imprimirRuleta() {
		System.out.println("    ***************    ");
		System.out.println("   *       50      *   ");
		System.out.println("  *                 *  ");
		System.out.println(" *  25          75   * ");
		System.out.println("*                     *");
		System.out.println("* Quiebra        100  *");
		System.out.println(" *                   * ");
		System.out.println("  *  0          150 *  ");
		System.out.println("   *               *   ");
		System.out.println("    *      50     *    ");
		System.out.println("     *************     ");
	}

	public static String convertirFrase(String frase) {
		String resultado = "";
		for(int i=0; i<frase.length();i++) {
			if(frase.charAt(i)== ' ') {
				resultado += ' ';
			} else {
				resultado += '*';
			}
		}
		return resultado;
	}

	public static String revelarLetras(String frase, String oculta, char letra, ArrayList <Jugador> arrayJugadores, int jugador,int valorRuleta) {

		//CONVERTIMOS EL STRING A CHAR CON ARRAY
		
		int contarLetra=0;
		int totalJugador;
		char[] resultado = null;
		if(valorRuleta==7) {
			System.out.println("pierdes el turno y tu dinero vuelve a 0");
		}else {
			resultado = oculta.toCharArray();
			for(int i=0; i < frase.length(); i++) {
				if(frase.charAt(i) == letra) {
					contarLetra++;
					resultado[i] = letra;	
				}
			}
		}
		totalJugador=contarLetra*valorRuleta;
		arrayJugadores.get(jugador).setDinero(arrayJugadores.get(jugador).getDinero()+totalJugador);
		System.out.println("el dinero del jugador "+(jugador+1)+" es "+arrayJugadores.get(jugador).getDinero());


		//CONVERTIMOS EL CHAR A STRING OTRA VEZ
		
		return new String(resultado);
	}
	public static int tirarRuleta(ArrayList <Jugador> arrayJugadores, int jugador) {
		Random rn = new Random ();
		int valor=0;
		int tirada= rn.nextInt(1,8);
		if(tirada==1) {
			valor= 0;
		}else if(tirada==2) {
			valor=25;
		}else if (tirada==3) {
			valor=50;
		}else if(tirada==4) {
			valor=75;
		}else if(tirada==5) {
			valor=100;
		}else if(tirada==6) {
			valor=150;
		}else if(tirada==7){
			valor=0;
			arrayJugadores.get(jugador).setDinero(0);
		}
		return valor;
	}

	public static  void ganador(ArrayList <Jugador> arrayJugadores) {
		int posicion=0;
		int max=0;
		for (Jugador j : arrayJugadores) {
			if(j.getDinero()>max) {
				max=j.getDinero();
				posicion++;
			}
		}
		int ganador=max;
		System.out.println("el ganador es el jugador"+posicion+" con un total de "+ganador+" puntos");
	}
}
