package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoLivroImp;
import entity.Livro;

public class CtrlLivros extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res){
	}
	//Grava livros 
	public void gravar(Livro l)
	{
		new DaoLivroImp().adiciona(l);
	}
	
	//Puxa a lista de livros gravados
	public ArrayList<Livro> listar()
	{
		return new DaoLivroImp().listarLivros();
	}
	
	public ArrayList<Livro> listarNome(String nome)
	{
		return new DaoLivroImp().listarLivrosNome(nome);
	}
	

}
