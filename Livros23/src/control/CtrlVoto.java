package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import dao.DaoVotoImp;
import entity.Internautas;
import entity.Livro;
import entity.Voto;

@WebServlet("/CtrlVoto")
public class CtrlVoto extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	{
		
		
		req.setAttribute("listaLivros", new CtrlLivros().listar());
		req.setAttribute("it",internauta(req) );
		RequestDispatcher rd = req.getRequestDispatcher("./Votacao.jsp");
		
		try {
			rd.forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	
	}	
	
	public Livro livro (HttpServletRequest req)
	{
		Livro l = new Livro();
		ArrayList<Livro>list= (ArrayList<Livro>) req.getSession().getAttribute("listaLivros");
		long isbn= list.get(0).getIsbn();
		l.setIsbn(isbn);
		return l;
	}
	
	public Internautas internauta(HttpServletRequest req)
	{
		Internautas i = new Internautas();
		i=(Internautas)req.getSession().getAttribute("it");
		return i;
	}
	
	//Computa votos 
	public void ComputarVotor(Voto v)
	{
		System.out.println("------------\n"+v.getInternautas().getEmail()+"------------\n"+v.getLivro().getIsbn());
		new DaoVotoImp().adicionar(v);
	}

	
	//Lista Ranking geral de votos
	public ArrayList<Object[]> listarVGeral()
	{
		return new DaoVotoImp().listarVGeral();
	}
	
	
	//Lista ranking de vots por usuário (internauta)
	public ArrayList<Object[]> listarVUsuario(Internautas it)
	{
		return new DaoVotoImp().listarVUsuario(it);
	}
}
