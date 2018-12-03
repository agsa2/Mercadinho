package pessoa;

//COLEÇÃO DE NEGÓCIO

public class CadastroPessoas {
	
	// Repositório de pessoa.
	private RepositorioPessoas peopleRep;
	
															// MÉTODO
	public CadastroPessoas(RepositorioPessoas peopleRep) { // Aqui vai startar os atributos da classe *CadastroPessoa*
		this.peopleRep = peopleRep;
	}
	
	// Métodos CADASTRAR, ATUALIZAR, REMOVER E PROCURAR.
	
	public void cadastrar(Pessoa pessoa) throws PessoaJaCadastradaException, PessoaNaoEncontradaException, 
		CPFInvalidoException, TelefoneInvalidoException, DataInvalidaException { // Aqui vai cadastrar uma pessoa no repositório
																				 // Caso o CPF não exista ainda, primeiro vai verificar se:
																				 // Os dados da *pessoa* está OK se tiver vai cadastrar, caso não
																				 // lança uma exceção referente ao *Dado Errado* ou *Que a pessoa já 
																				 // existe se os dados estiverem corretos.
		
		if (this.peopleRep.procurar(pessoa.getCpf()) == null) {
			this.validar(pessoa);
			this.peopleRep.inserir(pessoa);
		} else {
			throw new PessoaJaCadastradaException();
		}
	}

	public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException, PessoaJaCadastradaException {
		
		if (this.peopleRep.procurar(pessoa.getCpf()) != null) {
			this.peopleRep.atualizar(pessoa);
		}else {
			throw new PessoaNaoEncontradaException();
		}
	}

	public void remover(String cpf) throws PessoaNaoEncontradaException, PessoaJaCadastradaException {
		
		if(this.peopleRep.procurar(cpf) != null) {
			this.peopleRep.remover(cpf);
		}else {
			throw new PessoaNaoEncontradaException();
		}
	}
	
	public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException, PessoaJaCadastradaException {
		
		Pessoa pessoa = this.peopleRep.procurar(cpf);
		if(pessoa == null) {
			throw new PessoaNaoEncontradaException();
		}else {
			return pessoa;
		}
	}
	
	// Teste de validação baseado no exemplo código feito por Lucas Rufino.
	// PS: O "Teste de validação" é a parte do CPF e do Telefone que eu usei o MÉTODO "matches"
	
	public void validar(Pessoa pessoa) throws CPFInvalidoException, TelefoneInvalidoException, 
			DataInvalidaException{
		
		// Usando o "matches" pra validar CPF e TELEFONE. 
		
		if (!pessoa.getCpf().matches("[0-9]{11}")) { // CPF só pode ter número e deve obrigatoriamente possuir 11 caracteres. 
			throw new CPFInvalidoException(pessoa.getCpf());		 
			
		} else if (!pessoa.getTelefone().matches("[0-9]{8,11}")) { // Telefone só pode ter números e deve ter no mínimo 8 digitios e no max 15
			throw new TelefoneInvalidoException(pessoa.getTelefone());
		
		// Começo validação data de Nascimento
			// Eu imagino que podia validar de uma forma mais simples, mas essa funcionou. Sorry qualquer coisa. =)  
			
		} else if (pessoa.getAnoNascimento() > 2018 || pessoa.getAnoNascimento() <= 0) {
			throw new DataInvalidaException(pessoa.getAnoNascimento()); // Não é possível nascer um ano ou mais depois do ano atual. Não que eu saiba :3
													 					// Sim, é possível que alguém do ano 1 d.C se cadastre no sistema, 
																		// mas é possível alterar depois	
			
			
		} else if (pessoa.getMesNascimento() < 1 || pessoa.getMesNascimento() > 12) { // Considera apenas meses "reais", ou seja de Jan - Dez.
			throw new DataInvalidaException(pessoa.getMesNascimento());
		
			
			
		} else if (pessoa.getMesNascimento() == 2) { // Quando o ano for bissexto e a pessoa tiver nascido em FEV 
													// o dia só vai até 29. Caso não seja bissexto até dia 28 :)
			
			if((pessoa.getAnoNascimento() % 4 == 0 && pessoa.getAnoNascimento() % 100 != 0) || (pessoa.getAnoNascimento() % 400 == 0)) {
				if(pessoa.getDiaNascimento() > 29) {
					throw new DataInvalidaException(pessoa.getDiaNascimento());  
				}
			}else { // 
				if (pessoa.getDiaNascimento() > 28) {
					throw new DataInvalidaException(pessoa.getDiaNascimento());
				}
			}
			
		} else if ((pessoa.getMesNascimento() != 2) && (pessoa.getMesNascimento() == 4 || pessoa.getMesNascimento() == 6 // Considera os meses que têm só 30 dias
				|| pessoa.getMesNascimento() == 9 || pessoa.getMesNascimento() == 11)) {
			
			if (pessoa.getDiaNascimento() > 30) {
				throw new DataInvalidaException(pessoa.getDiaNascimento());
			}
		
			
		} else if ((pessoa.getMesNascimento() != 2) && (pessoa.getMesNascimento() == 1 || pessoa.getMesNascimento() == 3 
				|| pessoa.getMesNascimento() == 5 || pessoa.getMesNascimento() == 7 || pessoa.getMesNascimento() == 8
				|| pessoa.getMesNascimento() == 10 || pessoa.getMesNascimento() == 12)){ // Considera meses que vão até 31 dias
			
			if (pessoa.getDiaNascimento() > 31) {
				throw new DataInvalidaException(pessoa.getDiaNascimento());
			}
			// Fim da validação de DATA DE NASCIMENTO. Que negócio enorme... =( Desculpa gente, quando eu pensei nisso achei que ia ser pequeno.
		} 
		
	}

}
