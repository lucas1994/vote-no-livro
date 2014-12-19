package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Livro;


@WebServlet("/CtrlVotoRG")
public class CtrlVotoRankingGeral extends CtrlVoto{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
	{
				{
					
					ArrayList<Livro>listar= (ArrayList<Livro>)req.getAttribute("listaLivros");
					req.getSession().setAttribute("listaLivros", listar);
					req.setAttribute("lista", listarVGeral());
					req.setAttribute("TpRanking", "Ranking de Geral");
					req.setAttribute("TpNRanking", "Ranking de Usuário");
					req.setAttribute("pag", "./CtrlVotoU");
					RequestDispatcher rd = req.getRequestDispatcher("./Ranking.jsp");
					
					try {
						rd.forward(req, res);
					} catch (ServletException | IOException e) {
						e.printStackTrace();
					}
				}
	}
	
}
