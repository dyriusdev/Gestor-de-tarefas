package gtarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gtarefas.modelos.Funcionario;
import gtarefas.utils.Database;

/**
 * @author richardson
 * 
 * Essa classe implementa o conceito de DAO (Data Access Object)
 * para o modelo de funcionario, aqui é onde é feito o controle
 * e onde é realizados as consultas ao banco relacionadas aos funcionarios
 */
public class FuncionarioDAO {
	
	/**
	 * Esse metodo faz uma busca na tabela de funcionários do banco e procura 
	 * pelo mesmo objeto da tabela que tem o id que está sendo passado como parametro
	 * 
	 * @param id chave primaria que é usada como identificador unico
	 * @return instancia de funcionário que foi encontrado no banco, caso contrario o retorno é nulo
	 */
	public static Funcionario getFuncionario(int id) {
		try {
			Connection connection = Database.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM funcionarios WHERE id = ?");
			statement.setInt(1, id);
			
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				Funcionario funcionario = new Funcionario(result.getInt(1), result.getString(2));
				connection.close();
				return funcionario;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Esse metodo busca todos os funcionários do banco de dados
	 * e todos eles são armazenados em uma lista
	 * 
	 * @return Uma List<Funcionario> com todos os funcionários que foram encontrados
	 */
	public static List<Funcionario> getAllFuncionarios() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try {
			Connection connection = Database.getInstance().getConnection();
			Statement statement = connection.createStatement();
					
			ResultSet result = statement.executeQuery("SELECT * FROM funcionarios");
			while (result.next()) {
				funcionarios.add(new Funcionario(result.getInt(1), result.getString(2)));
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return funcionarios;
	}
}