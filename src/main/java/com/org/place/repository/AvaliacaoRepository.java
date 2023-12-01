package com.org.place.repository;

import com.org.place.entity.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends CrudRepository<Avaliacao, Long>, JpaSpecificationExecutor<Avaliacao> {
}
