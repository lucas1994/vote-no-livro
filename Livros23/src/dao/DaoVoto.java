package dao;

import java.util.ArrayList;

import entity.Internautas;
import entity.Voto;

public interface DaoVoto {
	public void adicionar(Voto v);
	public ArrayList<Object[]> listarVGeral();
	public ArrayList<Object[]> listarVUsuario(Internautas it);

}
