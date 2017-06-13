package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.JsonHelper;
import model.Servico;
import model.TipoServico;
import repository.ServicoRepositoryBanco;
import repository.TipoServicoRepositoryBanco;

public class TipoServicoController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TipoServicoRepositoryBanco tiposervicoRepository = new TipoServicoRepositoryBanco();
	private JsonHelper jsonHelper = new JsonHelper();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id_tiposervico = Integer.parseInt(req.getParameter("id_tiposervico"));
		String descricao = req.getParameter("descricao");
		
		TipoServico serv = new TipoServico(id_tiposervico,descricao);

		
		TipoServicoRepositoryBanco.cadastrar(serv);
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
			json = jsonHelper.gerarJson(TipoServicoRepositoryBanco.buscarTodos());
			resp.getWriter().print(json);
		} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idServ = Integer.parseInt(req.getParameter("id_tiposervico"));			
		String descricao = req.getParameter("descricao");
		
		TipoServico servico = new TipoServico();
		
		if (descricao != null){
			servico.setDescricao(descricao);
		}
		
		tiposervicoRepository.alterar(servico);
	
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));			
		tiposervicoRepository.excluir(id);
	
	}
}
