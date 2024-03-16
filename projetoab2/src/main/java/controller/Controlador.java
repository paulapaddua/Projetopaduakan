package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;
import model.DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/insert", "/read", "/select", "/update", "/delete"})

public class Controlador extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	Cliente clientes = new Cliente();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		String action = request.getServletPath();
		System.out.println(action);
		
		if (action.equals("/insert")) {
			novoContato(request, response);
		} else if (action.equals("/read")) {
			listarContatos(request, response);
		} else if (action.equals("/select")) {
			selecionarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			deletarContato(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clientes.setNome(request.getParameter("nome"));
		clientes.setCpf(request.getParameter("cpf"));
		clientes.setEmail(request.getParameter("email"));
		clientes.setCelular(request.getParameter("celular"));
		clientes.setAdulto(request.getParameter("adulto"));
		
		
		dao.inserirContato(clientes);
		
		PrintWriter saida = response.getWriter();
		saida.println("Usuário cadastrado com sucesso!");
	}
	
	protected void listarContatos (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//criando um objeto que vai receber os dados do banco
		ArrayList<Cliente> Lista = dao.ListarContatos();
		
		//encaminhar a lista ao documento listarContatos.jsp
		request.setAttribute("clientes", Lista);
		RequestDispatcher rd = request.getRequestDispatcher("listarContatos.jsp");
		rd.forward(request, response);
	}
	
	protected void selecionarContato (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//receber o id do contato que vai ser editado
		String idcon = request.getParameter("idcon");
		
		//setar a variavel auxiliar para salvar o id
		clientes.setIdcon(idcon);
		
		//executar o método para selecionar contato do DAO
		dao.selecionarContato(clientes);
		
		//Setar os atributos a serem enviados para o formulário 
		request.setAttribute("idcon", clientes.getIdcon());
		request.setAttribute("nome", clientes.getNome());
		request.setAttribute("cpf", clientes.getCpf());
		request.setAttribute("email", clientes.getEmail());
		request.setAttribute("celular", clientes.getCelular());
		request.setAttribute("adulto", clientes.getAdulto());

		
		//Encaminhar ao documento editarContato.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editarContato.jsp");
		rd.forward(request, response);
		
	}
	
	//método para editar o contato - UPDATE
	protected void editarContato (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Criando um objeto para enviar para o banco
		clientes.setIdcon(request.getParameter("idcon"));
		clientes.setNome(request.getParameter("nome"));
		clientes.setCpf(request.getParameter("cpf"));
		clientes.setEmail(request.getParameter("email"));
		clientes.setCelular(request.getParameter("celular"));
		clientes.setAdulto(request.getParameter("adulto"));

		
		//executar o método para selecionar contato do DAO
		dao.alterarContato(clientes);
		
		//Encaminhar a página de listar
		response.sendRedirect("index.html");
		
	}
	
	protected void deletarContato (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//criando um objeto para enviar para o banco
		clientes.setIdcon(request.getParameter("idcon"));
		
		//executar o método de alterar contato
		dao.deletarContato(clientes);
		
		//redirecionar a pagina de listar
		response.sendRedirect("index.html");
		
	}
}
