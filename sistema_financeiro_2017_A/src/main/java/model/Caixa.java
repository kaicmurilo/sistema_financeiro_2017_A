package model;



public class Caixa {

	public int formapagamento, id_cliente, id_tipodespesa;
	public double valor;
	public boolean status;
	public String descricao, data;
	
	public Caixa(){};

	public Caixa(int formapagamento, int id_cliente, int id_tipodespesa, double valor, boolean status, String descricao,
			String data) {
		
		this.formapagamento = formapagamento;
		this.id_cliente = id_cliente;
		this.id_tipodespesa = id_tipodespesa;
		this.valor = valor;
		this.status = status;
		this.descricao = descricao;
		this.data = data;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_tipodespesa() {
		return id_tipodespesa;
	}

	public void setId_tipodespesa(int id_tipodespesa) {
		this.id_tipodespesa = id_tipodespesa;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getFormapagamento() {
		return formapagamento;
	}

	public void setFormapagamento(int formapagamento) {
		this.formapagamento = formapagamento;
	}

	public int getIdcliente() {
		return id_cliente;
	}

	public void setIdcliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
