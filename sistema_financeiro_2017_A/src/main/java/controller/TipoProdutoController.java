package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.JsonHelper;
import model.TipoProduto;
import repository.TipoDespesaRepositoryBanco;
import repository.TipoProdutoRepositoryBanco;
@WebServlet(urlPatterns = "/tipoprodcontroller")
public class TipoProdutoController extends HttpServlet {
	private TipoProdutoRepositoryBanco tipoProdutoRB = new TipoProdutoRepositoryBanco();
	private JsonHelper jsonHelper = new JsonHelper();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Integer id_tipoProduto = Integer.parseInt(req.getParameter("id_tipoProduto"));
		String descricao = req.getParameter("descricao");
		
		TipoProduto tipoPro = new TipoProduto(descricao);

		
		tipoProdutoRB.cadastrar(tipoPro);
		try {
			resp.getWriter().println(jsonHelper.gerarJson(tipoPro));
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
			json = jsonHelper.gerarJson(tipoProdutoRB.buscarTodos());
			resp.getWriter().print(json);
		} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
			
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idPro = Integer.parseInt(req.getParameter("id_tipoProduto"));
		String descricao = req.getParameter("descricao");		
		TipoProduto pro = new TipoProduto();
		
		pro.setDescricao(descricao);
		
		tipoProdutoRB.alterar(pro);
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		tipoProdutoRB.excluir(id);
	}
}
