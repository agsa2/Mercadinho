package pessoa;

public class CadastroPessoas {

	private RepositorioPessoas repoPessoas;
	
	public CadastroPessoas(RepositorioPessoas repo) {
		this.repoPessoas = repo;
	}
	// Adicionar mais exceções
	public void cadastrar(Pessoa pessoa) throws PessoaJaCadastradaException, PessoaNaoEncontradaException, ValorInvalidoException {
		if (this.repoPessoas.procurar(pessoa.getCpf()) == null) {
			this.repoPessoas.inserir(pessoa);
		} else {
			throw new PessoaJaCadastradaException();
		}
	}

	public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException, PessoaJaCadastradaException {
		if (this.repoPessoas.procurar(pessoa.getCpf()) != null) {
			this.repoPessoas.atualizar(pessoa);
		}else {
			throw new PessoaNaoEncontradaException();
		}
	}

	// Adaptado
	public void remover(String cpf) throws PessoaNaoEncontradaException, PessoaJaCadastradaException {
		if(this.repoPessoas.procurar(cpf) != null) {
			this.repoPessoas.remover(cpf);
		}else {
			throw new PessoaNaoEncontradaException();
		}
	}
	
	// Adaptado
	public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException, PessoaJaCadastradaException {
		Pessoa pessoa = this.repoPessoas.procurar(cpf);
		if(pessoa == null) {
			throw new PessoaNaoEncontradaException();
		}else {
			return pessoa;
		}
	}

}
