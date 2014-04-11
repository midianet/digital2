/*
 * SenhaNaoConfereExcessao.java
 * 
 * Criado pela equipe de desenvolvimento do RHNet
 * integrante do Sistema de Recadastramento do Servidor.
 * 
 * Midianet 2014.
 * 
 * Todos os direitos Copyright estão reservados.
 */
package midianet.digital.excessao;

import midianet.framework.excessao.NegocioExcessao;

/**
 * SenhaNaoConfereExcessao
 * Classe que representa a excessao quando uma senha verificada não confere com a senha cadastrada.
 * 
 * @category Excessao
 *
 * @see NegocioExcessao
 *
 * @author Marcos Fernando Costa.
 */
public class SenhaNaoConfereExcessao extends NegocioExcessao{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor padrão da Excessão
	 * 
	 * @author Marcos Fernando Costa.
	 */	
	public SenhaNaoConfereExcessao(){
	    super("MSG0030");
	}
	
}