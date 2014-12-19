package dao;

import java.util.ArrayList;
import java.util.Collections;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.Livro;
import entity.Voto;

public class DaoLivroImp implements DaoLivro{

	@Override
	public void adiciona(Livro l) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Livros");
		EntityManager e = emf.createEntityManager();
		e.getTransaction().begin();
		e.persist(l);
		e.getTransaction().commit();
		e.close();
	}

	@Override
	public ArrayList<Livro> listarLivros() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Livros");
		EntityManager e = emf.createEntityManager();
		e.getTransaction().begin();
		TypedQuery<Livro> qry= (TypedQuery<Livro>) e.createQuery("from Livro");
		e.close();
		ArrayList<Livro> listaLivros =(ArrayList<Livro>) qry.getResultList();
		//sorteia os Premiatoss (vulgo livros)
		Collections.shuffle(listaLivros);
		return listaLivros;
	}

	
	@Override
	public ArrayList<Livro> listarLivrosNome(String Nome) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Livros");
		EntityManager e = emf.createEntityManager();
		e.getTransaction().begin();
		TypedQuery<Livro> qry= (TypedQuery<Livro>) e.createQuery("from Livro where nome like (?)");
		qry.setParameter(1, Nome);
		e.close();
		ArrayList<Livro> listaLivros =(ArrayList<Livro>) qry.getResultList();
		return listaLivros;
	}
}
