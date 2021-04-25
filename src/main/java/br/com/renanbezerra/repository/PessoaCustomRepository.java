package br.com.renanbezerra.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.renanbezerra.model.Pessoa;
import lombok.var;

@Repository
public class PessoaCustomRepository {

	private final EntityManager em;

	public PessoaCustomRepository(EntityManager em) {
		this.em = em;
	}

	public List<Pessoa> find(Long id, String nome, String sobrenome) {
		
		String query = "select P from Pessoa as P ";
		String condicao = "where";
		
		if (id != null) {
			query += condicao + " P.id = :id";
			condicao = " and ";
		}
		
		if (nome != null) {
			query += condicao + " P.nome = :nome";
			condicao = " and ";
		}
		
		if (sobrenome != null) {
			query += condicao + " P.sobrenome = :sobrenome";
		}
	
		var q = em.createQuery(query, Pessoa.class);
		
		if (id != null) {
			q.setParameter("id", id);
		}
		
		if (nome != null) {
			q.setParameter("nome", nome);
		}
		
		if (sobrenome != null) {
			q.setParameter("sobrenome", sobrenome);
		}
		
		return q.getResultList();
	}
	
	
}
