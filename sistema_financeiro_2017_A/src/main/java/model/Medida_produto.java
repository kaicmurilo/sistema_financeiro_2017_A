package model;

public class Medida_produto {
	private int id_medidaproduto;
	private String descricao;

	public Medida_produto(){
		
	}
	
	
	
	public Medida_produto(String descricao) {
		this.descricao = descricao;
	}

	public int getId_medidaproduto() {
		return id_medidaproduto;
	}

	public void setId_medidaproduto(int id_medidaproduto) {
		this.id_medidaproduto = id_medidaproduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
