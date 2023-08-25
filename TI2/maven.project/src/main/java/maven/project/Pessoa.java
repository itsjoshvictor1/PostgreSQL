/*
 Aluno: Joshua Victor
 Matricula: 789339
 */
package maven.project;

public class Pessoa {
	private int id;
	private String nome;
	private int idade;
	private char sexo;
	
	public Pessoa() {
		this.id = -1;
		this.nome = "";
		this.idade = -1;
		this.sexo = '*';
	}
	
	public Pessoa(int id, String nome, int idade, char sexo) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Usuario [id = " + id + ", nome = " + nome + ", idade = " + idade + ", sexo = " + sexo + "]";
	}	
}
