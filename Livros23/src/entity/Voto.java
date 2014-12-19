package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity (name="Voto")
public class Voto {

	@Id
	@GeneratedValue
	private long id;
	
	 @ManyToOne
     @JoinColumn(name = "internauta", nullable = false)
	 private Internautas internautas;
	 
	 @ManyToOne
     @JoinColumn(name = "livro", nullable = false)
	 private Livro livro;
	 
	 @Transient
	 private int total;
	 

	 @Transient
	 private String nome;
	 
	 

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Internautas getInternautas() {
		return internautas;
	}

	public void setInternautas(Internautas internautas) {
		this.internautas = internautas;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
  
}
