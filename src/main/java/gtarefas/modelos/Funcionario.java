package gtarefas.modelos;

/**
 * @author richardson
 * 
 * Esse classe representa o modelo no banco de dados que representa 
 * o funcionário que é o responsavel por uma ou mais de uma tarefa
 */
public class Funcionario {
	
	private int id;
	private String nome;
	
	public Funcionario(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
}