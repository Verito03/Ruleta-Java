package ruleta;

public class Presentador {
	
	//VARIABLES
	
	private String frase;
	private String pista;
	
	//GETTERS Y SETTERS
	
	public String getFrase() {
		return frase;
	}
	public void setFrase(String frase) {
		this.frase = frase;
	}
	public String getPista() {
		return pista;
	}
	public void setPista(String pista) {
		this.pista = pista;
	}
	
	//CONSTRUCTORES
	
	public Presentador(String frase, String pista) {
		super();
		this.frase = frase;
		this.pista = pista;
	}
	Presentador () {
		
	}
}
