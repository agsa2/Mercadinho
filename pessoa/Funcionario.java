package pessoa;

public class Funcionario extends Pessoa {

	private int id;
	private String cargo;
	private double salario;
	private String situacao;
	
	public Funcionario(String cpf, String nome, int diaNascimento, int mesNascimento, int anoNascimento, String endereco, 
			String telefone, char genero, int id, String cargo, double salario, String situacao) {
		super(cpf, nome, diaNascimento, mesNascimento, anoNascimento, endereco, telefone, genero);
		
		this.id = id;
		this.salario = salario;
		this.cargo = cargo;
		this.situacao = situacao;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String getSituacao() {
		return situacao;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
