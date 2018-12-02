package pessoa;

public class Pessoa {

	private String cpf;
	private String nome;
	
	// private String dataNascimento; -> Forma "antiga" de receber a data de nascimento
	
	// Troquei a forma que recebe a data de nascimento pra ficar mais simples
	// (pelo menos pra mim) na hora de validar. 
	
	private int diaNascimento;
	private int mesNascimento;
	private int anoNascimento;
	
	private String endereco;
	private String telefone;
	
	// Último atributo colocado na classe PESSOA
	// do tipo CHAR pois só vai receber "M" ou "F"
	private char genero;

	public Pessoa(String cpf, String nome, int diaNascimento, int mesNascimento, int anoNascimento, String endereco, String telefone, char genero) {
		this.cpf = cpf;
		this.nome = nome;
		this.diaNascimento = diaNascimento;
		this.mesNascimento = mesNascimento;
		this.anoNascimento = anoNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.genero = genero;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDiaNascimento() {
		return diaNascimento;
	}

	public void setDiaNascimento(int diaNascimento) {
		this.diaNascimento = diaNascimento;
	}
	
	public int getMesNascimento() {
		return mesNascimento;
	}
	
	public void setMesNascimento(int mesNascimento) {
		this.mesNascimento = mesNascimento;
	}
	
	public int getAnoNascimento() {
		return anoNascimento;
	}
	
	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public char getGenero() {
		return genero;
	}
	
	public void setGenero(char genero) {
		this.genero = genero;
	}
}
