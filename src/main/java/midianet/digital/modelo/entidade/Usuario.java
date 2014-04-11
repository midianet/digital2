package midianet.digital.modelo.entidade;

import java.util.Collection;

//@Entity
//@Table(name = "TB_USUARIO")
public class Usuario extends PessoaFisica {
	private static final long serialVersionUID = 7241537432702643636L;

	//	@Column(name = "USUA_LOGIN", length = 15, unique = true, nullable = false)
	private String login;
	
//	@Column(name = "USUA_SENHA", length = 15, nullable = false)
	private String senha;
	
//	 @OneToMany(cascade = CascadeType.ALL)
//	 @JoinTable(name				= "TB_USUARIO_PERFIL",
//	 			uniqueConstraints	= @UniqueConstraint(columnNames = {"PERF_ID","PESS_ID"}),
//	 			joinColumns			= {@JoinColumn(name = "PESS_ID")},
//	 			inverseJoinColumns	= {@JoinColumn(name = "PERF_ID")})
	private Collection<PerfilAcesso> perfis;
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(final String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(final String senha) {
		this.senha = senha;
	}
	
	public Collection<PerfilAcesso> getPerfis() {
		return perfis;
	}
	
	public void setPerfis(final Collection<PerfilAcesso> perfis) {
		this.perfis = perfis;
	}
	
}