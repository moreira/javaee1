package br.com.caelum.cadastrao.infra;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.cadastrao.modelo.Contato;

@Stateless
public class ContatoDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void salva(Contato c){
		manager.persist(c);
	}

	public List<Contato> lista() {
		return manager.createQuery("from Contato").getResultList();
	}

	public void remove(Contato contato) {
		manager.remove(manager.merge(contato));
	}
}
