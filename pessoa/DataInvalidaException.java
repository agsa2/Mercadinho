package pessoa;

public class DataInvalidaException extends Exception{
	
	public DataInvalidaException(int data) {
		super (data + " está fora do padrão. Note que o formato deve ser dd/mm/aaaa, onde: "
				+ "\n'dd' coresponde a dia E é um valor entre 1 e 31"
				+ "\n'mm' corresponde a mês E é um valor entre 1 e 12"
				+ "\n'aaaa' corresponde a ano NÃO pode ser um valor maior que 2018."
				+ "\nAlém disso preste atenção nos meses que não têm 31 dias");
	}

}
