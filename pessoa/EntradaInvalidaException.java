package pessoa;

public class EntradaInvalidaException extends Exception{
	
	public EntradaInvalidaException() {
	super ("O valor digitado é inválido. Escolha 1 para Repositório Array ou 2 para Repositório Lista.");
	}
}
