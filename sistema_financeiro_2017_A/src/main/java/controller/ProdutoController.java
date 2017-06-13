package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.JsonHelper;
import model.Produto;
import repository.ProdutoRepositoryBanco;

@WebServlet(urlPatterns = "/produtocontroller")
public class ProdutoController<ProdutoRepository> extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ProdutoRepositoryBanco pro = new ProdutoRepositoryBanco();
	private JsonHelper jsonHelper = new JsonHelper();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		Integer id_produto = Integer.parseInt(req.getParameter("id_produto"));
		String descricao = req.getParameter("descricao");
		Integer codbarras = Integer.parseInt(req.getParameter("codbarras"));
		Integer id_fornercedor = Integer.parseInt(req.getParameter("id_fornercedor"));
		Double precocusto = Double.parseDouble(req.getParameter("precocusto"));
		Double precovenda = Double.parseDouble(req.getParameter("precovenda"));
		Double precominvenda = Double.parseDouble(req.getParameter("precominvenda"));
		Double precomaxvenda = Double.parseDouble(req.getParameter("precomaxvenda"));
		Double comissaovenda = Double.parseDouble(req.getParameter("comissaovenda"));
		Double qtdestoque = Double.parseDouble(req.getParameter("qtdestoque"));
		Double qtdminestoque = Double.parseDouble(req.getParameter("qtdminestoque"));
		Double altura = Double.parseDouble(req.getParameter("altura"));
		Double peso = Double.parseDouble(req.getParameter("peso"));
		Double largura = Double.parseDouble(req.getParameter("largura"));
		Double profundidade = Double.parseDouble(req.getParameter("profundidade"));
		Integer id_medidaproduto = Integer.parseInt(req.getParameter("id_medidaproduto"));
		Integer id_tipoproduto = Integer.parseInt(req.getParameter("id_tipoproduto"));
		Integer id_funcionario = Integer.parseInt(req.getParameter("id_funcionario"));
		String validade = req.getParameter("validade");

		Produto prod = new Produto(id_produto,
				descricao,
				codbarras,
				id_fornercedor,
				precocusto,
				precovenda,
				precominvenda,
				precomaxvenda,
				comissaovenda,
				qtdestoque,
				qtdminestoque,
				altura,
				peso,
				largura,
				profundidade,
				id_medidaproduto,
				id_tipoproduto,
				id_funcionario,
				validade);

		pro.cadastrar(prod);
		
		try {
			resp.getWriter().println(jsonHelper.gerarJson(prod));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String json;

		try {
			
			json = jsonHelper.gerarJson(pro.buscarTodos());
			resp.getWriter().print(json);
		} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// capturando valores para alterar
		
		Integer id_produto = Integer.parseInt(req.getParameter("id_produto"));
		String descricao = req.getParameter("descricao");
		Integer codbarras = Integer.parseInt(req.getParameter("codbarras"));
		Integer id_fornercedor = Integer.parseInt(req.getParameter("id_fornercedor"));
		Double precocusto = Double.parseDouble(req.getParameter("precocusto"));
		Double precovenda = Double.parseDouble(req.getParameter("precovenda"));
		Double precominvenda = Double.parseDouble(req.getParameter("precominvenda"));
		Double precomaxvenda = Double.parseDouble(req.getParameter("precomaxvenda"));
		Double comissaovenda = Double.parseDouble(req.getParameter("comissaovenda"));
		Double qtdestoque = Double.parseDouble(req.getParameter("qtdestoque"));
		Double qtdminestoque = Double.parseDouble(req.getParameter("qtdminestoque"));
		Double altura = Double.parseDouble(req.getParameter("altura"));
		Double peso = Double.parseDouble(req.getParameter("peso"));
		Double largura = Double.parseDouble(req.getParameter("largura"));
		Double profundidade = Double.parseDouble(req.getParameter("profundidade"));
		Integer id_medidaproduto = Integer.parseInt(req.getParameter("id_medidaproduto"));
		Integer id_tipoproduto = Integer.parseInt(req.getParameter("id_tipoproduto"));
		Integer id_funcionario = Integer.parseInt(req.getParameter("id_funcionario"));
		String validade = req.getParameter("validade");
		
		Produto p = new Produto(id_produto, descricao, codbarras, id_fornercedor, precocusto, precovenda, precominvenda, precomaxvenda, comissaovenda, qtdestoque, qtdminestoque, altura, peso, largura, profundidade, id_medidaproduto, id_tipoproduto, id_funcionario, validade);
		pro.alterar(p);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		pro.excluir(id);
	}
}
