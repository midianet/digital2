package midianet.digital.modelo.negocio;

import java.util.List;

import javax.annotation.Resource;

import midianet.digital.modelo.entidade.Vendedor;
import midianet.digital.modelo.persistencia.VendedorDAO;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Component;

@Component
public class VendedorBO {
	
	@Resource
	private VendedorDAO vendedorDAO;
	
	public List<Vendedor> listarTodos() throws InfraExcessao{
		return vendedorDAO.listarTodos();
	}
	
}