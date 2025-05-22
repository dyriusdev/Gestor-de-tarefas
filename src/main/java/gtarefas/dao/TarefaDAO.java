package gtarefas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gtarefas.modelos.Tarefa;
import gtarefas.utils.Database;

/**
 * @author richardson
 * 
 * Essa classe implementa o conceito de DAO (Data Access Object)
 * para o modelo de tarefa,  é onde é feito o controle e onde 
 * é realizados as consultas ao banco relacionadas as tarefas
 */
public class TarefaDAO {
	
	/**
	 * Esse metodo recebe os dados que uma tarefa possui e faz a inserção
	 * no banco de dados
	 * 
	 * @param titulo da tarefa
	 * @param descricao da tarefa
	 * @param responsavel pela tarefa
	 * @param prioridade da tarefa
	 * @param deadline da tarefa
	 * 
	 * @return retorna true caso a operação seja realizada com sucesso e false para caso haja erro
	 */
	public static boolean cadastrarTarefa(String titulo, String descricao, String responsavel, int prioridade, Date deadline) {
		try {
			Connection connection = Database.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tarefas (titulo, descricao, responsavel, prioridade, deadline) VALUES (?, ?, ?, ?, ?)");
			preparedStatement.setString(1, titulo);
			preparedStatement.setString(2, descricao);
			preparedStatement.setString(3, responsavel);
			preparedStatement.setInt(4, prioridade);
			preparedStatement.setDate(5, deadline);
			
			preparedStatement.executeUpdate();
			connection.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Esse metodo busca todas as tarefas do banco de dados
	 * e todas elas são armazenadas em uma lista
	 * 
	 * @return Uma List<Tarefa> com todas as tarefas que foram encontradas
	 */
	public static List<Tarefa> getAllTarefas() {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		try {
			Connection connection = Database.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM tarefas");
			while (result.next()) {
				
				tarefas.add(new Tarefa(
						result.getInt(1),
						result.getString(2),
						result.getString(3), 
						result.getString(4), 
						result.getInt(5), 
						result.getDate(6)));
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tarefas;
	}
	
	public static Tarefa getTarefa(int id) {
		try {
			Connection connection = Database.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tarefas WHERE id = ?");
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			connection.close();
			if (result.next()) {
				return new Tarefa(result.getInt(1), result.getString(2), result.getString(3), 
						result.getString(4), result.getInt(5), result.getDate(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Esse metodo busca por um objeto que tem o mesmo id que o recebido no parametro 
	 * dentro da tabela de tarefas e caso encontre ela será deletada
	 * 
	 * @param id chave primaria da tarefa a ser deletada
	 */
	public static void deletarTarefa(int id) {
		try {
			Connection connection = Database.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM tarefas WHERE id = ?");
			preparedStatement.setInt(1, id);
			
			preparedStatement.execute();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Esse metodo serve para atualizar um objeto especifico do banco que possui o mesmo id
	 * da tarefa que está para ser atualizada, após ser encontrada é feito uma sobreescrita nas informações
	 * com base na instancia da tarefa que foi recebido no parametro para atualizar
	 * @param tarefa instancia da tarefa a ser atualizada
	 */
	public static void updateTarefa(Tarefa tarefa) {
		try {
			Connection connection = Database.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE tarefas SET titulo = ?, descricao = ?, responsavel = ?, prioridade = ?, deadline = ? WHERE id = ?");
			preparedStatement.setString(1, tarefa.getTitulo());
			preparedStatement.setString(2, tarefa.getDescricao());
			preparedStatement.setString(3, tarefa.getResponsavel());
			preparedStatement.setInt(4, tarefa.getPrioridade());
			preparedStatement.setDate(5, tarefa.getDeadline());
			
			preparedStatement.setInt(6, tarefa.getId());
			
			preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}