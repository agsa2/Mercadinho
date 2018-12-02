package pessoa;

import java.util.Date;

public class Cliente extends Pessoa {

	private String tipoPagamentoUsado;
	private String produtoPreferido;
	private String email;

	public Cliente(String cpf, String nome, int diaNascimento, int mesNascimento, int anoNascimento, String endereco,
			String telefone, char genero, String tipoPagamentoUsado, String produtoPreferido, String email) {
		super(cpf, nome, diaNascimento, mesNascimento, anoNascimento, endereco, telefone, genero);

		this.tipoPagamentoUsado = tipoPagamentoUsado;
		this.produtoPreferido = produtoPreferido;
		this.email = email;

	}

	public String getTipoPagamentoUsado() {
		return tipoPagamentoUsado;
	}

	public void setTipoPagamentoUsado(String tipoPagamentoUsado) {
		this.tipoPagamentoUsado = tipoPagamentoUsado;
	}

	public String getProdutoPreferido() {
		return produtoPreferido;
	}

	public void setProdutoPreferido(String produtoPreferido) {
		this.produtoPreferido = produtoPreferido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
