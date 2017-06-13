package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.JsonHelper;
import model.Medida_produto;
import repository.MedidaProdutoRepositoryBanco;



@WebServlet(urlPatterns = "/medidaprodutocontroller")
public class MedidaProdutoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	MedidaProdutoRepositoryBanco medpro = new MedidaProdutoRepositoryBanco();
	private JsonHelper jsonHelper = new JsonHelper();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String descricao = req.getParameter("descricao");
		
		Medida_produto m = new Medida_produto(descricao);
		medpro.cadastrar(m);
		
		try {
			resp.getWriter().println(jsonHelper.gerarJson(m));
		} catch (IllegalArgumentException e){
			e.printStackTrace();
		} catch (IllegalAccessException e){
			e.printStackTrace();
		} catch (InvocationTargetException e){
			e.printStackTrace();
		}
		
	}
	
	public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	
		String json;
		String idb = req.getParameter("id");
		
		if(idb.equals("all")){
			try {
				json = jsonHelper.gerarJson(medpro.buscarTodos());
				resp.getWriter().println(json);
			}  catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			idb = req.getParameter("id");
			int id = Integer.parseInt(idb);
			try {
				json= jsonHelper.gerarJson(medpro.buscarPorId(id));
				resp.getWriter().println(json);
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
	}
	
	public void doPut (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id_medidaproduto = Integer.parseInt(req.getParameter("id_medidaproduto"));
		String descricao = req.getParameter("descricao");
		
		Medida_produto m = new Medida_produto();
		
		if(id_medidaproduto != null){
			m.setId_medidaproduto(id_medidaproduto);
		}
		if (descricao != null){
			m.setDescricao(descricao);
		}
		
		medpro.alterar(m);
		 
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id_medidaproduto"));
		medpro.excluir(id);
	}
}
