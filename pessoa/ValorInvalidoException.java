package pessoa;

public class ValorInvalidoException extends Exception{
	public ValorInvalidoException() {
		super ("Valor fornecido não era esperado e por esse motivo aconteceu um erro, tente novamento!");
	}

}
