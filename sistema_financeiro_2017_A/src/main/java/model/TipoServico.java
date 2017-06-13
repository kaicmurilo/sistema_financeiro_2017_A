package model;

public class TipoServico {
	public Integer id_tipoServico;
	public String descricao;
	
	public TipoServico(Integer id_tiposervico, String descricao) {
		this.id_tipoServico=id_tiposervico;
		this.descricao=descricao;
	}
	public TipoServico() {
		// TODO Auto-generated constructor stub
	}
	public int getId_tipoServico() {
		return id_tipoServico;
	}
	public void setId_tipoDespesa(int id_tipoDespesa) {
		this.id_tipoServico = id_tipoDespesa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
