package midianet.digital.negocio;

import javax.annotation.Resource;

import midianet.digital.modelo.entidade.PedidoVenda;
import midianet.digital.modelo.persistencia.PedidoVendaDAO;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor=Exception.class)
public class PedidoVendaAS {
	
	@Resource
	private PedidoVendaDAO pedidoVendaDAO;
	
	@Transactional(readOnly = false)
	public void salvar(final PedidoVenda pedidoVenda) throws InfraExcessao{
		if(pedidoVenda.getId() == null){
			pedidoVendaDAO.incluir(pedidoVenda);
		}else{
			pedidoVendaDAO.alterar(pedidoVenda);
		}
	}
	
	public PedidoVenda obterPedidoVendaPorId(final Long id) throws InfraExcessao{
		
		final PedidoVenda retorno = pedidoVendaDAO.obterPorId(id); 
		if(retorno != null){
			retorno.getTotal();
		}
		return retorno;
	}
	
	@Transactional(readOnly=false)
	public void excluir(final PedidoVenda pedidoVenda) throws InfraExcessao{
		pedidoVendaDAO.excluir(pedidoVenda);
	}
	
}