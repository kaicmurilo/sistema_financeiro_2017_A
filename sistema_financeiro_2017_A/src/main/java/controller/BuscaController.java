package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;
import repository.ConexaoFactory;

public class BuscaController {
	private Connection conexao = ConexaoFactory.criarConexao();

	public List<Produto> PosicaoEstoque() {
		List<Produto> lista = new ArrayList<>();

		try {
			String sql = "select * from tipo_produto order by id_produto";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);
			ResultSet result = prepareStatement.executeQuery();

			while (result.next()) {

				int id_produto = result.getInt("id_produto");
				String descricao = result.getString("descricao");
				int codbarras = result.getInt("codbarras");
				int id_fornercedor = result.getInt("id_fornecedor");
				double precocusto = result.getDouble("precocusto");
				double precovenda = result.getDouble("precovenda");
				double precominvenda = result.getDouble("precominvenda");
				double precomaxvenda = result.getDouble("precomaxvenda");
				double comissaovenda = result.getDouble("comissaovenda");
				double qtdestoque2 = result.getDouble("qtdestoque");
				double qtdminestoque2 = result.getDouble("qtdminestoque");
				double altura = result.getDouble("altura");
				double peso = result.getDouble("peso");
				double largura = result.getDouble("largura");
				double profundidade = result.getDouble("profundidade");
				int id_medidaproduto = result.getInt("id_medidaproduto");
				int id_tipoproduto = result.getInt("id_tipoproduto");
				int id_funcionario = result.getInt("id_funcionario");
				String validade = result.getString("validade");
				
				Produto posicao_estoque = new Produto(id_produto, descricao, codbarras, id_fornercedor, precocusto, precovenda, precominvenda, precomaxvenda, comissaovenda, qtdestoque2, qtdminestoque2, altura, peso, largura, profundidade, id_medidaproduto, id_tipoproduto, id_funcionario, validade);
				posicao_estoque.setIdproduto(id_produto);
				posicao_estoque.setDescricao(descricao);
				posicao_estoque.setCodbarras(codbarras);
				posicao_estoque.setIdfornercedor(id_fornercedor);
				posicao_estoque.setPrecocusto(precocusto);
				posicao_estoque.setPrecovenda(precovenda);
				posicao_estoque.setPrecominvenda(precominvenda);
				posicao_estoque.setPrecomaxvenda(precomaxvenda);
				posicao_estoque.setComissaovenda(comissaovenda);
				posicao_estoque.setQtdestoque(qtdestoque2);
				posicao_estoque.setQtdminestoque(qtdminestoque2);
				posicao_estoque.setAltura(altura);
				posicao_estoque.setPeso(peso);
				posicao_estoque.setLargura(largura);
				posicao_estoque.setProfundidade(profundidade);
				posicao_estoque.setIdmedidaproduto(id_medidaproduto);
				posicao_estoque.setId_tipoproduto(id_tipoproduto);
				posicao_estoque.setId_funcionario(id_funcionario);
				posicao_estoque.setValidade(validade);
				
				

				lista.add(posicao_estoque);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;

	}
}
