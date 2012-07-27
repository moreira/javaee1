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
	
	@Inject
	private ContatoDAO dao;

	public void salvar(){
		System.out.println("Salvando contato:"+contato.getNome());
		dao.salva(contato);
		init();
	}
	
	public Contato getContato() {
		return contato;
	}
	
	public List<Contato> getContatos() {
		return contatos;
	}
	
	public void remover(Contato contato){
		dao.remove(contato);
		init();
		
	}
	
	@PostConstruct
	public void init(){
		contatos = dao.lista();
		contato=new Contato();
	}
}
