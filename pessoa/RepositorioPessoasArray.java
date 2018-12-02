package pessoa;

public class RepositorioPessoasArray implements RepositorioPessoas {

	private Pessoa[] pessoas;
	private int indice;

	public RepositorioPessoasArray() {
		this.pessoas = new Pessoa[50];
		this.indice = 0;
	}

	// Corrigido
	public void inserir(Pessoa pessoa) {

		if (indice < 50) {
			this.pessoas[indice] = pessoa;
			indice = indice + 1;
		}

	}

	// Corrigido
	public Pessoa procurar(String cpf) {
		Pessoa p = null;
		boolean find = false;
		for (int i = 0; i < this.indice && !find; i++) {
			if (this.pessoas[i].getCpf().equals(cpf)) {
				p = this.pessoas[i];
				find = true;
			}
		}
		return p;
	}

	// Corrigido
	public void remover(String cpf) {
		boolean find = false;
		for (int i = 0; i < this.indice && !find; i++) {
			if (this.pessoas[i].getCpf().equals(cpf)) {
				this.indice = this.indice - 1;
				this.pessoas[i] = this.pessoas[this.indice];
				this.pessoas[this.indice] = null;
				find = true;
			}
		}
	}

	// Corrigido
	public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException {
		boolean find = false;
		for (int i = 0; i < indice; i++) {
			if (this.pessoas[i].getCpf().equals(pessoa.getCpf())) {
				this.pessoas[i] = pessoa;
				find = true;
			}
		}

	}

	public boolean existir(String cpf) {
		boolean find = false;
		for (int i = 0; i < indice; i++) {
			if (pessoas[i].getCpf().equals(cpf)) {
				find = true;
			}
		}
		return find;
	}

}
