package br.edu.infnet.VenturaHr.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


import br.edu.infnet.VenturaHr.model.Usuario;
import br.edu.infnet.VenturaHr.repository.UsuarioRepository;



@WebServlet(name = "usuario", urlPatterns = {"/usuario"})
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("ListaUsuario.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario.setSenha(request.getParameter("senha"));
		usuario.setEmail(String.valueOf(request.getParameter("email")));
		usuario.setNome(String.valueOf(request.getParameter("nome")));
		
;
		
		UsuarioRepository.adicionaUsuario(usuario);
		
		request.setAttribute("ListaUsuario", UsuarioRepository.pegarLista());
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
