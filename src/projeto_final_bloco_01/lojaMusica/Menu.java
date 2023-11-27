package projeto_final_bloco_01.lojaMusica;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import projeto_final_bloco_01.lojaMusica.controller.ProdutoMusicalController;
import projeto_final_bloco_01.lojaMusica.model.CD;
import projeto_final_bloco_01.lojaMusica.model.InstrumentoMusical;
import projeto_final_bloco_01.lojaMusica.model.ProdutoMusical;
import projeto_final_bloco_01.lojaMusica.repository.ProdutoMusicalRepository;

public class Menu {

	private static final ProdutoMusicalRepository produtoMusicalRepository = new ProdutoMusicalController();
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao;

		do {
			System.out.println("-----------------------------------");
			System.out.println("     Loja Musical Generation");
			System.out.println("-----------------------------------");
			System.out.println("1. Cadastrar Produto");
			System.out.println("2. Listar Produtos");
			System.out.println("3. Visualizar Produto por ID");
			System.out.println("4. Atualizar Produto");
			System.out.println("5. Excluir Produto");
			System.out.println("0. Sair");
			System.out.println("-----------------------------------");
			System.out.print("\nEscolha uma opção: ");

			opcao = scanner.nextInt();
			scanner.nextLine();
			switch (opcao) {
			case 1:
				cadastrarProduto();
				break;
			case 2:
				listarProdutos();
				break;
			case 3:
				visualizarProdutoPorId();
				break;
			case 4:
				atualizarProduto();
				break;
			case 5:
				excluirProduto();
				break;
			case 0:
				System.out.println("Saindo do programa. Até logo!");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");

				try {
					opcao = scanner.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("\nDigite valores inteiros!");
					scanner.nextLine();
					opcao = 0;
				}
			}

		} while (opcao != 0);
		if (opcao == 0) {
			System.out.println("\nObrigado comprar na Loja Musical Generation, volte sempre!");
			sobre();
			scanner.close();
			System.exit(0);
		}

	}

	private static void excluirProduto() {
		System.out.print("Digite o ID do produto que deseja excluir: ");
        int id = scanner.nextInt();
        produtoMusicalRepository.excluir(id);
        System.out.println("Produto excluído com sucesso!");
	}

	private static void atualizarProduto() {
		System.out.print("Digite o ID do produto que deseja atualizar: ");
        int id = scanner.nextInt();
        ProdutoMusical produtoExistente = produtoMusicalRepository.encontrarPorId(id);

        if (produtoExistente != null) {
            System.out.print("Digite o novo nome do produto: ");
            String novoNome = scanner.nextLine();
            System.out.print("Digite o novo tipo do produto (1 para Instrumento Musical, 2 para CDs): ");
            int novoTipo = scanner.nextInt();
            System.out.print("Digite o novo preço do produto: ");
            double novoPreco = scanner.nextDouble();

            ProdutoMusical produtoAtualizado;

            if (novoTipo == 1) {
                scanner.nextLine();
                System.out.print("Digite o novo nome do instrumento musical: ");
                String novoTipoInstrumento = scanner.nextLine();
                produtoAtualizado = new InstrumentoMusical(id, novoNome, novoPreco, novoTipo, novoTipoInstrumento);
            } else if (novoTipo == 2) {
                scanner.nextLine();
                System.out.print("Digite o novo nome do artista: ");
                String artista = scanner.nextLine();
                System.out.print("Digite o novo estilo musical: ");
                String estiloMusical = scanner.nextLine();
                produtoAtualizado = new CD(id, novoNome, novoPreco, novoTipo, artista, estiloMusical);
            } else {
                System.out.println("Tipo de produto inválido.");
                return;
            }

            produtoMusicalRepository.atualizar(produtoAtualizado);
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
  
	}

	private static void visualizarProdutoPorId() {
		System.out.print("Digite o ID do produto: ");
		int id = scanner.nextInt();
		ProdutoMusical produto = produtoMusicalRepository.encontrarPorId(id);
		if (produto != null) {
			produto.visualizar();
		} else {
			System.out.println("Produto não encontrado.");
		}

	}

	private static void listarProdutos() {
		List<ProdutoMusical> produtos = produtoMusicalRepository.listarTodos();

		if (produtos.isEmpty()) {
			System.out.println("Nenhum produto cadastrado.");
		} else {
			System.out.println("Lista de Produtos:");
			for (ProdutoMusical produto : produtos) {
				produto.visualizar();
				System.out.println("--------------------");
			}
		}
	}

	private static void cadastrarProduto() {
		System.out.print("Digite o nome do produto: ");
		String nome = scanner.nextLine();
		System.out.print("Digite o tipo do produto (1 para Instrumento Musical, 2 para CDs): ");
		int tipo = scanner.nextInt();
		System.out.print("Digite o preço do produto: ");
		double preco = scanner.nextDouble();

		ProdutoMusical novoProduto;

		int novoId = produtoMusicalRepository.listarTodos().size() + 1;

		if (tipo == 1) {
			scanner.nextLine();
			System.out.print("Digite o tipo de instrumento: ");
			String tipoInstrumento = scanner.nextLine();
			novoProduto = new InstrumentoMusical(novoId, nome, preco, tipo, tipoInstrumento);
		} else if (tipo == 2) {
			scanner.nextLine();
			System.out.print("Digite o artista: ");
			String artista = scanner.nextLine();
			System.out.print("Digite o estilo musical: ");
			String estiloMusical = scanner.nextLine();
			novoProduto = new CD(novoId, nome, preco, tipo, artista, estiloMusical);
		} else {
			System.out.println("Tipo de produto inválido.");
			return;
		}

		produtoMusicalRepository.salvar(novoProduto);
		System.out.println("Produto cadastrado com sucesso! ID: " + novoId);
	}

	private static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Gabriel Yuri Iwakura");
		System.out.println("Projeto final do bloco 01");
		System.out.println("Generation Brasil - gabrieliwakura924@gmail.com");
		System.out.println("https://github.com/Gakuraa");
		System.out.println("*********************************************************");

	}
}
