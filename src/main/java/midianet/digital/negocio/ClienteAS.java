package midianet.digital.negocio;

import java.util.List;

import javax.annotation.Resource;

import midianet.digital.modelo.entidade.Cliente;
import midianet.digital.modelo.filtro.PessoaJuridicaFiltro;
import midianet.digital.modelo.persistencia.ClienteDAO;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor=Exception.class)
public class ClienteAS {
	
	@Resource
	private ClienteDAO clienteDAO;
	
	@Transactional(readOnly = false)
	public void salvar(final Cliente cliente) throws InfraExcessao{
		if(cliente.getId() == null){
			clienteDAO.incluir(cliente);
		}else{
			clienteDAO.alterar(cliente);
		}
	}
	
	public Cliente obterPorCnpj(final String cnpj) throws InfraExcessao{
		
		final Cliente retorno = clienteDAO.obterPorCnpj(cnpj); 
		
		return retorno;
	}
	
	public Cliente obterClientePorId(final Long id) throws InfraExcessao{
		
		final Cliente retorno = clienteDAO.obterPorId(id); 
		
		return retorno;
	}
	
	@Transactional(readOnly=false)
	public void excluir(final Cliente cliente) throws InfraExcessao{
		clienteDAO.excluir(cliente);
	}
	
	public List<Cliente> listarPorFiltro(final PessoaJuridicaFiltro filtro) throws InfraExcessao{
		List<Cliente> retorno = null;
		
		final boolean filtrarCnpj = filtro.getCnpj() != null && !filtro.getCnpj().trim().isEmpty();
		final boolean filtrarRazaoSocial = filtro.getRazaoSocial() != null && !filtro.getRazaoSocial().trim().isEmpty();
		
		if(filtrarCnpj && filtrarRazaoSocial){
			retorno = clienteDAO.listarPorCnpjERazaoSocial(filtro.getCnpj(), filtro.getRazaoSocial());
		}else if(filtrarCnpj){
			retorno = clienteDAO.listarPorCnpj(filtro.getCnpj());
		}else if(filtrarRazaoSocial){
			retorno = clienteDAO.listarPorRazaoSocial(filtro.getRazaoSocial());
		}
		
		return retorno;
		
	}
	
}