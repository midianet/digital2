/*
 * RegistroNaoEncontradoExcessao.java
 * 
 * Criado pela equipe de desenvolvimento do RHNet
 * integrante do Sistema de Recadastramento do Servidor.
 * 
 * Midianet 2014.
 * 
 * Todos os direitos Copyright est�o reservados.
 */
package midianet.digital.excessao;

import midianet.framework.excessao.NegocioExcessao;

/**
 * RegistroNaoEncontradoExcessao
 * Classe que representa a excessao gen�rica para a camada um registro pesquisado e n�o encontrado.
 * 
 * @category Excessao
 *
 * @see NegocioExcessao
 *
 * @author Marcos Fernando Costa.
 */
public class RegistroNaoEncontradoExcessao extends NegocioExcessao{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor padr�o da Excess�o
	 * 
	 * @param tipo Tipo do registro pesquisado.
	 * @param valor Valor de pesquisado.
	 * 
	 * @author Marcos Fernando Costa.
	 */	
	public RegistroNaoEncontradoExcessao(final String tipo, final Object valor){
	    super("MSG200",tipo, valor);
	}
	
}