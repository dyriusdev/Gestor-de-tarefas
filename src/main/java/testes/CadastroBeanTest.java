package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import gtarefas.beans.CadastroBean;

class CadastroBeanTest {
	
	private CadastroBean bean;
	
	@BeforeEach
	void setUp() throws Exception {
		bean = new CadastroBean();
	}
	
	@Test
	@DisplayName("Teste de getter e setter")
	void test() {
		String titulo = "Teste Cadastro", descricao = "Testando bean", responsavel = "Dev";
		int prioridade = 0;
		Date date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		bean.setTitulo(titulo);
		bean.setDescricao(descricao);
		bean.setResponsavel(responsavel);
		bean.setPrioridade(prioridade);
		bean.setDeadline(date);
		
		assertEquals(titulo, bean.getTitulo(), "Titulo deve ser igual ao deferido");
		assertEquals(descricao, bean.getDescricao(), "Descrição deve ser igual ao deferido");
		assertEquals(responsavel, bean.getResponsavel(), "Responsavel deve ser igual ao deferido");
		assertEquals(prioridade, bean.getPrioridade(), "Prioridade deve ser igual ao deferido");
		assertEquals(date, bean.getDeadline(), "Deadline deve ser igual ao deferido");
	}
}
