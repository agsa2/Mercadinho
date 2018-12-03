package pessoa;

//CLASSE COLEÇÃO DE DADOS 2

public class RepositorioPessoasLista implements RepositorioPessoas {

	private Pessoa pessoa;
	private RepositorioPessoasLista next;

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public RepositorioPessoasLista getNext() {
		return this.next;
	}

	// Aqui "starta" os atributos.
	
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
	// Método para procurar uma determinada pessoa pelo seu CPF
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
	
	// Atualizar que recebe o OBJETO pessoa.
	public void atualizar(Pessoa pessoa)  {
		if(this.pessoa.getCpf().equals(pessoa.getCpf())) {
			this.pessoa = pessoa;
		}
		else {
			this.next.atualizar(pessoa);
		}
	}
	
	// Remove uma pessoa pelo ATRIBUTO identificador.
	public void remover(String cpf) {
		if (this.pessoa.getCpf().equals(cpf)) {
			this.pessoa = this.next.pessoa;
			this.next = this.next.next;
		}else {
			this.next.remover(cpf);
		}
	}
	// Não sei se tá certo e esqueci de perguntar pra algum monitor... =( Mas...
	
	// Se o CPF da pessoa for igual ao CPF passado como parametro retorna true, caso não seja
	// chama o próximo.
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
