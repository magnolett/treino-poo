package br.com.assertsistemas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.assertsistemas.entity.Funcionario;

public class FuncionarioDAOImpl implements FuncionarioDAO {

	@Override
	public boolean insert(Funcionario funcionario) {
		try {
			Connection connectionJDBC = new ConnectJDBC().getConnectionJDBC();
			String sql = "insert into funcionario (nome, sobrenome, sexo, idade, cpf, salario) values (?,?,?,?,?,?)";
			PreparedStatement statement = (PreparedStatement) connectionJDBC.prepareStatement(sql);
			statement.setString(1, funcionario.getNome());
			statement.setString(2, funcionario.getSobrenome());
			statement.setInt(3, funcionario.getSexo());
			statement.setInt(4, funcionario.getIdade());
			statement.setString(5, funcionario.getCpf());
			statement.setDouble(6, funcionario.getSalario());
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
		}
		return false;
	}

	@Override
	public boolean update(Funcionario funcionario) {

		try {
			Connection connectionJDBC = new ConnectJDBC().getConnectionJDBC();
			String sql = "UPDATE funcionario SET nome=?, sobrenome=?, sexo=?, idade=?, cpf=?, salario=? WHERE id=?";
			PreparedStatement statement = (PreparedStatement) connectionJDBC.prepareStatement(sql);
			statement.setString(1, funcionario.getNome());
			statement.setString(2, funcionario.getSobrenome());
			statement.setInt(3, funcionario.getSexo());
			statement.setInt(4, funcionario.getIdade());
			statement.setString(5, funcionario.getCpf());
			statement.setDouble(6, funcionario.getSalario());
			statement.setInt(7, funcionario.getId());
			boolean updatesucess = false;
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Os dados já existentes foram atualizados com sucesso!");
			}
			updatesucess = true;
			connectionJDBC.close();
			return updatesucess;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(int funcionarioId) {
		try {
			Connection connectionJDBC = new ConnectJDBC().getConnectionJDBC();
			String sql = "delete from funcionario where id = ?";
			PreparedStatement statement = (PreparedStatement) connectionJDBC.prepareStatement(sql);
			statement.setInt(1, funcionarioId);

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Deleted successfully!");
				return true;
			}

			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Funcionario> findAll() {
		try {
			Connection connectionJDBC = new ConnectJDBC().getConnectionJDBC();
			String sql = "select * from funcionario";
			PreparedStatement statement = (PreparedStatement) connectionJDBC.prepareStatement(sql);

			List<Funcionario> funcionarios = new ArrayList<>();
			ResultSet resultaQuery = statement.executeQuery();

			while (resultaQuery.next()) {
				Funcionario funcionario = new Funcionario();

				funcionario.setId(resultaQuery.getInt("id"));
				funcionario.setCpf(resultaQuery.getString("cpf"));
				funcionario.setNome(resultaQuery.getString("nome"));
				funcionario.setSexo(resultaQuery.getCharacterStream("sexo").toString().charAt(0));
				funcionario.setSobrenome(resultaQuery.getString("sobrenome"));
				funcionario.setSalario(resultaQuery.getDouble("salario"));
				funcionario.setIdade(resultaQuery.getInt("idade"));

				funcionarios.add(funcionario);
			}

			return funcionarios;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Funcionario findById(int funcionarioId) {
		try {
			Connection connectionJDBC = new ConnectJDBC().getConnectionJDBC();
			String sql = "select * from funcionario where id = ?";
			PreparedStatement statement = (PreparedStatement) connectionJDBC.prepareStatement(sql);
			statement.setInt(1, funcionarioId);

			ResultSet resultaQuery = statement.executeQuery();

			while (resultaQuery.next()) {
				Funcionario funcionario = new Funcionario();

				funcionario.setId(resultaQuery.getInt("id"));
				funcionario.setCpf(resultaQuery.getString("cpf"));
				funcionario.setNome(resultaQuery.getString("nome"));
				funcionario.setSexo(resultaQuery.getCharacterStream("sexo").toString().charAt(0));
				funcionario.setSobrenome(resultaQuery.getString("sobrenome"));
				funcionario.setSalario(resultaQuery.getDouble("salario"));
				funcionario.setIdade(resultaQuery.getInt("idade"));

				return funcionario;
			}

			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
