/*
 * ForaMesAniversarioExcessao.java
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
 * ForaMesAniversarioExcessao
 * Classe que representa a excessao na tentativa de recadastramento fora do mês de aniversário.
 * 
 * @category Excessao
 *
 * @see NegocioExcessao
 *
 * @author Marcos Fernando Costa.
 */
public class ForaMesAniversarioExcessao extends NegocioExcessao{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor padrão da Excessão
	 * 
	 * @author Marcos Fernando Costa.
	 */	
	public ForaMesAniversarioExcessao(){
	    super("MSG300");
	}
	
}