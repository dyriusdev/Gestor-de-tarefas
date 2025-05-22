package gtarefas.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import gtarefas.dao.FuncionarioDAO;
import gtarefas.dao.TarefaDAO;
import gtarefas.modelos.Funcionario;
import gtarefas.modelos.Tarefa;

public class TarefaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer idFiltro, prioridadeFiltro;
	private String tituloFiltro, responsavelFiltro;
	
	private List<Tarefa> tarefas , tarefasFiltradas;
	
	@PostConstruct
	public void init() {
		procurarTarefas();
	}
	
	/**
	 * Esse metodo é onde é aplicado o filtro na lista que será usada
	 * para construir a tabela
	 */
	public void procurarTarefas() {
		tarefas = TarefaDAO.getAllTarefas();
		// Aplicando filtro com base nas variaveis desse bean
		tarefasFiltradas = tarefas.stream()
				.filter(t -> idFiltro == null || t.getId() == idFiltro)
				.filter(t -> tituloFiltro == null || tituloFiltro.isEmpty() || 
						t.getTitulo().toLowerCase().contains(tituloFiltro.toLowerCase()))
				.filter(t -> responsavelFiltro == null || responsavelFiltro.isEmpty() || 
						t.getResponsavel().toLowerCase().contains(responsavelFiltro.toLowerCase()))
				.filter(t -> prioridadeFiltro == null || t.getPrioridade() == prioridadeFiltro)
				.collect(Collectors.toList());
		
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Busca realizada", tarefasFiltradas.size() + " tarefas encontradas."));
	}
	
	/**
	 * Esse metodo é a ação do botão "Excluir" presente nos elementos da tabela
	 * aqui é onde o objeto é deletado no banco usando seu id como referencia,
	 * depois disso a lista de tarefas é atualizada
	 * @param tarefa instancia de um dos objetos da tabela
	 */
	public void excluirTarefa(Tarefa tarefa) {
		TarefaDAO.deletarTarefa(tarefa.getId());
		procurarTarefas();
		FacesContext.getCurrentInstance().addMessage(null,
	                new FacesMessage(FacesMessage.SEVERITY_WARN, "Ação de excluir", "Tarefa '" + tarefa.getTitulo() + "' excluída."));
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
	
	/**
	 * Esse metodo é chamado pela ação do botão "Editar" presente em cada elemento da tabela
	 * aqui é onde é feito o redirecionamento para a pagina editarTarefa, passando junto com o id
	 * do objeto correspondente na tabela
	 * @return uma string com o caminho para ser direcionado com id da tarefa
	 */
	public String editarTarefa(Tarefa tarefa) {
		FacesContext context = FacesContext.getCurrentInstance();
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ação de edição", "Preparando para editar tarefa : " + tarefa.getTitulo()));
		context.getExternalContext().getFlash().setKeepMessages(true);
		
		return "editarTarefa.xhtml?faces-redirect=true&tarefaId=" + tarefa.getId();
	}
	
	/**
	 * Esse metodo é chamado pela ação do botão "Cadastrar Tarefa"
	 * aqui é onde é feito o redirecionamento para a pagina cadastroTarefa
	 * @return uma string com o caminho para ser direcionado
	 */
	public String cadastrarTarefa() {
		FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Cadastrar tarefa"));
		return "cadastroTarefa.xhtml?faces-redirect=true";
	}
	
	// Getter e Setter
	
	public Integer getIdFiltro() {
		return idFiltro;
	}
	public void setIdFiltro(Integer idFiltro) {
		this.idFiltro = idFiltro;
	}
	public String getTituloFiltro() {
		return tituloFiltro;
	}
	public void setTituloFiltro(String tituloFiltro) {
		this.tituloFiltro = tituloFiltro;
	}
	public String getResponsavelFiltro() {
		return responsavelFiltro;
	}
	public void setResponsavelFiltro(String responsavelFiltro) {
		this.responsavelFiltro = responsavelFiltro;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public List<Tarefa> getTarefasFiltradas() {
		return tarefasFiltradas;
	}

	public void setTarefasFiltradas(List<Tarefa> tarefasFiltradas) {
		this.tarefasFiltradas = tarefasFiltradas;
	}

	public Integer getPrioridadeFiltro() {
		return prioridadeFiltro;
	}

	public void setPrioridadeFiltro(Integer prioridadeFiltro) {
		this.prioridadeFiltro = prioridadeFiltro;
	}
}