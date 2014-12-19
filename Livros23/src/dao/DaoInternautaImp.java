package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.Internautas;

public class DaoInternautaImp implements DaoInternauta {

	@Override
	public void adicionar(Internautas it) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Livros");
		EntityManager e = emf.createEntityManager();
		e.getTransaction().begin();
		e.persist(it);
		e.getTransaction().commit();
		e.close();
	}

	@Override
	public boolean Logar(Internautas it) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Livros");
		EntityManager e = emf.createEntityManager();
		e.getTransaction().begin();
		TypedQuery<Internautas> qry= (TypedQuery<Internautas>) e.createQuery("from Internautas where email like (?)");
		qry.setParameter(1, it.getEmail());
		e.close();
		ArrayList<Internautas> lista =(ArrayList<Internautas>) qry.getResultList();
		
		if(lista.isEmpty())
		{
			return false;
		}else{
			return true;
		}
	}

}
