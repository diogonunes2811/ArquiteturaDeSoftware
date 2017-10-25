package br.edu.up.as.entidade;

import javax.persistence.Entity;

@Entity
public class Militar extends Pessoa{
	
	private String nomedeguerra;

	public String getNomedeguerra() {
		return nomedeguerra;
	}

	public void setNomedeguerra(String nomedeguerra) {
		this.nomedeguerra = nomedeguerra;
	}
	
}
