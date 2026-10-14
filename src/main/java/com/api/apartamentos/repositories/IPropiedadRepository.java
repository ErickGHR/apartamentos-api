package com.api.apartamentos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import com.api.apartamentos.models.PropiedadModel;

public interface IPropiedadRepository extends JpaRepository<PropiedadModel, Long> {
    @EntityGraph(attributePaths = "propietario")
    List<PropiedadModel> findByTipoIgnoreCase(String tipo);

    @EntityGraph(attributePaths = "propietario")
    List<PropiedadModel> findByPropietario_Id(Long idPropietario);
}
