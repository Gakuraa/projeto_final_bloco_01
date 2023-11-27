package projeto_final_bloco_01.lojaMusica.repository;

import java.util.List;

import projeto_final_bloco_01.lojaMusica.model.ProdutoMusical;

public interface ProdutoMusicalRepository {
	
	void salvar(ProdutoMusical produto);

	void atualizar(ProdutoMusical produto);

	void excluir(int id);

	ProdutoMusical encontrarPorId(int id);

	List<ProdutoMusical> listarTodos();

}