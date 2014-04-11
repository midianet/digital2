/*
 * ConversorEntidade.java
 * 
 * Criado pela equipe de desenvolvimento do RHNet
 * integrante do Sistema de Recadastramento do Servidor.
 * 
 * Midianet 2014.
 * 
 * Todos os direitos Copyright estão reservados.
 */

package midianet.framework.jsf.conversor;

import java.io.Serializable;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import midianet.framework.persistencia.entidade.Entidade;

/**
 * ConversorEntidade
 * Classe de conversao de entidades genéricas para apresentação na tela ou vice versa.
 * 
 * @category Conversor
 * 
 * @author Marcos Fernando Costa.
 */
@FacesConverter(value="conversorEntidade")
public class ConversorEntidade  implements Converter {
	
    /**
     * Método que recebe o valor da tela retorna o mesmo sem formatação.
     * 
     * @param contexto Contexto web.
     * @param componente Componente da tela em questão.
     * @param valor Valor do objeto retornado da tela.
     * 
     * @return Object porem sempre retornará um objeto {@link Integer}.
     * 
     * @author Marcos Fernando Costa.
     */
	public final Object getAsObject(final FacesContext contexto,final UIComponent componente, final String valor) {
		
		if (valor != null && valor.trim().length() > 0) {
			return this.getAtributos(componente).get(valor);
		}
		
		return null;
		
	}

	
    /**
     * Método que recebe o objeto e retorna o mesmo como {@link String}.
     * 
     * @param contexto Contexto web.
     * @param componente Componente da tela em questão.
     * @param valor Valor do cep retornado da tela.
     * 
     * @return String valor do cep.
     * 
     * @author Marcos Fernando Costa.
     */
	@SuppressWarnings("rawtypes")
	public final String getAsString(final FacesContext contexto, final UIComponent componente, final Object valor) {
		
		if (valor != null && !"".equals(valor)) {
			
			final Entidade entidade = (Entidade) valor;
			
			adicionaAtributo(componente, entidade);
			
			Serializable id = entidade.getId();
			
			if (id != null) {
				return String.valueOf(id);
			}
			
		}
		
		return (String) valor;
		
	}
	
	
	/**
	 * Método interno que adiciona o atributo num mapa onde atribui o id do objeto como chave.
	 *  
	 * @param componente componente requisitado.
	 * @param entidade entidade a ser atribuida no mapa.
	 * 
	 * @author Marcos Fernando Costa.
	 */
	@SuppressWarnings("rawtypes")
	private void adicionaAtributo(final UIComponent componente, final Entidade entidade) {
		
		final String chave = String.valueOf(entidade.getId());
		this.getAtributos(componente).put(chave, entidade);
	}
	
	/**
	 * Método interno que retorna os atributos de um objeto tipo Combo da tela.
	 * 
	 * @param componente componente a ser pesquisado.
	 * 
	 * @return Map<String,Object> mapa com os atributos do objeto.
	 * 
	 * @author Marcos Fernando Costa.
	 */
	private Map<String, Object> getAtributos(final UIComponent componente) {
		return componente.getAttributes();
	}
	
}