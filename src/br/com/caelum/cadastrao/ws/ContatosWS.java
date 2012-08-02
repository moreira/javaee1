package br.com.caelum.cadastrao.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebService;

import br.com.caelum.cadastrao.infra.ContatoDAO;
import br.com.caelum.cadastrao.modelo.Contato;

@WebService
public class ContatosWS{

	@Inject
	ContatoDAO dao;
	
	public List<Contato> listaDeContatos(){
		return dao.lista();
	}

}
