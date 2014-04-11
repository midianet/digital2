package midianet.digital.modelo.negocio;

import java.util.List;

import javax.annotation.Resource;

import midianet.digital.modelo.entidade.UnidadeMedida;
import midianet.digital.modelo.persistencia.UnidadeMedidaDAO;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Component;

@Component
public class UnidadeMedidaBO {
	
	@Resource
	private UnidadeMedidaDAO unidadeMedidaDAO;
	
	public List<UnidadeMedida> listarTodas() throws InfraExcessao{
		return unidadeMedidaDAO.listarTodas();
	}
	
}