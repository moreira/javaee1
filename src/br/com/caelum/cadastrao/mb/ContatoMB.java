package br.com.caelum.cadastrao.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.cadastrao.infra.ContatoDAO;
import br.com.caelum.cadastrao.modelo.Contato;

@Named
@RequestScoped
public class ContatoMB {
	
	private Contato contato;
	private List<Contato> contatos;
	private String action;

	@Inject
	private ContatoDAO dao;

	public void salvar() {
		dao.salva(contato);
		init();
	}

	@PostConstruct
	public void init() {
		contatos = dao.lista();
		contato = new Contato();
	}

	public void action() {
		if ("remover".equals(action)) {
			dao.remove(contato);
			init();
		}
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}

	public Contato getContato() {
		return contato;
	}

	public List<Contato> getContatos() {
		return contatos;
	}
}
