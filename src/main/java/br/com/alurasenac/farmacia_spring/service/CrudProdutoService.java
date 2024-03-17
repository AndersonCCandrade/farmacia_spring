package br.com.alurasenac.farmacia_spring.service;

import br.com.alurasenac.farmacia_spring.model.Fabricante;
import br.com.alurasenac.farmacia_spring.model.Produto;
import br.com.alurasenac.farmacia_spring.repository.FabricanteRepository;
import br.com.alurasenac.farmacia_spring.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudProdutoService {

    public boolean system = true;
    private final ProdutoRepository produtoRepository;
    private final FabricanteRepository fabricanteRepository;

    public CrudProdutoService(ProdutoRepository produtoRepository, FabricanteRepository fabricanteRepository) {
        this.produtoRepository = produtoRepository;
        this.fabricanteRepository = fabricanteRepository;
    }

    public void inicial (Scanner scanner) {
        while (system) {
            System.out.println("Digite a opção de Produto desejada:");
            System.out.println("1 - Cadastrar Produtos");
            System.out.println("2 - sair");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    salvar(scanner);
                    break;

                default:
                    system = false;
                    break;
            }
        }
    }

    private void salvar(Scanner scanner) {
        System.out.println("Digite o nome do produto");
        String nome = scanner.next();
        nome +=scanner.nextLine();

        System.out.println("Digite a descrição do produto");
        String descricao = scanner.next();
        descricao +=scanner.nextLine();

        System.out.println("Digite o preço do produto");
        Double preco = scanner.nextDouble();

        System.out.println("Digite o ID do Fabricante");
        Integer fabricanteId = scanner.nextInt();

        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setPreco(preco);
        Optional<Fabricante> fabricante = fabricanteRepository.findById(fabricanteId);
        if (fabricante.isEmpty()){
            System.out.println("ID de fabricante não cadastrado.");
            System.out.println("O produto não foi cadastrado tente novamente.");
        }else{
            produto.setFabricante(fabricante.get());
            produtoRepository.save(produto);

            System.out.println("Produto salvo com sucesso");
        }

    }
}
