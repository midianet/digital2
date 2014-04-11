package midianet.digital.modelo.negocio;

import javax.annotation.Resource;

import midianet.digital.excessao.RegistroNaoEncontradoExcessao;
import midianet.digital.excessao.SemConexaoInternetExcessao;
import midianet.digital.excessao.ValorNaoInformadoExcessao;
import midianet.digital.modelo.entidade.Bairro;
import midianet.digital.modelo.entidade.Cep;
import midianet.digital.modelo.entidade.CepCorreios;
import midianet.digital.modelo.entidade.Municipio;
import midianet.digital.modelo.entidade.Uf;
import midianet.digital.modelo.persistencia.CepDAO;
import midianet.digital.modelo.remoto.CepJSON;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CepBO {
	
	@Resource
	private CepDAO cepDAO;
	
	@Resource
	private MunicipioBO municipioBO;
	
	@Resource
	private UfBO ufBO;
	
	@Resource
	private BairroBO bairroBO;
	
	@Resource
	private CepJSON cepJSON; 
	
	@Transactional(readOnly = false)
	public Cep obterPorCep(final String cep) throws ValorNaoInformadoExcessao, RegistroNaoEncontradoExcessao, SemConexaoInternetExcessao, InfraExcessao{
		
		Cep retorno = null;
		CepCorreios cepCorreios = null;
		
		if(cep == null){
			throw new ValorNaoInformadoExcessao("Cep");
		}
		
		//Verifica se existe na base local
		retorno = cepDAO.obterPorCep(cep);
		
		//Caso nao exista tenta ir no correios
		if(retorno == null){
			cepCorreios = cepJSON.obterPorCEP(cep);
			
			if(cepCorreios == null){
				throw new RegistroNaoEncontradoExcessao("Cep", cep);
			}
			
			//Obtem no cadastro Uf,Municipio,Bairro
			// caso não exista sera adicionado um novo registro
			retorno = preencherCep(cepCorreios);
			retorno.setCep(cep);
			
			salvar(retorno);
			
		}else{
			retorno.getUf().getNome();
			retorno.getMunicipio().getNome();
			retorno.getBairro().getNome();
		}
		
		return retorno;
	}
	
	private void salvar(final Cep cep) throws  ValorNaoInformadoExcessao, InfraExcessao{
		
		cepDAO.salvar(cep);
	}
	
	private Cep preencherCep(final CepCorreios cepCorreios) throws ValorNaoInformadoExcessao, InfraExcessao{
		final Cep retorno = new Cep();
		
		Uf uf = null;
		Municipio municipio = null;
		Bairro bairro = null;
		
		uf = ufBO.obterPorId(cepCorreios.getUf());
		
		if(uf == null){
			
			uf = new Uf();
			uf.setId(cepCorreios.getUf());
			uf.setNome(cepCorreios.getUf());
			
			ufBO.incluir(uf);
		}
		
		municipio = municipioBO.obterMunicipioPorUfeNome(uf, cepCorreios.getMunicipio());
		
		if(municipio == null){
			
			municipio = new Municipio();
			municipio.setNome(cepCorreios.getMunicipio());
			municipio.setUf(uf);
			
			municipioBO.incluir(municipio);
		}
		
		bairro = bairroBO.obterBairroPorMunicipioENome(municipio, cepCorreios.getBairro()); 
		
		if(bairro == null){
			
			bairro = new Bairro();
			bairro.setNome(cepCorreios.getBairro());
			bairro.setMunicipio(municipio);
			
			bairroBO.incluir(bairro);
		}
		
		municipio.setUf(uf);
		bairro.setMunicipio(municipio);
		
		retorno.setUf(uf);
		retorno.setMunicipio(municipio);
		retorno.setBairro(bairro);
		retorno.setLogradouro(cepCorreios.getLogradouro());
		
		return retorno;
		
	}
	
}