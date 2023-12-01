package com.org.place.repository;

import com.org.place.entity.Formulario;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioRepository extends CrudRepository<Formulario, Long>, JpaSpecificationExecutor<Formulario> {
}
