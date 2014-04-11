package midianet.digital.modelo.persistencia;

import midianet.digital.modelo.entidade.PedidoVenda;

import org.springframework.stereotype.Repository;

@Repository
public class PedidoVendaDAO extends GenericoDAO<PedidoVenda>{
	
//	@SuppressWarnings("unchecked")
//	public List<PedidoVenda> listarPorCnpj(final String cnpj) throws InfraExcessao{
//		List<PedidoVenda> retorno = null;
//		Query consulta = null;
//		
//		try{
//			consulta =  persistencia.createNamedQuery("PedidoVenda.listarPorCnpj");
//			consulta.setParameter("cnpj",   cnpj + "%");
//			retorno = consulta.getResultList();
//		}catch(final NoResultException e){
//			retorno = null;
//		}catch(final Exception e){
//			throw new InfraExcessao(e);
//		}
//		
//		return retorno;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<PedidoVenda> listarPorRazaoSocial(final String razaoSocial)throws InfraExcessao{
//		List<PedidoVenda> retorno = null;
//		Query consulta = null;
//		
//		try{
//			consulta =  persistencia.createNamedQuery("PedidoVenda.listarPorRazaoSocial");
//			consulta.setParameter("razaoSocial", razaoSocial + "%");
//			retorno = consulta.getResultList();
//		}catch(final NoResultException e){
//			retorno = null;
//		}catch(final Exception e){
//			throw new InfraExcessao(e);
//		}
//		
//		return retorno;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<PedidoVenda> listarPorCnpjERazaoSocial(final String cnpj, final String razaoSocial)throws InfraExcessao{
//		List<PedidoVenda> retorno = null;
//		Query consulta = null;
//		
//		try{
//			consulta =  persistencia.createNamedQuery("PedidoVenda.listarPorCnpjERazaoSocial");
//			consulta.setParameter("cnpj", "%" + cnpj);
//			consulta.setParameter("razaoSocial", "%" + razaoSocial);
//			retorno = consulta.getResultList();
//		}catch(final NoResultException e){
//			retorno = null;
//		}catch(final Exception e){
//			throw new InfraExcessao(e);
//		}
//		
//		return retorno;
//	}
//	
//	public PedidoVenda obterPorCnpj(final String cnpj) throws InfraExcessao{
//		PedidoVenda retorno = null;
//		Query consulta = null;
//		try{
//			consulta =  persistencia.createNamedQuery("PedidoVenda.obterPorCnpj");
//			consulta.setParameter("cnpj", cnpj);
//			retorno = (PedidoVenda) consulta.getSingleResult();
//		}catch(NoResultException e){
//			retorno = null;
//		}catch(NonUniqueResultException e){
//			//retorno =  (PedidoVenda) consulta.getResultList().get(0);
//			throw new InfraExcessao(e);
//		}catch(final Exception e){
//			throw new InfraExcessao(e);
//		}
//		
//		return retorno;
//	}
	
}