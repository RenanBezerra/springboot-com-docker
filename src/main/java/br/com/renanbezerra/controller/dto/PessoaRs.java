package br.com.renanbezerra.controller.dto;

import br.com.renanbezerra.model.Pessoa;
import lombok.Getter;
import lombok.Setter;
import lombok.var;

@Getter
@Setter
public class PessoaRs {

	private Long id;
	private String nome;
	private String sobrenome;
	
	public static PessoaRs converter(Pessoa p) {
		var pessoa = new PessoaRs();
		pessoa.setId(p.getId());
		pessoa.setNome(p.getNome());
		pessoa.setSobrenome(p.getSobrenome());
		
		return pessoa;
		
	}
	
	}
