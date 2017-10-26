package br.edu.up.as.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.xml.rpc.ServiceException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.up.as.dao.Dao;
import br.edu.up.as.dao.FactoryDao;
import br.edu.up.as.entidade.Pessoa;
import br.edu.up.as.service.PessoaService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestarPessoa {

	static Integer id;
		
	@Test
	public void AcadastrarPessoa() {
		
		Pessoa p = new Pessoa();
		p.setId(null);
		p.setNome("Diogo");
		p.setIdade(21);
		
		try {
			new PessoaService().salvar(p);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		id = p.getId();
		assertEquals(true,p.getId() != null);
		
	}
		
	@Test
	public void BlistarPessoa() {		
		Dao<Pessoa> pessoaDao = FactoryDao.createPessoaDao();	
		List<Pessoa> pessoas = pessoaDao.listar();
		
		assertEquals(true, pessoas.size()>0);
	}
	
	@Test
	public void CalterarPessoa() {	
		Dao<Pessoa> pessoaDao = FactoryDao.createPessoaDao();	
		Pessoa p = pessoaDao.buscarPorId(id);
		
		p.setNome("Pele");
		
		pessoaDao.alterar(p);
		
		p = pessoaDao.buscarPorId(id);
		
		
		assertEquals(true,p.getNome().equals("Pele"));
	}
	
	@Test
	public void DexcluirPessoa() {
		
		Pessoa p = new Pessoa();
		p.setId(id);
				
		try {
			new PessoaService().excluir(p);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		Dao<Pessoa> pessoaDao = FactoryDao.createPessoaDao();	
		p = pessoaDao.buscarPorId(id);
		
		assertEquals(true,p == null);
	}
}
