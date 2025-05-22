package gtarefas.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author richardson
 * 
 * Essa classe é um singleton para o banco de dados
 * aqui é onde é criado a instancia do banco
 */
public class Database {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/tarefasdb", USER = "root", PASSWORD = "root";
	
	private static Database instance;
	
	private Connection connection;
	
	public static Database getInstance() throws Exception {
		if (instance == null || instance.connection.isClosed()) {
			instance = new Database();
		}
		return instance;
	}
	
	private Database() throws Exception {
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	public Connection getConnection() { return connection; }
}