package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Livro;

public class LivroDaoImpl extends HibernateGenericDao<Livro, Long>{

	private static LivroDaoImpl instance = null;
	
	public static LivroDaoImpl getInstance() {
		if (instance == null) {
			instance = new LivroDaoImpl();
		}
		return instance;
	}
	
	public LivroDaoImpl() {
		super(Livro.class);
	}

}
