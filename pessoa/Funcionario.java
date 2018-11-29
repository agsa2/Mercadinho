package pessoa;

public class Funcionario extends Pessoa {

	private int id;
	private String cargo;
	private double salario;

	public Funcionario(String cpf, String nome, String nascimento, String endereco, String telefone) {
		super(cpf, nome, nascimento, endereco, telefone);

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

}
