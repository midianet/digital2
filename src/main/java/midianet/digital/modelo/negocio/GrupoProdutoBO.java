package midianet.digital.modelo.negocio;

import java.util.List;

import javax.annotation.Resource;

import midianet.digital.modelo.entidade.GrupoProduto;
import midianet.digital.modelo.persistencia.GrupoProdutoDAO;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Component;

@Component
public class GrupoProdutoBO {
	
	@Resource
	private GrupoProdutoDAO grupoProdutoDAO;
	
	public List<GrupoProduto> listarTodos() throws InfraExcessao{
		return grupoProdutoDAO.listarTodos();
	}
	
}