package br.edu.up.as.service;
import javax.xml.rpc.ServiceException;

import br.edu.up.as.dao.Dao;
import br.edu.up.as.dao.FactoryDao;
import br.edu.up.as.entidade.Pessoa;

public class PessoaService {
	
	public void salvar(Pessoa p) throws ServiceException {
		
		if (p.getNome() == null || p.getNome().equals("")) {
			
			throw new 
			ServiceException("ERR01 - O nome da pessoa precisa ser preenchido.");
		}
		
		Dao<Pessoa> pessoaDao = FactoryDao.createPessoaDao();
		pessoaDao.salvar(p);
	}
	
	public void alterar(Pessoa p) throws ServiceException {
		Dao<Pessoa> pessoaDao = FactoryDao.createPessoaDao();	
		pessoaDao.alterar(p);
	}
	
	
	public void excluir(Pessoa p) throws ServiceException {
		Dao<Pessoa> pessoaDao = FactoryDao.createPessoaDao();	
		pessoaDao.excluir(p);
	}
	

}
