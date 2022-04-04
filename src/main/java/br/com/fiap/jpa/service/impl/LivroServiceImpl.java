package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.LivroDaoImpl;
import br.com.fiap.jpa.entity.Livro;
import br.com.fiap.jpa.service.GenericService;

public class LivroServiceImpl extends GenericService<Livro, Long>{

	private static LivroServiceImpl instance = null;
	private LivroDaoImpl livroDao;
	
	private LivroServiceImpl() {
		livroDao = LivroDaoImpl.getInstance();
	}
	
	public static LivroServiceImpl getInstance() {
		if (instance == null) {
			instance = new LivroServiceImpl();
		}
		return instance;
	}
	
	@Override
	public void inserir(Livro livro) {
		try {
			livroDao.salvar(livro, getEntityManager());
		}catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		}finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(Livro livro) {
		try {
			livroDao.atualizar(livro, getEntityManager());
		} catch(Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		}finally {
			closeEntityManager();
		}
	}

	@Override
	public void remover(Long id) {
		try {
			livroDao.remover(id, getEntityManager());
			getEntityManager().getTransaction().rollback();
		} catch(Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		}finally {
			closeEntityManager();
		}
	}

	@Override
	public Livro obterPorId(Long id) {
		Livro livro = null;
		
		try {
			livro = livroDao.obterPorId(id, getEntityManager());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeEntityManager();
		}
		return livro;
	}

	@Override
	public List<Livro> listar() {
		List<Livro> livros = null;
		
		try {
			livros = livroDao.listar(getEntityManager());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeEntityManager();
		}
		return livros;
	}

}
