/*
 * SenhaExpiradaExcessao.java
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
 * SenhaExpiradaExcessao
 * Classe que representa a excessao quando uma senha esta com a data de validade vencida.
 * 
 * @category Excessao
 *
 * @see NegocioExcessao
 *
 * @author Marcos Fernando Costa.
 */
public class SenhaExpiradaExcessao extends NegocioExcessao{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor padr�o da Excess�o
	 * 
	 * @author Marcos Fernando Costa.
	 */	
	public SenhaExpiradaExcessao(){
	    super("MSG0033");
	}
	
}