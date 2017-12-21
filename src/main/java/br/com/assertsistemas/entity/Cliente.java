package br.com.assertsistemas.entity;

public class Cliente extends Pessoa {

	private int id;
	private String cnpj;
	private int idade;
	private double pagamento;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(int id) {
		this.id = id;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade (int idade){
		this.idade = idade;
	}
	
	public double getPagamento() {
		return pagamento;
	}
	
	public void setPagamento(double pagamento) {
		this.pagamento = pagamento;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cliente" + super.toString() + "[cnpj=" + cnpj + ", idade=" + idade + ", pagamento=" + pagamento + ", id=" + id + "]";
	}
	
}
