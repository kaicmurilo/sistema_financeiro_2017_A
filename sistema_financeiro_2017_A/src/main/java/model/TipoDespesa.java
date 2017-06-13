package model;

public class TipoDespesa {
	public int id_tipoDespesa;
	public String descricao;
	
	public TipoDespesa(Integer id_tipoDespesa, String descricao) {
		this.id_tipoDespesa=id_tipoDespesa;
		this.descricao=descricao;
	}
	public TipoDespesa() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId_tipoDespesa() {
		return id_tipoDespesa;
	}
	public void setId_tipoDespesa(int id_tipoDespesa) {
		this.id_tipoDespesa = id_tipoDespesa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
