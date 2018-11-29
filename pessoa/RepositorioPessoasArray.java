package pessoa;

public class RepositorioPessoasArray implements RepositorioPessoas {

	private Pessoa[] pessoas;
	private int indice;

	public RepositorioPessoasArray() {
		this.pessoas = new Pessoa[200];
		this.indice = 0;
	}
	// Corrigido
	public void inserir(Pessoa pessoa) {
		if (this.indice <= this.pessoas.length) {

			this.pessoas[indice] = pessoa;
			indice = indice + 1;
		}
	}

	// Corrigido
	public Pessoa procurar(String cpf) {
		Pessoa p = null;

		for (int i = 0; i < this.indice; i++) {
			if (this.pessoas[i].getCpf().equals(cpf)) {
				p = pessoas[i];
			}
		}
		return p;
	}

	// Corrigido
	public void remover(String cpf) {
		boolean find = false;
		for (int i = 0; i < this.indice; i++) {
			if (pessoas[i].getCpf().equals(cpf)) {
				indice = indice - 1;
				this.pessoas[i] = this.pessoas[indice];
				this.pessoas[i] = null;
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
