package gtarefas.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import gtarefas.dao.FuncionarioDAO;
import gtarefas.dao.TarefaDAO;
import gtarefas.modelos.Funcionario;
import gtarefas.modelos.Tarefa;

public class EditarBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer tarefaId;
	private Tarefa tarefaAtual;
	
	/**
	 * Esse metodo é chamado assim que a pagina está para ser renderizada
	 * ele é necessário pois para pegar a tarefa que foi escolhida para ser
	 * editada é preciso pegar primeiro essas informações, nesse caso o id da tarefa
	 * está servindo de referencia para pegar o objeto no banco
	 */
	public void carregarTarefaAtual() {
		if (tarefaId != null && tarefaAtual == null) {
			tarefaAtual = TarefaDAO.getTarefa(tarefaId);
			if (tarefaAtual == null) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Tarefa com Id " + tarefaId + " não encontrada!"));
				context.getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "listagemTarefas?faces-redirect=true");
			}
		}
	}
	
	/**
	 * Esse metodo é usado para salvar as alterações que foram feitas no banco
	 * e em seguida redireciona para a pagina principal
	 * 
	 * @return caminho a ser redirecionado
	 */
	public String salvarTarefaEditada() {
		if (tarefaAtual != null) {
			TarefaDAO.updateTarefa(tarefaAtual);
			FacesContext.getCurrentInstance().addMessage(null,
	                new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Tarefa '" + tarefaAtual.getTitulo()  + "' salva com sucesso."));
			return "index.xhtml?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
	                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Não foi possível salvar a tarefa."));
			return null;
		}
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
	
	public Tarefa getTarefaAtual() {	
		return tarefaAtual;
	}
	public void setTarefaAtual(Tarefa tarefaAtual) {
		this.tarefaAtual = tarefaAtual;
	}
	public Integer getTarefaId() {
		return tarefaId;
	}
	public void setTarefaId(Integer tarefaId) {
		this.tarefaId = tarefaId;
	}
}