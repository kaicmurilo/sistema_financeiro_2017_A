package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.JsonHelper;
import model.Servico;
import repository.ServicoRepositoryBanco;
@WebServlet(urlPatterns = "/servcontroller")
public class ServicoController extends HttpServlet{

		private ServicoRepositoryBanco servicoRepository = new ServicoRepositoryBanco();
		private JsonHelper jsonHelper = new JsonHelper();
		
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Integer id_funcionario = Integer.parseInt(req.getParameter("id_funcionario"));
			Integer id_servico = Integer.parseInt(req.getParameter("id_servico"));
			String descricao = req.getParameter("descricao");
			String tipo = req.getParameter("tipo");
			Double valorServico = Double.parseDouble(req.getParameter("valorServico"));
			Double valorMax = Double.parseDouble(req.getParameter("valorMax"));
			Double valorMin = Double.parseDouble(req.getParameter("valorMin"));

			
			Servico serv = new Servico(id_funcionario,id_servico,descricao,tipo,valorServico,valorMax,valorMin);

			
			servicoRepository.cadastrar(serv);
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
				json = jsonHelper.gerarJson(servicoRepository.buscarTodos());
				resp.getWriter().print(json);
			} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
				
				e.printStackTrace();
			}
			
		}
		
		@Override
		protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Integer idFunc = Integer.parseInt(req.getParameter("idfunc"));
			Integer idServ = Integer.parseInt(req.getParameter("idserv"));			
			String descricao = req.getParameter("descricao");
			String tipo = req.getParameter("tipo");
			Double valorServico = Double.parseDouble(req.getParameter("valorservico"));
			Double valorMax = Double.parseDouble(req.getParameter("valormax"));
			Double valorMin = Double.parseDouble(req.getParameter("valormin"));			
			
			Servico servico = new Servico();
			
			if (idFunc != null ){
				servico.setId_funcionario(idFunc);
			}
			if (descricao != null){
				servico.setDescricao(descricao);
			}
			if (tipo != null ){
				servico.setTipo(tipo);
			}
			if (valorServico != null ){
				servico.setValorServico(valorServico);
			}
			if (valorMax != null ){
				servico.setValorMax(valorMax);
			}
			if (valorMin != null ){
				servico.setValorMin(valorMin);
			}	
			
			servicoRepository.alterar(servico);
		
		}
		
		@Override
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			int id = Integer.parseInt(req.getParameter("id"));			
			servicoRepository.excluir(id);
		
		}
}
