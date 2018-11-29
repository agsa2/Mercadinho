package pessoa;

public class Programa {

	public static void main(String[] args) {

		Pessoa cliente = null;
		RepositorioPessoas rep = null;
		Fachada fac = null;

		fac = new Fachada(rep);

	}

}
