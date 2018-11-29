package pessoa;

public class PessoaJaCadastradaException extends Exception{
	
	public PessoaJaCadastradaException() {
		super ("Já existe uma pessoa que corresponde ao CPF informado. Verifique os dados informados.");
	}

}
