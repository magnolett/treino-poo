package br.com.assertsistemas.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.assertsistemas.entity.Cliente;

public class ClienteDAOImpl implements ClienteDAO {

	@Override
	public boolean insert(Cliente cliente) {
	try{	
		Connection connectionJDBC = new ConnectJDBC().getConnectionJDBC();
		String sql = "insert into cliente (nome, sobrenome, sexo, cnpj, idade, pagamento) values (?,?,?,?,?,?)";
		PreparedStatement statement = (PreparedStatement) connectionJDBC.prepareStatement(sql);
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getSobrenome());
		statement.setInt(3, cliente.getSexo());
		statement.setInt(4, cliente.getIdade());
		statement.setString(5, cliente.getCnpj());
		statement.setDouble(6, cliente.getPagamento());
		boolean insertSucess = false;
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("O Insert foi inserido com sucesso!");
		    insertSucess = true;
		} 
		connectionJDBC.close();
		return insertSucess;
	} catch (SQLException e) {
		e.printStackTrace();
	return false;
}
	}

	@Override
	public boolean update(Cliente cliente) {
		return false;
	}

	@Override
	public boolean delete(int clienteId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente FindById(int clienteId) {
		// TODO Auto-generated method stub
		return null;
	}

}
