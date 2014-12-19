package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoInternautaImp;
import entity.Internautas;
import entity.Livro;
import entity.Voto;

@WebServlet("/CtrlInternautas")
public class CtrlInternautas extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		String cmd = req.getParameter("cmd").toString();
		
		Internautas it = new Internautas();
	
		
		if(cmd.equalsIgnoreCase("Iniciar"))
		{
			it.setEmail(req.getParameter("txtEmail"));
			if(!logar(it))
			{
				//Enviar para pag de erro
				RequestDispatcher rd = req.getRequestDispatcher("./index.jsp");
				try {
				req.setAttribute("msg", "Seu email não foi encontrado na nossa base, favor cadastre-se");
				rd.forward(req, res);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
		}
		else
		{
			it.setNome(req.getParameter("txtNome"));
			it.setEmail(req.getParameter("txtEmail"));
			Gravar(it);
		}
		
		
		req.setAttribute("listaLivros", new CtrlLivros().listar());
		req.setAttribute("it", it);
		RequestDispatcher rd = req.getRequestDispatcher("./Votacao.jsp");
		try {
			rd.forward(req, res);
			System.out.println("ToinToin");
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//Grava o internauta 
	public boolean Gravar(Internautas i)
	{
		try{
		 new DaoInternautaImp().adicionar(i);
		 return true;
		}
			catch (Exception e)
			{
				return false;
			}
		}
	
	
	
	//Faz a verificação da crendencial inserida pelo usuário, 
	//credencial = Nome e Email
	public boolean logar(Internautas i)
	{
		if(new DaoInternautaImp().Logar(i))
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	
}
