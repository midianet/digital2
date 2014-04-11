
package midianet.digital.modelo.entidade;

import java.io.Serializable;

public class CepCorreios implements Serializable {
	private static final long serialVersionUID = -4323119761387994161L;
	
	private String cep;
	private String logradouro;
	private String bairro;
	private String municipio;
	private String uf;

	public final String getCep() {
		return cep;
	}
	
	public final void setCep(final String cep) {
		this.cep = cep;
	}
	
	public final String getLogradouro() {
		return logradouro;
	}
	
	public final void setLogradouro(final String logradouro) {
		this.logradouro = logradouro;
	}
	
	public final String getBairro() {
		return bairro;
	}
	
	public final void setBairro(final String bairro) {
		this.bairro = bairro;
	}
	
	public final void setLocalidade(final String localidade) {
	    
		municipio = null;
		uf        = null;
		
		if(localidade != null){
			final String[] local =  localidade.split("/");
			
			if(local.length == 2){
				municipio   = local[0].trim();
				uf          = local[1].trim();
			}
		}
	}
	
	public final String getMunicipio(){
		return this.municipio;
	}
	
	public final String getUf(){
		return this.uf;
	}
	
}