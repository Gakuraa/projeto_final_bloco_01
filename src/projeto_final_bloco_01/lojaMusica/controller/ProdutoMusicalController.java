package projeto_final_bloco_01.lojaMusica.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import projeto_final_bloco_01.lojaMusica.model.ProdutoMusical;
import projeto_final_bloco_01.lojaMusica.repository.ProdutoMusicalRepository;

public class ProdutoMusicalController implements ProdutoMusicalRepository{
	
	private List<ProdutoMusical> produtos = new ArrayList<>();

	@Override
	public void salvar(ProdutoMusical produto) {
		produtos.add(produto);
	}

	@Override
	public void atualizar(ProdutoMusical produto) {
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getId() == produto.getId()) {
				produtos.set(i, produto);
				return;
			}
		}
		throw new RuntimeException("Produto não encontrado para atualização");
	}

	@Override
	public void excluir(int id) {
		Iterator<ProdutoMusical> iterator = produtos.iterator();
		while (iterator.hasNext()) {
			ProdutoMusical produto = iterator.next();
			if (produto.getId() == id) {
				iterator.remove();
				return;
			}
		}
		throw new RuntimeException("Produto não encontrado para exclusão");
		
	}

	@Override
	public ProdutoMusical encontrarPorId(int id) {
		for (ProdutoMusical produto : produtos) {
			if (produto.getId() == id) {
				return produto;
			}
		}
		return null;
	}

	@Override
	public List<ProdutoMusical> listarTodos() {
		return new ArrayList<>(produtos);
	}

}
