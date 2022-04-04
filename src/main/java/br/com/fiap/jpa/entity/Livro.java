package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ivro")
@SequenceGenerator(name = "livro", sequenceName = "SQ_TB_LIVRO", allocationSize = 1)
public class Livro implements Serializable{

	public Livro () {} 
	
	public Livro(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	public Livro(String titulo, String autor, String isbn, LocalDate dataPublicacao, Boolean ativo,
			LocalDateTime dataCadastro, LocalDateTime dataAtualizacao) {
		this();
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.ativo = ativo;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
	}

	private static final long serialVersionUID = 2511019849292500466L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro")
	private Long id;
	
	@Column(name = "ds_titulo", length = 80, nullable = false)
	private String titulo;

	@Column(name = "ds_autor", length = 80, nullable = false)
	private String autor;

	@Column(name = "nr_isbn", nullable = false)
	private String isbn;	//Codido de verficação do livro

	@Column(name = "dt_publicacao")
	private  LocalDate dataPublicacao;
	
	@Column(name = "st_ativo")
	private Boolean ativo;
	
	@Column(name = "dt_cadastro")
	private LocalDateTime dataCadastro;
	
	@Column(name = "dt_atualizacao")
	private LocalDateTime dataAtualizacao;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public String toString() {
		return "Titulo: " + this.getTitulo()
			+ "\nAutor: " + this.getAutor()
			+ "\nCodigo: " + this.getIsbn()
			+ "\nData de publicacao: " + this.getDataPublicacao()
			+ "\nData de cadastro: " + this.getDataCadastro()
			+ "\nData de atualização: " + this.getDataAtualizacao();
	}
	
	
}
