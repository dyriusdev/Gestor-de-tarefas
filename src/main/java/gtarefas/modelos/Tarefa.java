package gtarefas.modelos;

import java.sql.Date;

/**
 * @author richardson
 * 
 * Essa classe representa uma tarefa do banco de dados
 */
public class Tarefa {
	
	private int id, responsavel, prioridade;
	private String titulo, descricao;
	private Date deadline;
	
	public Tarefa(int id, String titulo, String descricao, int responsavel, int prioridade, Date deadline) {
		super();
		this.id = id;
		this.responsavel = responsavel;
		this.prioridade = prioridade;
		this.titulo = titulo;
		this.descricao = descricao;
		this.deadline = deadline;
	}
	
	// Getters e Setters
	
	public int getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(int responsavel) {
		this.responsavel = responsavel;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public int getId() {
		return id;
	}
}