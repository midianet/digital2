package midianet.digital.negocio;

import java.util.List;

import javax.annotation.Resource;

import midianet.digital.modelo.entidade.Transportadora;
import midianet.digital.modelo.filtro.PessoaJuridicaFiltro;
import midianet.digital.modelo.persistencia.TransportadoraDAO;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor=Exception.class)
public class TransportadoraAS {
	
	@Resource
	private TransportadoraDAO transportadoraDAO;
	
	@Transactional(readOnly = false)
	public void salvar(final Transportadora transportadora) throws InfraExcessao{
		if(transportadora.getId() == null){
			transportadoraDAO.incluir(transportadora);
		}else{
			transportadoraDAO.alterar(transportadora);
		}
	}
	
	public Transportadora obterPorCnpj(final String cnpj) throws InfraExcessao{
		
		final Transportadora retorno = transportadoraDAO.obterPorCnpj(cnpj); 
		
		return retorno;
	}
	
	public Transportadora obterTransportadoraPorId(final Long id) throws InfraExcessao{
		
		final Transportadora retorno = transportadoraDAO.obterPorId(id); 
		
		return retorno;
	}
	
	@Transactional(readOnly=false)
	public void excluir(final Transportadora transportadora) throws InfraExcessao{
		transportadoraDAO.excluir(transportadora);
	}
	
	public List<Transportadora> listarTodos() throws InfraExcessao{
		List<Transportadora> retorno = null;
		
		retorno = transportadoraDAO.listarTodos();
		
		return retorno;
		
	}
	
	public List<Transportadora> listarPorFiltro(final PessoaJuridicaFiltro filtro) throws InfraExcessao{
		List<Transportadora> retorno = null;
		
		final boolean filtrarCnpj = filtro.getCnpj() != null && !filtro.getCnpj().trim().isEmpty();
		final boolean filtrarRazaoSocial = filtro.getRazaoSocial() != null && !filtro.getRazaoSocial().trim().isEmpty();
		
		if(filtrarCnpj && filtrarRazaoSocial){
			retorno = transportadoraDAO.listarPorCnpjERazaoSocial(filtro.getCnpj(), filtro.getRazaoSocial());
		}else if(filtrarCnpj){
			retorno = transportadoraDAO.listarPorCnpj(filtro.getCnpj());
		}else if(filtrarRazaoSocial){
			retorno = transportadoraDAO.listarPorRazaoSocial(filtro.getRazaoSocial());
		}
		
		return retorno;
		
	}
	
}