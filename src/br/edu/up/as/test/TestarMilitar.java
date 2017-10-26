package br.edu.up.as.test;


import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.xml.rpc.ServiceException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.up.as.dao.Dao;
import br.edu.up.as.dao.FactoryDao;
import br.edu.up.as.entidade.Militar;
import br.edu.up.as.service.MilitarService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestarMilitar {

	static Integer id;
	
	@Test
	public void AcadastrarMiltiar() {
		
		Militar m = new Militar();
		m.setId(null);
		m.setNome("Militar");
		m.setIdade(21);
		m.setNomedeguerra("Nunes");
		
		try {
			new MilitarService().salvar(m);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		id = m.getId();
		assertEquals(true,m.getId() != null);
		
	}
	
	@Test
	public void BlistarMilitar() {		
		Dao<Militar> militarDao = FactoryDao.createMilitarDao();	
		List<Militar> militares = militarDao.listar();
		
		assertEquals(true, militares.size()>0);
	}
	
	@Test
	public void CalterarMilitar() {	
		Dao<Militar> militarDao = FactoryDao.createMilitarDao();	
		Militar m = militarDao.buscarPorId(id);
		
		m.setNome("Silva");
		
		militarDao.alterar(m);
		
		m = militarDao.buscarPorId(id);
		
		
		assertEquals(true,m.getNome().equals("Silva"));
	}
	
	@Test
	public void DexcluirMilitar() {
		
		Militar m = new Militar();
		m.setId(id);
				
		try {
			new MilitarService().excluir(m);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		Dao<Militar> militarDao = FactoryDao.createMilitarDao();	
		m = militarDao.buscarPorId(id);
		
		assertEquals(true,m == null);
	}
}
