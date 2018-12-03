package pessoa;

// CLASSE FACHADA.
// Receberá 5 atributos "Cadastro".

public class Fachada {

	// Atributo de "Cadastro Pessoa"
	private CadastroPessoas cadastroPessoa;

	public Fachada(RepositorioPessoas repositorioPessoa) { // Vai iniciar a classe fachada.
		this.cadastroPessoa = new CadastroPessoas(repositorioPessoa);
	}

	public void cadastrarPessoa(Pessoa pessoa) throws PessoaJaCadastradaException, PessoaNaoEncontradaException, 
		CPFInvalidoException, TelefoneInvalidoException, DataInvalidaException {
		this.cadastroPessoa.cadastrar(pessoa);
	}

	public void removerPessoa(String cpf) throws PessoaNaoEncontradaException, PessoaJaCadastradaException {
		this.cadastroPessoa.remover(cpf);
	}

	public void procurarPessoa(String cpf) throws PessoaNaoEncontradaException, PessoaJaCadastradaException {
		this.cadastroPessoa.procurar(cpf);
	}

	public void atualizarPessoa(Pessoa pessoa) throws PessoaNaoEncontradaException, PessoaJaCadastradaException {
		this.cadastroPessoa.atualizar(pessoa);
	}

	// Baseado no exemplo de "Descrição Pessoa" de Lucas Rufino
	
	public String imprimirPessoa(String cpf) throws PessoaNaoEncontradaException, PessoaJaCadastradaException {
		
		// Mostrando o metodo "PROCURAR"
		Pessoa pessoa = this.cadastroPessoa.procurar(cpf);

		String print = "Nome: " + pessoa.getNome() 
				+ "\nCPF: " + pessoa.getCpf().substring(0, 3) + "." + pessoa.getCpf().substring(3, 6) + "." + pessoa.getCpf().substring(6, 9) + "." + pessoa.getCpf().substring(9, 11) 
				+ "\nEndereço: " + pessoa.getEndereco()
				+ "\nNascimento: " + pessoa.getDiaNascimento() + "/" + pessoa.getMesNascimento() + "/" + pessoa.getAnoNascimento() 
				+ "\nTelefone: +55 81 " + pessoa.getTelefone().substring(0, 5) + "-" + pessoa.getTelefone().substring(5, 9);
				
				if (pessoa.getGenero() == 'N') {
					print = print + "\nGênero: Não Informado \n";
				}
				else if (pessoa.getGenero() == 'M') {
					print = print + "\nGênero: Masculino \n";
				}
				else {
					print = print + "\nGênero: Feminino \n";
				}
				
				
			
		if (pessoa instanceof Funcionario) { // O "instanceof" vai pegar o atributo *pessoa* e verificar se ele pertence a Classe "Funcionário"
											// Caso seja *true* vai imprimir tudo que imprime com *Pessoa* + o que tá ai embaixo: *-*
			
			print = print + "Cargo: " +((Funcionario)pessoa).getCargo()
					+ "\nSalário: R$ " + ((Funcionario)pessoa).getSalario()
					+ "\nMatrícula do Funcionário: " + ((Funcionario)pessoa).getId() 
					+ "\nSituação: " + ((Funcionario)pessoa).getSituacao() + "\n"; 
		}
		else if (pessoa instanceof Cliente) { // Ou nesse caso, a classe "Cliente"
			print = print + "Tipo de Pagamento: " + ((Cliente)pessoa).getTipoPagamentoUsado() 
					+ "\nTipo de Produto Preferido: " + ((Cliente)pessoa).getProdutoPreferido()
					+ "\nEmail do Cliente: " + ((Cliente)pessoa).getEmail() + "\n";
		}
		
		return print;

	}

}
