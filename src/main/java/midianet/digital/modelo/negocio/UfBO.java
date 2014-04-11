package midianet.digital.modelo.negocio;

import java.util.List;

import javax.annotation.Resource;

import midianet.digital.excessao.ValorNaoInformadoExcessao;
import midianet.digital.modelo.entidade.Uf;
import midianet.digital.modelo.persistencia.UfDAO;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Component;

@Component
public class UfBO {
	
	@Resource
	private UfDAO ufDAO;
	
	public List<Uf> listarTodos() throws InfraExcessao{
		return ufDAO.listar("Uf.listarTodos");
	}
	
	public Uf obterPorId(final String id) throws ValorNaoInformadoExcessao, InfraExcessao{
		
		Uf retorno = null;
		
		if(id == null){
			throw new ValorNaoInformadoExcessao("Uf");
		}
		
		try{
			retorno = ufDAO.obterPorId(id);
			
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return retorno;
	}
	
	public void incluir(final Uf uf) throws InfraExcessao{
		ufDAO.incluir(uf);
	}
	
}