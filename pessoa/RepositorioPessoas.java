package pessoa;

// INTERFACE NEGÓCIO-DADOS QUE VAI SER USADA PELAS CLASSES COLEÇÃO DE DADOS. =)

public interface RepositorioPessoas {

	public void inserir(Pessoa pessoa) throws PessoaJaCadastradaException;

	public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException;

	public void remover(String cpf) throws PessoaNaoEncontradaException;

	public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException;

	public boolean existir(String cpf);

}
