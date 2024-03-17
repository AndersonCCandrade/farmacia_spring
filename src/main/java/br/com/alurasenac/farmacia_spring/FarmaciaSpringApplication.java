package br.com.alurasenac.farmacia_spring;

import br.com.alurasenac.farmacia_spring.service.CrudFabricanteService;
import br.com.alurasenac.farmacia_spring.service.CrudProdutoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;

@EnableJpaRepositories
@SpringBootApplication
public class FarmaciaSpringApplication implements CommandLineRunner {

	private Boolean system = true;

	private final CrudProdutoService produtoService;
	private final CrudFabricanteService fabricanteService;

	public FarmaciaSpringApplication(CrudProdutoService produtoService, CrudFabricanteService fabricanteService) {
		this.produtoService = produtoService;
		this.fabricanteService = fabricanteService;
	}


	public static void main(String[] args) {
		SpringApplication.run(FarmaciaSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("BEM VINDO AO APK FARMACIA");
			System.out.println("Digite a opção desejadoa:");
			System.out.println("0 - Sair");
			System.out.println("1 - Fabricante");
			System.out.println("2 - Produto");

			int action = scanner.nextInt();

			switch (action) {
				case 1:
					fabricanteService.inicial(scanner);
					break;
				case 2:
					produtoService.inicial(scanner);
					break;
				default:
					system = false;
					break;
			}

		}
	}
}
