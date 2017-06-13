package repository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Servico;

public class ServicoRepositoryBanco {

	private Connection conexao = ConexaoFactory.criarConexao();
	
	public void cadastrar(Servico serv) {
		String sql = "insert into servico (id_funcionario,id_servico,descricao,tipo,valorServico,valorMax,valorMin) values (?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, serv.getId_funcionario());
			ps.setInt(2, serv.getId_servico());
			ps.setString(3, serv.getDescricao());
			ps.setString(4, serv.getTipo());
			ps.setDouble(5, serv.getValorServico());
			ps.setDouble(6, serv.getValorMax());
			ps.setDouble(7, serv.getValorMin());
			
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void alterar(Servico serv) {
		String sql = "update servico set id_servico=?,descricao=?,tipo=?,valorServico=?,valorMax=?,valorMin=? where id=?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, serv.getId_servico());
			ps.setString(2, serv.getDescricao());
			ps.setString(3, serv.getTipo());
			ps.setDouble(4, serv.getValorServico());
			ps.setDouble(5, serv.getValorMax());
			ps.setDouble(6, serv.getValorMin());

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void excluir(int id) {
		try {
			String sql = "delete from servico where id=?";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			prepareStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Servico> buscarTodos() {

		List<Servico> lista = new ArrayList<>();

		try {			
			String sql = "select * from servico order by descricao";
			/*if(serv.getDescricao() != null && !serv.getDescricao().equals("") )
				sql = sql.concat(serv.getDescricao());
			if(serv.getTipo() != null && !serv.getTipo().equals(""))
				sql = sql.concat(" AND ").concat(sql);
			if(serv.getValorServico() != null)
				sql = sql.concat(" AND ").concat(sql);
			if(serv.getValorMax() != null)
				sql = sql.concat(" AND ").concat(sql);
			if(serv.getValorMin() != null)
				sql = sql.concat(" AND ").concat(sql);*/
			
				//sql = sql.concat (" order by descricao");
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);
			ResultSet result = prepareStatement.executeQuery();

			while (result.next()) {
				
				Integer id_funcionario = result.getInt("id_funcionario");
				Integer id_servico = result.getInt("id_servico");				
				String descricao = result.getString("descricao");
				String tipo = result.getString("tipo");				
				Double valorServico = Double.parseDouble(result.getString("valorServico"));
				Double valorMax = Double.parseDouble(result.getString("valorMax"));
				Double valorMin = Double.parseDouble(result.getString("valorMin"));

				Servico servico = new Servico(id_funcionario,id_servico,descricao,tipo,valorServico,valorMax,valorMin);
				

				lista.add(servico);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}
	
	

}
