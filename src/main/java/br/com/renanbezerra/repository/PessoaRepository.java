package br.com.renanbezerra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.renanbezerra.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
