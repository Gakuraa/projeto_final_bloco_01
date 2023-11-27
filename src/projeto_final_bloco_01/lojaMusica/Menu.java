package projeto_final_bloco_01.lojaMusica;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

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
				// cadastrarProduto();
				break;
			case 2:
				// listarProdutos();
				break;
			case 3:
				// visualizarProdutoPorId();
				break;
			case 4:
				// atualizarProduto();
				break;
			case 5:
				// excluirProduto();
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

	private static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Gabriel Yuri Iwakura");
		System.out.println("Projeto final do bloco 01");
		System.out.println("Generation Brasil - gabrieliwakura924@gmail.com");
		System.out.println("https://github.com/Gakuraa");
		System.out.println("*********************************************************");

	}
}
