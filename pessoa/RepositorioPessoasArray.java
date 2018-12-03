package pessoa;

// CLASSE COLEÇÃO DE DADOS 1

public class RepositorioPessoasArray implements RepositorioPessoas {

	private Pessoa[] pessoas;
	private int indice;
	
	
	// Inicia os atributos do Array
	public RepositorioPessoasArray() {
		this.pessoas = new Pessoa[50];
		this.indice = 0;
	}

	// Inserir PESSOA no Array "enquanto" o indice for menor que 50.
	public void inserir(Pessoa pessoa) {

		if (this.indice < 50) {
			this.pessoas[this.indice] = pessoa;
			this.indice = this.indice + 1;
		}

	}

	// Procura pelo ATRIBUTO.
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

	// Também REMOVE pelo ATRIBUTO
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
	public void atualizar(Pessoa pessoa) {
		boolean find = false;
		for (int i = 0; i < this.indice; i++) {
			if (this.pessoas[i].getCpf().equals(pessoa.getCpf())) {
				this.pessoas[i] = pessoa;
				find = true;
			}
		}

	}

	public boolean existir(String cpf) {
		boolean find = false;
		for (int i = 0; i < this.indice && !find; i++) {
			if (this.pessoas[i].getCpf().equals(cpf)) {
				find = true;
			}
		}
		return find;
	}

}
