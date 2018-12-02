package pessoa;

public class RepositorioPessoasLista implements RepositorioPessoas {

	private Pessoa pessoa;
	private RepositorioPessoasLista next;

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public RepositorioPessoasLista getNext() {
		return this.next;
	}

	public RepositorioPessoasLista() {
		this.pessoa = null;
		this.next = null;
	}

	// Metodo para inserir uma pessoa na Lista

	public void inserir(Pessoa pessoa) {
		if (this.pessoa == null) {
			this.pessoa = pessoa;
			next = new RepositorioPessoasLista();
		} else {
			this.next.inserir(pessoa);
		}
	}

	public Pessoa procurar(String cpf) {

		Pessoa person;
		if (this.next == null) {
			person = null;
		} else if (this.pessoa.getCpf().equals(cpf)) {
			person = this.pessoa;
		} else {
			person = this.next.procurar(cpf);
		}
		return person;

	}

	public void atualizar(Pessoa pessoa)  {
		if(this.pessoa.getCpf().equals(pessoa.getCpf())) {
			this.pessoa = pessoa;
		}
		else {
			this.next.atualizar(pessoa);
		}
	}

	public void remover(String cpf) {
		if (this.pessoa.getCpf().equals(cpf)) {
			this.pessoa = this.next.pessoa;
			this.next = this.next.next;
		}else {
			this.next.remover(cpf);
		}
	}

	public boolean existir(String cpf) {
		boolean find = false;
		if (this.pessoa.getCpf().equals(cpf)) {
			find = true;
		} else {
			this.next.existir(cpf);
		}
		return find;
	}

}
