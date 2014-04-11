package midianet.digital.modelo.negocio;

import java.util.List;

import javax.annotation.Resource;

import midianet.digital.modelo.entidade.FormaPagamento;
import midianet.digital.modelo.persistencia.FormaPagamentoDAO;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Component;

@Component
public class FormaPagamentoBO {
	
	@Resource
	private FormaPagamentoDAO formaPagamentoDAO;
	
	public List<FormaPagamento> listarTodos() throws InfraExcessao{
		return formaPagamentoDAO.listarTodos();
	}
	
}