package br.edu.up.as.dao;

import br.edu.up.as.entidade.Carro;
import br.edu.up.as.entidade.Militar;
import br.edu.up.as.entidade.Pessoa;

public class FactoryDao {

	public static Dao<Pessoa> createPessoaDao() {
		return new PessoaDao();
	}
	
	public static Dao<Carro> createCarroDao(){
		return new CarroDao();
	}
	
	public static Dao<Militar> createMilitarDao(){
		return new MilitarDao();
	}
	
}
