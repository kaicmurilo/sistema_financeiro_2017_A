package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.JsonHelper;
import model.Caixa;
import repository.CaixaRepositoryBanco;

public class CaixaController {
	
	private CaixaRepositoryBanco caixaRepository = new CaixaRepositoryBanco();
	private JsonHelper jsonHelper = new JsonHelper();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer formapagamento = Integer.parseInt(req.getParameter("formapagamento"));
		Integer id_cliente = Integer.parseInt(req.getParameter("id_cliente"));
		Integer id_tipodespesa = Integer.parseInt(req.getParameter("id_tipodespesa"));
		Double valor = Double.parseDouble(req.getParameter("valor"));
		Boolean status =  Boolean.parseBoolean((req.getParameter("status")));
		String descricao = req.getParameter("descricao");
		String data =(req.getParameter("data"));

		
		Caixa caix = new Caixa(formapagamento,id_cliente,id_tipodespesa,valor,status,descricao,data);

		
		caixaRepository.cadastrar(caix);
		try {
			resp.getWriter().println(jsonHelper.gerarJson(caix));
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
			json = jsonHelper.gerarJson(caixaRepository.buscarTodos());
			resp.getWriter().print(json);
		} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
			
			e.printStackTrace();
		}
		
	}
	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer formapagamento = Integer.parseInt(req.getParameter("formapagamento"));
		Integer id_cliente = Integer.parseInt(req.getParameter("id_cliente"));
		Integer id_tipodespesa = Integer.parseInt(req.getParameter("id_tipodespesa"));
		Double valor = Double.parseDouble(req.getParameter("valor"));
		Boolean status =  Boolean.parseBoolean((req.getParameter("status")));
		String descricao = req.getParameter("descricao");
		String data =(req.getParameter("data"));
		
		Caixa caix = new Caixa();
		
		if (formapagamento != null ){
			caix.setFormapagamento(formapagamento);
		}
		if (id_cliente != null){
			caix.setId_cliente(id_cliente);
		}
		if (id_tipodespesa != null ){
			caix.setId_tipodespesa(id_tipodespesa);
		}
		if (valor != null ){
			caix.setValor(valor);
		}
		if (status != null ){
			caix.setStatus(status);
		}
		if (descricao != null ){
			caix.setDescricao(descricao);
		}
		if(data != null){
			caix.setData(data);
		}
		
		caixaRepository.alterar(caix);
	
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));			
		caixaRepository.excluir(id);
	
	}
	
	
}
