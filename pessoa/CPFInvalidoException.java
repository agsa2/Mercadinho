package pessoa;

public class CPFInvalidoException extends Exception {
	
	public CPFInvalidoException (String cpf) {
		super (cpf + " está fora do padrão. Note que\no CPF DEVE conter apenas número e OBRIGATÓRIAMENTE 11 dígitos.");
	}
}
