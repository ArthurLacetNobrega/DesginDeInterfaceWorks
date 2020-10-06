package br.com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.constants.Constants;


public class ContatoController {
	
	private static final String ID_USUARIO = "id";

	private static final String TELEFONE_USUARIO = "telefone";

	private static final String EMAIL_USUARIO = "email";

	private static final String NOME_USUARIO = "nome";



	private static final long serialVersionUID = 1L;

	public ContatoController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter(Constants.ACTION);

		try {
			switch (action) {
			case Constants.NOVO:
				novo(request, response);
				break;
			case Constants.DELETE:
				delete(request, response);
				break;
			case Constants.EDITAR:
				editar(request, response);
				break;
			case Constants.LISTAR :
				list(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(Constants.CONTATOS);
		rd.forward(request, response);
		
	}

	/**
	 * Prepara formulário para cadastro de um novo contato
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void novo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(Constants.ADD_CONTATOS);
		rd.forward(request, response);
	}

	/**
	 * Cadastro de um novo contato
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter(NOME_USUARIO);
		String email = request.getParameter(EMAIL_USUARIO);
		String telefone = request.getParameter(TELEFONE_USUARIO);
		String id = request.getParameter(ID_USUARIO);
		
			
		Contato contato = new Contato();
		contato.setEmail(email);
		contato.setNome(nome);
		contato.setTelefone(telefone);
		
		if(id != "") {
			contato.setId(Long.parseLong(id));
			request.setAttribute("editado", Constantes.CONTATO + " " + nome + Constants.CONTATO_EDITADO);
		}else {
			request.setAttribute("cadastro", Constantes.CONTATO + " "+ nome + Constants.CONTATO_SUCESSO);			
		}
		try {
			this.business.save(contato);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(Constants.CONTATOS);
		rd.forward(request,response);

	}

	/**
	 * Metodo que remove um contato do banco de dados
	 * 
	 * @param request
	 * @param response
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception {
		
		this.business.deleteById(Long.parseLong(request.getParameter(ID_USUARIO)));
		RequestDispatcher rd = request.getRequestDispatcher(Constants.CONTATOS);
		request.setAttribute("remover", Constants.CONTATO + Constants.CONTATO_REMOVIDO);
		rd.forward(request, response);

	}

	/**
	 * Metodo que edita um contato
	 * 
	 * @param request
	 * @param response
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	private void editar(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception {

		Contato contato = this.business.findById(Long.parseLong(request.getParameter(ID_USUARIO)));
		RequestDispatcher rd = request.getRequestDispatcher(Constants.ADD_CONTATOS);
		request.setAttribute("contato", contato);
		rd.forward(request, response);
	}

}
