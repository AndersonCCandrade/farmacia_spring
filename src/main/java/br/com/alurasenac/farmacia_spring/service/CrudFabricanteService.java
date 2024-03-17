package br.com.alurasenac.farmacia_spring.service;

import br.com.alurasenac.farmacia_spring.model.Fabricante;
import br.com.alurasenac.farmacia_spring.repository.FabricanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
@Service
public class CrudFabricanteService {

    private boolean system = true;

    private final FabricanteRepository fabricanteRepository;

    public CrudFabricanteService(FabricanteRepository fabricanteRepository) {
        this.fabricanteRepository = fabricanteRepository;
    }

    public void inicial (Scanner scanner) {
        while (system) {

            System.out.println("Digite a opção de fabricante desejada:");
            System.out.println("1 - Cadastrar fabricante");
            System.out.println("2 - Exibir lista de fabricantes");
            System.out.println("3 - Atualizar fabricante");
            System.out.println("4 - sair");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    cadastrar(scanner);
                    break;
                case 2:
                    exibirFabricantes();
                    break;
                case 3:
                    atualizarFabricante(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void cadastrar(Scanner scanner) {
        System.out.println("Digite o nome do fabricante");
        String nome = scanner.next();
        nome +=scanner.nextLine();
        Fabricante fabricante = new Fabricante();
        fabricante.setNome(nome);
        fabricanteRepository.save(fabricante);
        System.out.println("Fabricante salvo com sucesso");
    }

    private void exibirFabricantes(){
        Iterable<Fabricante> lista = fabricanteRepository.findAll();
        lista.forEach(System.out::println);
    }

    private void atualizarFabricante(Scanner scanner) {
        System.out.println("Digite o ID do Fabrincate");
        int id = scanner.nextInt();

        Optional<Fabricante> fabricanteOptional = fabricanteRepository.findById(id);

        if(fabricanteOptional.isEmpty()) {
            System.out.println("Fabricante não encontrado");
        }else{
            Fabricante fabricante = fabricanteOptional.get();

            System.out.println("Digite o nome do fabricante");
            String nome = scanner.next();
            nome +=scanner.nextLine();

            fabricante.setId(id);
            fabricante.setNome(nome);

            fabricanteRepository.save(fabricante);
            System.out.println("Fabricante atualizado com sucesso");
        }

    }



}
