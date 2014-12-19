package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Livro;
import entity.Voto;

@WebServlet("/CtrlVotoV")
public class CtrlVotoV extends CtrlVoto{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
	{
		//Caso o voto seja computado
		
				Voto v = new Voto();
				v.setInternautas(internauta(req));
				v.setLivro(livroD(req));
				
				ComputarVotor(v);
				
				req.setAttribute("listaLivros", new CtrlLivros().listar());
				req.setAttribute("it",internauta(req) );
				RequestDispatcher rd = req.getRequestDispatcher("./Votacao.jsp");
				
				try {
					rd.forward(req, res);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
	}
	
	
	public Livro livroD (HttpServletRequest req)
	{
		Livro l = new Livro();
		ArrayList<Livro>list= (ArrayList<Livro>) req.getSession().getAttribute("listaLivros");
		long isbn= list.get(0).getIsbn();
		l.setIsbn(isbn);
		return l;
	}
	
}
