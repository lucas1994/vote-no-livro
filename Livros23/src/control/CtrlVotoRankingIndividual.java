package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Voto;

@WebServlet("/CtrlVotoU")
public class CtrlVotoRankingIndividual extends CtrlVoto {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
	{
		//Caso seja escolhida a opção de Ranking Unico
		Voto v = new Voto();
		v.setInternautas(internauta(req));
		req.setAttribute("lista", listarVUsuario(v.getInternautas()));
		req.setAttribute("TpRanking", "Ranking de Usuário");
		req.setAttribute("TpNRanking", "Ranking de Geral");
		req.setAttribute("pag", "./CtrlVotoRG");
		RequestDispatcher rd = req.getRequestDispatcher("./Ranking.jsp");
		
		try {
			rd.forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
