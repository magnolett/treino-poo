package br.com.assertsistemas.dao;

import java.util.List;

import br.com.assertsistemas.entity.Cliente;

public interface ClienteDAO {
	
	public boolean insert(Cliente cliente);
	
	public boolean update(Cliente cliente);
	
	public boolean delete (int clienteId);
	
	public List<Cliente> findAll();
	
	public Cliente FindById(int clienteId);
}
