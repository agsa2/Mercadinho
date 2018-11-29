package pessoa;

public class Fachada {

	private CadastroPessoas cadastro;

	public Fachada(RepositorioPessoas repositorio) {
		this.cadastro = new CadastroPessoas(repositorio);
	}

	public void cadastrarPessoa(Pessoa pessoa) throws PessoaJaCadastradaException, PessoaNaoEncontradaException, ValorInvalidoException {
		this.cadastro.cadastrar(pessoa);
	}

	public void remover(String cpf) throws PessoaNaoEncontradaException, PessoaJaCadastradaException {
		this.cadastro.remover(cpf);
	}

	public void procurar(String cpf) throws PessoaNaoEncontradaException, PessoaJaCadastradaException {
		this.cadastro.procurar(cpf);
	}

	public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException, PessoaJaCadastradaException {
		this.cadastro.atualizar(pessoa);
	}

	// Baseado no exemplo de "Descrição Pessoa de Lucas Rufino"
	public String descricaoPessoa(String cpf) throws PessoaNaoEncontradaException, PessoaJaCadastradaException {
		Pessoa pessoa = this.cadastro.procurar(cpf);

		String s = "Nome: " + pessoa.getNome() + "\nCPF: " + pessoa.getCpf() + "\nEndereço: " + pessoa.getEndereco()
				+ "\nNascimento: " + pessoa.getNascimento() + "\nTelefone: " + pessoa.getTelefone();

		return s;

	}

}
