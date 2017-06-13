package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.JsonHelper;
import model.Funcionario;
import repository.FuncionarioRepositoryBanco;

@WebServlet(urlPatterns = "/funcionario")
public class FuncionarioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	FuncionarioRepositoryBanco func = new FuncionarioRepositoryBanco();
	private JsonHelper jsonHelper = new JsonHelper();
	
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome"), 
		endereco =  req.getParameter("endereco"), 
		cpf = req.getParameter("cpf"),
		rg = req.getParameter("rg"),
		telefone = req.getParameter("telefone"),
		cep = req.getParameter("cep"),
		email = req.getParameter("email");
		
		Funcionario f = new Funcionario(nome, endereco, cpf, rg, telefone, cep, email);
		func.cadastrar(f);
		
		try {
			resp.getWriter().println(jsonHelper.gerarJson(f));
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
	
	public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String json;
		String idb = req.getParameter("id");
		
		if(idb.equals("all")){
		    try {
				json = jsonHelper.gerarJsonLista(func.buscarTodos());
				resp.getWriter().print(json);
			} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			idb = req.getParameter("id");
			int id = Integer.parseInt(idb);
			try {
				json = jsonHelper.gerarJson(func.buscarPorId(id));
				resp.getWriter().print(json);
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
	
	public void doPut (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		int idFunc = Integer.parseInt(req.getParameter("id"));
		
		String nome = req.getParameter("nome"), 
				endereco =  req.getParameter("endereco"), 
				cpf = req.getParameter("cpf"),
				rg = req.getParameter("rg"),
				telefone = req.getParameter("telefone"),
				cep = req.getParameter("cep"),
				email = req.getParameter("email");
		
		Funcionario f = new Funcionario();
		
		f.setId(idFunc);
		f.setNome(nome);
		f.setEndereco(endereco);
		f.setCpf(cpf);
		f.setRg(rg);
		f.setCep(cep);
		f.setTelefone(telefone);
		f.setEmail(email);
		
		func.alterar(f);
	}
	
	public void doDelete (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		func.excluir(id);
	}
	
}
