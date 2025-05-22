package gtarefas.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import gtarefas.dao.FuncionarioDAO;
import gtarefas.dao.TarefaDAO;
import gtarefas.modelos.Funcionario;

public class CadastroBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String titulo, descricao, responsavel;
	private int prioridade = 0;
	private java.util.Date deadline;
	
	/**
	 * Esse metodo é chamado quando está para ser feito o cadastro
	 * aqui é onde os dados do campo são passados para o banco
	 * e apos isso o cliente é redirecionado para a pagina principal
	 * @return caminho a ser redirecionado
	 */
	public String registrarTarefa() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		Date sqlDate = new Date(deadline.getTime());
		boolean valid = TarefaDAO.cadastrarTarefa(titulo, descricao, responsavel, prioridade, sqlDate);
		if (valid) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Tarefa cadastrada com sucesso!");
			context.addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Falha!", "Não foi possivel cadastrar a tarefa!");
			context.addMessage(null, message);
		}
		
		return "index.xhtml?faces-redirect=true";
	}
	
	/**
	 * Esse metodo faz uma busca por todos os funcionarios no banco de dados e para cada um ele 
	 * cria um elemento de objeto de seleção que sera usado para exibir na pagina
	 * @return List<SelectItem> com o nome de todos os funcionario encontrados no banco
	 */
	public List<SelectItem> getResponsaveis() {
		List<SelectItem> options = new ArrayList<SelectItem>();
		List<Funcionario> funcionarios = FuncionarioDAO.getAllFuncionarios();
		for (Funcionario funcionario : funcionarios) {
			options.add(new SelectItem(funcionario.getNome(), funcionario.getNome()));
		}
		return options;
	}
	
	// Getter e Setter
	
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
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	public java.util.Date getDeadline() {
		return deadline;
	}
	public void setDeadline(java.util.Date deadline) {
		this.deadline = deadline;
	}
}
