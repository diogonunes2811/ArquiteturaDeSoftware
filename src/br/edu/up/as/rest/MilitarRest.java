package br.edu.up.as.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.rpc.ServiceException;

import br.edu.up.as.dao.MilitarDao;
import br.edu.up.as.entidade.Militar;
import br.edu.up.as.service.MilitarService;
import br.edu.up.as.service.PessoaService;

public class MilitarRest {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void salvar(Militar militar) {
		try {
			new PessoaService().salvar(militar);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Militar> listar() {
		List<Militar> militares = new MilitarDao().listar();
		return new ArrayList<>(militares);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void editarPes(Militar militar) {
		try {
			new MilitarService().alterar(militar);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}	
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void excluir(Militar militar) {
		try {
			new MilitarService().excluir(militar);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}	
	}
	
}
