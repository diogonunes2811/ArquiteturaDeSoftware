package br.edu.up.as.service;

import javax.xml.rpc.ServiceException;

import br.edu.up.as.dao.Dao;
import br.edu.up.as.dao.FactoryDao;
import br.edu.up.as.entidade.Carro;

public class CarroService {
	
public void salvar(Carro c) throws ServiceException {
		
		if (c.getModelo() == null || c.getModelo().equals("")) {
			
			throw new 
			ServiceException("ERR01 - O modelo precisa ser preenchido.");
		}
		
		Dao<Carro> carroDao = FactoryDao.createCarroDao();	
		carroDao.salvar(c);
	}
	
	
	public void alterar(Carro c) throws ServiceException {
		Dao<Carro> carroDao = FactoryDao.createCarroDao();	
		carroDao.alterar(c);
	}
	
	
	public void excluir(Carro c) throws ServiceException {
		Dao<Carro> carroDao = FactoryDao.createCarroDao();	
		carroDao.excluir(c);
	}

}
