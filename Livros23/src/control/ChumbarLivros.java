package control;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DaoLivroImp;
import dao.DaoVotoImp;
import entity.Internautas;
import entity.Livro;
import entity.Voto;

public class ChumbarLivros  {

	public static void main(String[] args) {
		
		
		//Um novo comentário
		Livro l1 = new Livro();
		l1.setNome("House  - Um guia pratico para vida");
		l1.setUrlImagem("https://uploaddeimagens.com.br/images/000/415/388/full/02_-_Dr_House_Um_guia_para_a_vida_-_Capa.jpg?");
		l1.setIsbn(978856306);

		Livro l2 = new Livro();
		l2.setNome("50 tons de cinza");
		l2.setUrlImagem("https://uploaddeimagens.com.br/images/000/415/389/full/50_tons_1.jpg?1418830966");
		l2.setIsbn(978009957);

		
		Livro l3 = new Livro();
		l3.setNome("O vendedor de sonhos");
		l3.setUrlImagem("https://uploaddeimagens.com.br/images/000/415/391/full/111864216.png?1418831022");
		l3.setIsbn(856009627);

		Livro l4 = new Livro();
		l4.setNome("Engenharia de software");
		l4.setUrlImagem("https://uploaddeimagens.com.br/images/000/415/392/full/noticia2521_(1).jpg?1418831326");
		l4.setIsbn(856330833);
		

		Livro l5 = new Livro();
		l5.setNome("O monge e o Executivo");
		l5.setUrlImagem("https://uploaddeimagens.com.br/images/000/415/393/full/O-Monge-e-o-Executivo.jpg?1418831445");
		l5.setIsbn(857542102);
		
		
		new DaoLivroImp().adiciona(l1);
		new DaoLivroImp().adiciona(l2);
		new DaoLivroImp().adiciona(l3);
		new DaoLivroImp().adiciona(l4);
		new DaoLivroImp().adiciona(l5);
		

		/*
		ArrayList<Object[]>l=new DaoVotoImp().listarVGeral();
		for(Object[] li:l)
		{
			System.out.println(li[0]+"-"+li[1]);
		}
	
		
		Internautas it = new Internautas();
		it.setEmail("lucas@hotmail.com");
		ArrayList<Object[]>listando=new DaoVotoImp().listarVUsuario(it);
		for(Object[] li:listando)
		{
			System.out.println(li[0]+"-"+li[1]);
		}
			*/
	}
}
