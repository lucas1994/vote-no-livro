package dao;

import java.util.ArrayList;

import entity.Livro;

public interface DaoLivro {
	
	public void adiciona(Livro l);
	public ArrayList<Livro> listarLivros();
	ArrayList<Livro> listarLivrosNome(String Nome);

}
