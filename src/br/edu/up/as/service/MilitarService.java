package br.edu.up.as.service;

import javax.xml.rpc.ServiceException;

import br.edu.up.as.dao.Dao;
import br.edu.up.as.dao.FactoryDao;
import br.edu.up.as.entidade.Militar;

public class MilitarService {
	
	public void salvar(Militar m) throws ServiceException {
		
		if (m.getNome() == null || m.getNome().equals("")) {
			
			throw new 
			ServiceException("ERR01 - O nome do militar precisa ser preenchido.");
		}
		
		Dao<Militar> militarDao = FactoryDao.createMilitarDao();
		militarDao.salvar(m);
	}
	
	public void alterar(Militar m) throws ServiceException {
		Dao<Militar> militarDao = FactoryDao.createMilitarDao();	
		militarDao.alterar(m);
	}
	
	
	public void excluir(Militar m) throws ServiceException {
		Dao<Militar> militarDao = FactoryDao.createMilitarDao();	
		militarDao.excluir(m);
	}

}
