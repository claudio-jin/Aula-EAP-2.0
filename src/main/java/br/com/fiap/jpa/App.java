package br.com.fiap.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.fiap.jpa.entity.Livro;
import br.com.fiap.jpa.service.impl.LivroServiceImpl;

public class App {

	public static void main(String[] args) {
		
		LivroServiceImpl livroService = LivroServiceImpl.getInstance();
	
		Livro livro1 = new Livro("titulo1", "Clarice Lispector", "1213", LocalDate.of(2000, 2, 2), true, LocalDateTime.now(), LocalDateTime.now());
//		Livro livro2 = new Livro("titulo2", "Clarice Lispector", "1213", LocalDate.of(2000, 2, 2), true, LocalDateTime.now(), LocalDateTime.now());
//		Livro livro3 = new Livro("titulo3", "Clarice Lispector", "1213", LocalDate.of(2000, 2, 2), true, LocalDateTime.now(), LocalDateTime.now());
//
//		livroService.inserir(livro1);
//		livroService.inserir(livro2);		
//		livroService.inserir(livro3);

		
		livroService.atualizar(livro1);
		
		livroService.listar().forEach(System.out::println);;
		
		livroService.obterPorId(2L);
		
		livroService.remover(1L);
	}
}
