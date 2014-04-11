package midianet.digital.negocio;

import java.util.List;

import javax.annotation.Resource;

import midianet.digital.modelo.entidade.Fornecedor;
import midianet.digital.modelo.filtro.PessoaJuridicaFiltro;
import midianet.digital.modelo.persistencia.FornecedorDAO;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor=Exception.class)
public class FornecedorAS {
	
	@Resource
	private FornecedorDAO fornecedorDAO;
	
	@Transactional(readOnly = false)
	public void salvar(final Fornecedor fornecedor) throws InfraExcessao{
		if(fornecedor.getId() == null){
			fornecedorDAO.incluir(fornecedor);
		}else{
			fornecedorDAO.alterar(fornecedor);
		}
	}
	
	public Fornecedor obterPorCnpj(final String cnpj) throws InfraExcessao{
		
		final Fornecedor retorno = fornecedorDAO.obterPorCnpj(cnpj); 
		
		return retorno;
	}
	
	public Fornecedor obterFornecedorPorId(final Long id) throws InfraExcessao{
		
		final Fornecedor retorno = fornecedorDAO.obterPorId(id); 
		
		return retorno;
	}
	
	@Transactional(readOnly=false)
	public void excluir(final Fornecedor fornecedor) throws InfraExcessao{
		fornecedorDAO.excluir(fornecedor);
	}
	
	public List<Fornecedor> listarPorFiltro(final PessoaJuridicaFiltro filtro) throws InfraExcessao{
		List<Fornecedor> retorno = null;
		
		final boolean filtrarCnpj = filtro.getCnpj() != null && !filtro.getCnpj().trim().isEmpty();
		final boolean filtrarRazaoSocial = filtro.getRazaoSocial() != null && !filtro.getRazaoSocial().trim().isEmpty();
		
		if(filtrarCnpj && filtrarRazaoSocial){
			retorno = fornecedorDAO.listarPorCnpjERazaoSocial(filtro.getCnpj(), filtro.getRazaoSocial());
		}else if(filtrarCnpj){
			retorno = fornecedorDAO.listarPorCnpj(filtro.getCnpj());
		}else if(filtrarRazaoSocial){
			retorno = fornecedorDAO.listarPorRazaoSocial(filtro.getRazaoSocial());
		}
		
		return retorno;
		
	}
	
}