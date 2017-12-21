package br.com.assertsistemas.entity;

public abstract class Pessoa {

	protected String nome;
	protected String sobrenome;
	protected char sexo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", sobrenome=" + sobrenome + ", sexo=" + sexo + "]";
	}
	
}
