package br.com.assertsistemas.dao;

import java.util.List;

import br.com.assertsistemas.entity.Funcionario;

public interface FuncionarioDAO {

	public boolean insert(Funcionario funcionario);
	
	public boolean update(Funcionario funcionario);
		
	public boolean delete(int funcionarioId);	
	
	public List<Funcionario> findAll();
	
	public Funcionario findById(int funcionarioId);
	
	
}
