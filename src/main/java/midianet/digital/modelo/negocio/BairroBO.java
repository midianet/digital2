package midianet.digital.modelo.negocio;

import java.util.List;

import javax.annotation.Resource;

import midianet.digital.excessao.ValorNaoInformadoExcessao;
import midianet.digital.modelo.entidade.Bairro;
import midianet.digital.modelo.entidade.Municipio;
import midianet.digital.modelo.persistencia.BairroDAO;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Component;

@Component
public class BairroBO {
	
	@Resource
	private BairroDAO bairroDAO;
	
	public List<Bairro> listarMunicipio(final Municipio municipio) throws ValorNaoInformadoExcessao, InfraExcessao{
		
		if(municipio == null){
			throw new ValorNaoInformadoExcessao("Municipio");
		}
		
		return bairroDAO.listarPorMunicipio(municipio);
		
	}
	
	public void salvar(final Bairro bairro) throws InfraExcessao{
		
		if(bairro.getId() == null){
			incluir(bairro);
		}else{
			bairroDAO.alterar(bairro);
		}
	}
	
	public void incluir(final Bairro bairro) throws InfraExcessao{
		bairroDAO.incluir(bairro);
	}
	
	public Bairro obterBairroPorMunicipioENome(final Municipio municipio , final String nome ) throws ValorNaoInformadoExcessao, InfraExcessao{
	
		if(municipio == null){
			throw new ValorNaoInformadoExcessao("Município");
		}
		
		if(nome == null){
			throw new ValorNaoInformadoExcessao("Nome");
		}
		
		return bairroDAO.obterBairroPorMunicipioENome(municipio, nome);
	}
	
}