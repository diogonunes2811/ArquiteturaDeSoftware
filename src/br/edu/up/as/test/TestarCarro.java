package br.edu.up.as.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.xml.rpc.ServiceException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.up.as.dao.Dao;
import br.edu.up.as.dao.FactoryDao;
import br.edu.up.as.entidade.Carro;
import br.edu.up.as.service.CarroService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestarCarro {

	static Integer id;
	
	@Test
	public void AcadastrarCarro() {
		
		Carro c = new Carro();
		c.setId(null);
		c.setModelo("Golf");
		c.setPlaca("AAA-0000");
		
		try {
			new CarroService().salvar(c);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		id = c.getId();
		assertEquals(true,c.getId() != null);
		
	}
	
	@Test
	public void BlistarCarro() {		
		Dao<Carro> carroDao = FactoryDao.createCarroDao();	
		List<Carro> carros = carroDao.listar();
		
		assertEquals(true, carros.size()>0);
	}
	
	@Test
	public void CalterarCarro() {	
		Dao<Carro> carroDao = FactoryDao.createCarroDao();	
		Carro c = carroDao.buscarPorId(id);
		
		c.setModelo("Gol");
		
		carroDao.alterar(c);
		
		c = carroDao.buscarPorId(id);
		
		
		assertEquals(true,c.getModelo().equals("Gol"));
	}
	
//	@Test
//	public void DexcluirCarro() {
//		
//		Carro c = new Carro();
//		c.setId(id);
//				
//		try {
//			new CarroService().excluir(c);
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//		
//		Dao<Carro> carroDao = FactoryDao.createCarroDao();	
//		c = carroDao.buscarPorId(id);
//		
//		assertEquals(true,c == null);
//	}
}
