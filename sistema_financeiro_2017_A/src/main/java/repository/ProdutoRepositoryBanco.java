package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;
import model.Servico;

public class ProdutoRepositoryBanco {

	private Connection conexao = ConexaoFactory.criarConexao();

	public void cadastrar(Produto prod) {
		String sql = "insert into produto (descricao," + "codbarras," + "id_fornecedor," + "precocusto," + "precovenda,"
				+ "precominvenda," + "precomaxvenda," + "comissaovenda," + "qtdestoque," + "qtdminestoque," + "altura,"
				+ "peso," + "largura," + "profundidade," + "id_medidaproduto," + "id_tipoproduto," + "id_funcionario,"
				+ "validade) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, prod.getDescricao());
			ps.setInt(2, prod.getCodbarras());
			ps.setInt(3, prod.getIdfornercedor());
			ps.setDouble(4, prod.getPrecocusto());
			ps.setDouble(5, prod.getPrecovenda());
			ps.setDouble(6, prod.getPrecominvenda());
			ps.setDouble(7, prod.getPrecomaxvenda());
			ps.setDouble(8, prod.getComissaovenda());
			ps.setDouble(9, prod.getQtdestoque());
			ps.setDouble(10, prod.getQtdminestoque());
			ps.setDouble(11, prod.getAltura());
			ps.setDouble(12, prod.getPeso());
			ps.setDouble(13, prod.getLargura());
			ps.setDouble(14, prod.getProfundidade());
			ps.setInt(15, prod.getIdmedidaproduto());
			ps.setInt(16, prod.getIdtipoproduto());
			ps.setInt(17, prod.getId_funcionario());
			ps.setString(18, prod.getValidade());

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void alterar(Produto prod) {
		String sql = "update produto set descricao=?," + "codbarras=?," + "id_fornecedor=?," + "precocusto=?,"
				+ "precovenda=?," + "precominvenda=?," + "precomaxvenda=?," + "comissaovenda=?," + "qtdestoque=?,"
				+ "qtdminestoque=?," + "altura=?," + "peso=?," + "largura=?," + "profundidade=?,"
				+ "id_medidaproduto=?," + "id_tipoproduto=?," + "id_funcionario=?," + "validade=? where id_produto=?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, prod.getDescricao());
			ps.setInt(2, prod.getCodbarras());
			ps.setInt(3, prod.getIdfornercedor());
			ps.setDouble(4, prod.getPrecocusto());
			ps.setDouble(5, prod.getPrecovenda());
			ps.setDouble(6, prod.getPrecominvenda());
			ps.setDouble(7, prod.getPrecomaxvenda());
			ps.setDouble(8, prod.getComissaovenda());
			ps.setDouble(9, prod.getQtdestoque());
			ps.setDouble(10, prod.getQtdminestoque());
			ps.setDouble(11, prod.getAltura());
			ps.setDouble(12, prod.getPeso());
			ps.setDouble(13, prod.getLargura());
			ps.setDouble(14, prod.getProfundidade());
			ps.setInt(15, prod.getIdmedidaproduto());
			ps.setInt(16, prod.getIdtipoproduto());
			ps.setInt(17, prod.getId_funcionario());
			ps.setString(18, prod.getValidade());

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void excluir(int id) {
		try {
			String sql = "delete from produto where id=?";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			prepareStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Produto> buscarTodos() {

		List<Produto> lista = new ArrayList<>();

		try {
			String sql = "select * from servico order by descricao";
			/*
			 * if(serv.getDescricao() != null && !serv.getDescricao().equals("")
			 * ) sql = sql.concat(serv.getDescricao()); if(serv.getTipo() !=
			 * null && !serv.getTipo().equals("")) sql =
			 * sql.concat(" AND ").concat(sql); if(serv.getValorServico() !=
			 * null) sql = sql.concat(" AND ").concat(sql);
			 * if(serv.getValorMax() != null) sql =
			 * sql.concat(" AND ").concat(sql); if(serv.getValorMin() != null)
			 * sql = sql.concat(" AND ").concat(sql);
			 */

			// sql = sql.concat (" order by descricao");
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);
			ResultSet result = prepareStatement.executeQuery();

			while (result.next()) {

				Integer id_produto = result.getInt("id_produto");
				String descricao = result.getString("descricao");
				Integer codbarras = result.getInt("codbarras");
				Integer id_fornercedor = result.getInt("id_fornercedor");
				Double precocusto = result.getDouble("precocusto");
				Double precovenda = result.getDouble("precovenda");
				Double precominvenda = result.getDouble("precominvenda");
				Double precomaxvenda = result.getDouble("precomaxvenda");
				Double comissaovenda = result.getDouble("comissaovenda");
				Double qtdestoque = result.getDouble("qtdestoque");
				Double qtdminestoque = result.getDouble("qtdminestoque");
				Double altura = result.getDouble("altura");
				Double peso = result.getDouble("peso");
				Double largura = result.getDouble("largura");
				Double profundidade = result.getDouble("profundidade");
				Integer id_medidaproduto = result.getInt("id_medidaproduto");
				Integer id_tipoproduto = result.getInt("id_tipoproduto");
				Integer id_funcionario = result.getInt("id_funcionario");
				String validade = result.getString("validade");

				Produto produto = new Produto(id_produto, descricao, codbarras, id_fornercedor, precocusto, precovenda,
						precominvenda, precomaxvenda, comissaovenda, qtdestoque, qtdminestoque, altura, peso, largura,
						profundidade, id_medidaproduto, id_tipoproduto, id_funcionario, validade);

				lista.add(produto);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}
}
