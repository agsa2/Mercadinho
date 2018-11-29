package pessoa;

public class PessoaNaoEncontradaException extends Exception{
	
	public PessoaNaoEncontradaException() {
		super ("Não existe pessoa que corresponde ao CPF informado.");
	}

}
