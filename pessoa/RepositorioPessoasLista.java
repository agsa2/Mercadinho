package pessoa;

public class RepositorioPessoasLista implements RepositorioPessoas {

	private Pessoa pessoa;
	private RepositorioPessoasLista next;

	public RepositorioPessoasLista() {
		this.pessoa = null;
		this.next = null;
	}

	public void inserir(Pessoa pessoa) {
		if (this.pessoa == null) {
			this.pessoa = pessoa;
			next = new RepositorioPessoasLista();
		} else {
			this.next.inserir(pessoa);
		}
	}

	public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException {
		Pessoa pessoa = null;
		if (this.pessoa != null) {
			if (this.pessoa.getCpf().equals(cpf)) {
				pessoa = this.pessoa;
			} else {
				this.next.procurar(cpf);
			}
		}
		if (this.pessoa == null) {
			throw new PessoaNaoEncontradaException();
		} else {
			return pessoa;
		}
	}

	public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException {
		if (this.pessoa != null) {
			if (this.pessoa.getCpf().equals(pessoa.getCpf())) {
				this.pessoa = pessoa;
			} else {
				this.next.atualizar(pessoa);
			}
		} else {
			throw new PessoaNaoEncontradaException();
		}
	}

	public void remover(String cpf) throws PessoaNaoEncontradaException {
		if (this.pessoa != null) {
			if (this.pessoa.getCpf().equals(cpf)) {
				this.pessoa = this.next.pessoa;
				this.next = this.next.next;
			} else {
				this.next.remover(cpf);
			}
		} else {
			throw new PessoaNaoEncontradaException();
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
