package br.edu.infnet.venturaWEB.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.venturaWEB.model.domain.Usuario;
import br.edu.infnet.venturaWEB.model.service.UsuarioService;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		UsuarioService us = new UsuarioService();
		Usuario usuario = us.obterPorEmail(email);
		request.setAttribute("usuario", usuario);
		String caixaEntrada = "";
		
		if(usuario.getTipo() == Usuario.EMPRESA) {
			caixaEntrada = "/empresas/index.jsp";
		}else if(usuario.getTipo() == Usuario.CANDIDATO) {
			caixaEntrada = "/candidatos/index.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(caixaEntrada);
		rd.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
