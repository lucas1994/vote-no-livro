package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Internautas;
import entity.Livro;
import entity.Voto;

@WebServlet("/CtrlVotoV1")
public class CtrlVotoV1 extends CtrlVoto{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
	{
		//Caso o voto seja computado
		
				Voto v = new Voto();
				v.setInternautas(internauta(req));
				v.setLivro(livro(req));
				
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
	
	
	public Livro livro (HttpServletRequest req)
	{
		Livro l = new Livro();
		ArrayList<Livro>list= (ArrayList<Livro>) req.getSession().getAttribute("listaLivros");
		long isbn= list.get(1).getIsbn();
		l.setIsbn(isbn);
		return l;
	}
	

}
