package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.JsonHelper;
import model.TipoDespesa;
import repository.TipoDespesaRepositoryBanco;


public class TipoDespesaController extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	private TipoDespesaRepositoryBanco tipoDespesaRepository = new TipoDespesaRepositoryBanco();
	private JsonHelper jsonHelper = new JsonHelper();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id_tipoDespesa = Integer.parseInt(req.getParameter("id_tipodespesa"));
		String descricao = req.getParameter("descricao");
		
		TipoDespesa serv = new TipoDespesa(id_tipoDespesa,descricao);

		
		tipoDespesaRepository.cadastrar(serv);
		try {
			resp.getWriter().println(jsonHelper.gerarJson(serv));
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
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String json;			
		try {				
			json = jsonHelper.gerarJson(tipoDespesaRepository.buscarTodos());
			resp.getWriter().print(json);
		} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idDesp = Integer.parseInt(req.getParameter("id_tipoDespesa"));			
		String descricao = req.getParameter("descricao");
		
		TipoDespesa despesa = new TipoDespesa();
		
		if (descricao != null){
			despesa.setDescricao(descricao);
		}
		
		tipoDespesaRepository.alterar(despesa);
	
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));			
		tipoDespesaRepository.excluir(id);
	
	}
}
