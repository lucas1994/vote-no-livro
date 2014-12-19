package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Internautas;

public interface DaoInternauta 
{

	public void adicionar (Internautas it);
	public boolean Logar(Internautas it);
	

}
