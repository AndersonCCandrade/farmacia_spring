package br.com.alurasenac.farmacia_spring.repository;

import br.com.alurasenac.farmacia_spring.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
    List<Produto> findByNome (String nome);

}
