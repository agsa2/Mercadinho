package pessoa;

public class Cliente extends Pessoa{
	
	public Cliente(String cpf, String nome, String nascimento, String endereco, String telefone) {
		super(cpf, nome, nascimento, endereco, telefone);
		
	}
	private String tipoPagamento;
	//private Produto produto;
	
	
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	/*public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}*/
	
}
