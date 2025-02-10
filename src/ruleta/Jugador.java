package ruleta;

public class Jugador {
	
	//VARIABLES 
	
	private int dinero;
	private int numero;

	//CONSTRUCTORES
	
	Jugador(){	
	}
	public Jugador(int dinero, int numero) {
		this.dinero = dinero;
		this.numero = numero;
	}
	
	//GETTERS Y SETTERS
	
	public int getDinero() {
		return dinero;
	}
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
}
