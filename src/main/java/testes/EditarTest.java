package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import gtarefas.beans.EditarBean;
import gtarefas.modelos.Tarefa;

class EditarTest {
	
	private EditarBean bean;
	
	@BeforeEach
	void setUp() throws Exception {
		bean = new EditarBean();
	}
	
	@Test
	@DisplayName("Teste de getter e setter")
	void test() {
		String titulo = "Teste Cadastro", descricao = "Testando bean", responsavel = "Dev";
		int tarefaId = 0, prioridade = 0;
		Date date = Date.valueOf(LocalDate.now());
		Tarefa tarefa = new Tarefa(tarefaId, titulo, descricao, responsavel, prioridade, date);
		
		bean.setTarefaId(tarefaId);
		bean.setTarefaAtual(tarefa);
		
		assertEquals(tarefaId, bean.getTarefaId(), "TarefaId deve ser igual ao deferido");
		assertEquals(tarefa, bean.getTarefaAtual(), "Tarefa deve ser igual ao deferido");
	}
}
