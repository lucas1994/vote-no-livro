package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.Internautas;
import entity.Voto;

public class DaoVotoImp implements DaoVoto {

	@Override
	public void adicionar(Voto v) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Livros");
		EntityManager e = emf.createEntityManager();
		e.getTransaction().begin();
		e.persist(v);
		e.getTransaction().commit();
		e.close();
	}

	@Override
	public ArrayList<Object[]> listarVGeral() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Livros");
		EntityManager e = emf.createEntityManager();
		e.getTransaction().begin();
		Query q= e.createNativeQuery("SELECT count(*) total,T2.nome FROM voto AS T1 INNER JOIN livro AS T2 ON T1.livro = T2.isbn GROUP BY t1.livro order by total desc");
		ArrayList<Object[]>lista =(ArrayList<Object[]>) q.getResultList();
		e.close();
		
		return lista;
	}

	@Override
	public ArrayList<Object[]> listarVUsuario(Internautas it) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Livros");
		EntityManager e = emf.createEntityManager();
		e.getTransaction().begin();
		Query q= e.createNativeQuery("SELECT count(*) total,T2.nome FROM voto AS T1 INNER JOIN livro AS T2 ON T1.livro = T2.isbn where internauta like (?) GROUP BY t1.livro order by total desc");
		q.setParameter(1, it.getEmail());
		e.close();
		ArrayList<Object[]>lista =(ArrayList<Object[]>) q.getResultList();

		return lista;
	}

}
