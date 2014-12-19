package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity (name="Livro")
public class Livro {

	@Id
	private long isbn;
	@Column
	private String nome;
	@Column
	private String urlImagem;
	
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long l) {
		this.isbn = l;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	
	
	
}
