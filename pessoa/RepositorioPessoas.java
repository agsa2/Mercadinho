package pessoa;

public interface RepositorioPessoas {

	public void inserir(Pessoa pessoa);

	public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException;

	public void remover(String cpf) throws PessoaNaoEncontradaException;

	public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException, PessoaJaCadastradaException;

	public boolean existir(String cpf);

}
