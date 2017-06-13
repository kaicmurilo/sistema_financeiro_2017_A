package model;

public class TipoProduto {
	private int id_tipoproduto;
	private String descricao;
	
	public TipoProduto(String descricao) {
		this.id_tipoproduto = id_tipoproduto;
		this.descricao = descricao;
	}
	
	public TipoProduto(){};
	
	public int getIdtipoproduto() {
		return id_tipoproduto;
	}
	public void setIdtipoproduto(int id_tipoproduto) {
		this.id_tipoproduto = id_tipoproduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
