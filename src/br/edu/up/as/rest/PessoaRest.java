package br.edu.up.as.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.rpc.ServiceException;

import br.edu.up.as.dao.Conexao;
import br.edu.up.as.dao.PessoaDao;
import br.edu.up.as.entidade.Pessoa;
import br.edu.up.as.service.PessoaService;

@Path("/pessoarest")
public class PessoaRest {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void salvar(Pessoa pessoa) {
		try {
			new PessoaService().salvar(pessoa);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Pessoa> listar() {
		List<Pessoa> pessoas = new PessoaDao().listar();
		return new ArrayList<>(pessoas);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void editarPes(Pessoa pessoa) {
		try {
			new PessoaService().alterar(pessoa);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}	
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void excluir(Pessoa pessoa) {
		try {
			new PessoaService().excluir(pessoa);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}	
	}
	
	


}
