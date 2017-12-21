package br.com.assertsistemas.entity;

public class Funcionario extends Pessoa {
	
	private String cpf;
	private int idade;
	private double salario;
	private int id;
	
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}
	
	public Funcionario(int id) {
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Funcionario " + super.toString() + "[cpf=" + cpf + ", idade=" + idade + ", salario=" + salario + ", id=" + id + "]";
	}

	
}
