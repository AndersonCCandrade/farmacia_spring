package br.com.alurasenac.farmacia_spring.repository;

import br.com.alurasenac.farmacia_spring.model.Fabricante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends CrudRepository<Fabricante, Integer> {
}
