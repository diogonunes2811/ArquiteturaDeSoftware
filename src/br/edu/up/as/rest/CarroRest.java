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

import br.edu.up.as.dao.CarroDao;
import br.edu.up.as.entidade.Carro;
import br.edu.up.as.service.CarroService;

public class CarroRest {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void salvar(Carro carro) {
		try {
			new CarroService().salvar(carro);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Carro> listar() {
		List<Carro> carros = new CarroDao().listar();
		return new ArrayList<>(carros);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void editarPes(Carro carro) {
		try {
			new CarroService().alterar(carro);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}	
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void excluir(Carro carro) {
		try {
			new CarroService().excluir(carro);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}	
	}
	
}
