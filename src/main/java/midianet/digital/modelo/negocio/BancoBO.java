package midianet.digital.modelo.negocio;

import java.util.List;

import javax.annotation.Resource;

import midianet.digital.modelo.entidade.Banco;
import midianet.digital.modelo.persistencia.BancoDAO;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Component;

@Component
public class BancoBO {
	
	@Resource
	private BancoDAO bancoDAO;
	
	public List<Banco> listarTodos() throws InfraExcessao{
		return bancoDAO.listarTodos();
	}
	
}