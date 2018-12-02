package pessoa;

public class TelefoneInvalidoException extends Exception{
	
	public TelefoneInvalidoException(String telefone) {
		super (telefone + " está fora do padrão. Telefone deve conter apenas números e ter entre 8 e 10 digitos.");
	}
}
