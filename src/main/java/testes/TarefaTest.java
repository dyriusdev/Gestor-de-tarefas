package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import gtarefas.beans.TarefaBean;
import gtarefas.modelos.Tarefa;

class TarefaTest {
	
	private TarefaBean bean;
	
	@BeforeEach
	void setUp() throws Exception {
		bean = new TarefaBean();
	}
	
	@Test
	@DisplayName("Teste de getter e setter")
	void test() {
		int idFiltro = 0, prioridadeFiltro = 0;
		String tituloFiltro = "Teste", responsavelFiltro = "Dev";
		List<Tarefa> tarefas = new ArrayList<>(), tarefasFiltradas = new ArrayList<>();
		
		String titulo = "Teste Cadastro", descricao = "Testando bean", responsavel = "Dev";
		int tarefaId = 0, prioridade = 0;
		Date date = Date.valueOf(LocalDate.now());
		Tarefa tarefa = new Tarefa(tarefaId, titulo, descricao, responsavel, prioridade, date);
		
		tarefas.add(tarefa);
		tarefasFiltradas = tarefas;
		
		bean.setIdFiltro(idFiltro);
		bean.setPrioridadeFiltro(prioridadeFiltro);
		bean.setTituloFiltro(tituloFiltro);
		bean.setResponsavelFiltro(responsavelFiltro);
		bean.setTarefas(tarefas);
		bean.setTarefasFiltradas(tarefasFiltradas);
		
		assertEquals(idFiltro, bean.getIdFiltro(), "IdFiltro deve ser igual ao deferido");
		assertEquals(prioridadeFiltro, bean.getPrioridadeFiltro(), "Prioridade deve ser igual ao deferido");
		assertEquals(tituloFiltro, bean.getTituloFiltro(), "Titulo deve ser igual ao deferido");
		assertEquals(responsavelFiltro, bean.getResponsavelFiltro(), "Responsavel deve ser igual ao deferido");
		assertEquals(tarefas, bean.getTarefas(), "Tarefas deve ser igual ao deferido");
		assertEquals(tarefasFiltradas, bean.getTarefasFiltradas(), "Tarefa Filtrada deve ser igual ao deferido");
	}

}
