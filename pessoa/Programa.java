package pessoa;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		Pessoa pessoa1 = null;
		Pessoa pessoa2 = null;
		Pessoa funcionario = null;
		Pessoa cliente = null;

		RepositorioPessoas personRep = null;
		Fachada fachada = null;

		String choice = null;
		int contador = 1;
		int start = 4;
		int end = 4;
		
		// Implementar método existir

		int ok = 0;

		System.out.println("Você está entrando no Sistema do Supermercado Pão Doce... \n");
		
		while (start > 1) {
			start = start - 1;
			System.out.print(start + "... ");
			try {
				new Thread().sleep(2000);
			} catch (Exception e) {
				System.out.println("Shit!!");
			}
		}
		
		while (ok == 0) {
			try {
				
				System.out.println("\nBem-vindo ao Sistema do Supermercado Pão Doce!!! "
						+ "\n\nEscolha a forma que deseja armazenar seus dados: "
						+ "\n1. Repositório Array \n2. Repositório Lista \n3. Cancelar e Sair");
				
				choice = in.next();

				if (choice.length() > 1 || (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"))) {
					throw new EntradaInvalidaException();
				} else if (choice.equals("1")) {
					ok++;
					personRep = new RepositorioPessoasArray();
				} else if (choice.equals("2")) {
					ok++;
					personRep = new RepositorioPessoasLista();
				}else if (choice.equals("3")) {
					ok = -1;
					contador = 6;
					System.out.println("Saindo...");
					while (end > 1) {
						end = end - 1;
						System.out.print(end + "... ");
						try {
							new Thread().sleep(2000);
						} catch (Exception e) {
							System.out.println("Shit!!");
						}
					}
					System.out.println("\nBye bye! Até a próxima!");
					
				}

				fachada = new Fachada(personRep);
			} catch (EntradaInvalidaException e) {
				System.out.println(e.getMessage());
			}
		}

		while (contador <= 5) {

			try {
				
				// Mostrando o metodo "CADASTRAR".
				// Duas pessoas diretamente.
				// Um Cliente
				// Um Funcionario
				
				if (contador == 1) {
					pessoa1 = new Pessoa("11122313444", "Leonardo DiCaprio", 3, 11, 2017, "Queen's Street", "998715619", 'M');

					
					pessoa2 = new Pessoa("12345678910", "Daenerys Targaryen", 30, 11, 2015, "King's Street", "998795611", 'F');
					  
					funcionario = new Funcionario("98745632100", "Felipe Gomes Lovato", 11, 1, 204, "Champs Elysees", 
							"974145630", 'M', 01, "Estoquista", 3894.98, "Ativo"); 
					
					cliente = new Cliente("40028922014", "Milena Farias Freitas", 3, 8, 1997, "Ladies Street", "944278823", 'F', "Cartão de Débito",
							"Doces", "milena@gmail.com");
					
					fachada.cadastrarPessoa(pessoa1);
					
					fachada.cadastrarPessoa(pessoa2); 
					
					fachada.cadastrarPessoa(funcionario);
					 
					fachada.cadastrarPessoa(cliente);
					

					System.out.println(fachada.imprimirPessoa(pessoa1.getCpf()));

					System.out.println(fachada.imprimirPessoa(pessoa2.getCpf()));
					  
					System.out.println(fachada.imprimirPessoa(funcionario.getCpf()));
					  
					System.out.println(fachada.imprimirPessoa(cliente.getCpf()));
					  
					} 
					
					// Mostrando o metodo "ATUALIZAR". 
				
					else if (contador == 2) {
					  
						System.out.println("\nAtualizando Nome, Telefone e Gênero de: " + pessoa2.getNome() + "\n");
						  
						Pessoa nPessoa = pessoa2; 
						
						nPessoa.setTelefone("987123692");
						nPessoa.setNome("Mac Johnny Depp"); 
						nPessoa.setGenero('M');
						
						fachada.atualizarPessoa(nPessoa);
						
						System.out.println(fachada.imprimirPessoa(nPessoa.getCpf()));
					  
					} 
					
					// Mostrando o metodo "REMOVER".
					
					else if (contador == 3) { 
						
						String del;
					  
						System.out.println("AVISO!! Você está prestes a apagar uma pessoa do sistema!");
						
						System.out.println("Excluir todos os dados de: " + pessoa2.getNome() + "? \n1.Sim  2.Não");
					  
						del = in.next();
						
						if (del.equals("1")) { 
							
							
							//fachada.remover("12345678910"); 
							fachada.removerPessoa(pessoa2.getCpf()); // Tanto faz passar o "CPF" diretamente ou usar o "GET" pra pega-lo. 
																	 // Removerá a pessoa "X" da mesma forma. =)
							
							System.out.println("\nDados Excluídos. \n");
							
							System.out.println(fachada.imprimirPessoa(pessoa2.getCpf())); // Vai procurar a pessoa que acabou de ser excluída 
																						  // E lançar a exceção pra mostrar que ela realmente foi 
																						  // removida. =) 
							
						} else {
							
							System.out.println("Você NÃO excluiu os dados referente a: " + pessoa2.getNome() + "\n");
							System.out.println(fachada.imprimirPessoa(pessoa2.getCpf())); // Canecela a remoçao da pessoa selecionada e 
																						  // Printa na tela pra mostrar que ela ainda EXISTE.
						} 
					}
				
					// Atualizar Funcionário
				
					else if (contador == 4) {
						
						String promover;
						
						System.out.println("\nFuncionario: " + funcionario.getNome() + " está prestes a ser promovido. \nTem certeza que quer continuar?\n");
						
						System.out.println("1.Promover  2.Desistir");
						promover = in.next();
						
						if(promover.equals("1")) {
						
						Funcionario nFuncionario = (Funcionario) funcionario;
						nFuncionario.setCargo("Gerente de Vendas");
						nFuncionario.setSalario(12874.99 );
						
						fachada.atualizarPessoa(nFuncionario);
						
						System.out.println(nFuncionario.getNome() + " acabou de ser promovido! \n");
						System.out.println(fachada.imprimirPessoa(funcionario.getCpf()));
						
						}
						else {
							System.out.println("Promoção cancelada.");
							System.out.println(fachada.imprimirPessoa(funcionario.getCpf()));
						}
						
					// Atualizar Cliente	
					} else if (contador == 5) {
						System.out.println("\nCliente: " + cliente.getNome() + " deseja alterar seu Nome, Email e seu Tipo de produto Preferido");
						
						String change;
						System.out.println("Permitir alteração? \n1.Sim  2.Não");
						
						change = in.next();
						
						if(change.equals("1")) {
							
							Cliente nCliente = (Cliente) cliente;
							nCliente.setNome("Milena Farias Ferreira");
							nCliente.setEmail("milena.ferreira@outlook.com");
							nCliente.setProdutoPreferido("Nenhum");
							
							fachada.atualizarPessoa(nCliente);
							
							System.out.println(nCliente.getNome() + " acabou de ter seus dados alterados!");
							System.out.println(fachada.imprimirPessoa("40028922014"));
						}
						else {
							System.out.println("Nenhum dado do cliente: " + cliente.getNome() + " foi alterado!");
							System.out.println(fachada.imprimirPessoa("40028922014"));
						}	
					}
				
			} catch (PessoaJaCadastradaException e) {
				System.out.println(e.getMessage());
			} 
			catch (PessoaNaoEncontradaException e) {
				System.out.println(e.getMessage());
			} 
			catch (CPFInvalidoException e) {
				System.out.println(e.getMessage());
			} 
			catch (TelefoneInvalidoException e) {
				System.out.println(e.getMessage());
			} 
			catch (DataInvalidaException e) {
				System.out.println(e.getMessage());
			} 
			finally {
				
				if (ok != -1) {
					System.out.println("Quer continuar? \n1.Sim  2.Não");
				}
				choice = in.next();

				if (choice.equals("1")) {
					contador = contador + 1;
				} else {
					System.out.println("Bye bye! Até a próxima!");
					contador = 6;
				}
			}

		}

	}

}
