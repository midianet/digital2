package midianet.digital.modelo.entidade;


//@Entity
//@Table(name = "TB_PERFIL_ACESSO")
//@SequenceGenerator(name = "seqPerfil", sequenceName = "SQ_PERF_ID")
public class PerfilAcesso { //extends Entidade<Long> {
	//private static final long serialVersionUID = 4325483164218040438L;

	//	@Id
//	@GeneratedValue(generator = "seqPerfil")
//	@Column(name = "PERF_ID")
	private Long id;
	
//	@Column(name = "PERF_NOME", nullable = false , length = 20)
	private String nome;
	
//	@Column(name = "PERF_ATIVO", nullable = false, columnDefinition = "boolean default true")
	private Boolean ativo = true;
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(final String nome) {
		this.nome = nome;
	}
	
	public Boolean getAtivo() {
		return ativo;
	}
	
	public void setAtivo(final Boolean ativo) {
		this.ativo = ativo;
	}
	
}