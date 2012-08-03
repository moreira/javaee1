package br.com.caelum.cadastrao.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.caelum.cadastrao.infra.ContatoDAO;
import br.com.caelum.cadastrao.modelo.Contato;

@Path("/")
public class ContatoResource {
	@Inject
	private ContatoDAO dao;

	@GET
	@Path("/contatos/{id}")
	@Produces({"application/xml", "application/json"})
	public Contato load(@PathParam("id") Long id){
		return dao.busca(id);
	}
}
