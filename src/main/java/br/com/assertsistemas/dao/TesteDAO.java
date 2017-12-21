package br.com.assertsistemas.dao;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.assertsistemas.entity.Cliente;
import br.com.assertsistemas.entity.Funcionario;

public class TesteDAO {

	public static void main(String[] args) {
		
		String a = JOptionPane.showInputDialog("1 para Funcionario \n 2 para Cliente");
		int i = Integer.valueOf(a);

		if (i == 1) {
			Funcionario funcionario = new Funcionario();
			funcionario.setId(7);
			funcionario.setNome("Marcos 2");
			funcionario.setSobrenome("Agnoletto 2");
			funcionario.setSexo('M');
			funcionario.setIdade(20);
			funcionario.setCpf("093.907.129.04");
			funcionario.setSalario(2.000);
			FuncionarioDAO dao = new FuncionarioDAOImpl();
			
			//dao.insert(funcionario);
			//dao.update(funcionario);
			//dao.delete(funcionario.getId());
			//Funcionario funcionario01 = dao.findById(9);
			List<Funcionario> funcionarios = dao.findAll();
		
			for (Funcionario f : funcionarios) {
				System.out.println(f.toString());
			}
			
		} else  if (i == 2) {
			Cliente cliente = new Cliente();
			cliente.setNome("Jaderson");
			cliente.setSobrenome("Berti");
			cliente.setSexo('M');
			cliente.setIdade(26);
			cliente.setCnpj("9999999999990001");
			cliente.setPagamento(1.000);
			System.out.println(cliente);
		}
	
	}
}

