package projeto_final_bloco_01.lojaMusica.model;

public class CD extends ProdutoMusical {

	private String artista;
	private String estiloMusical;

	public CD(int id, String nome, double preco, int tipo, String artista, String estiloMusical) {
		super(id, nome, preco, tipo);
		this.artista = artista;
		this.estiloMusical = estiloMusical;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	@Override
	public void visualizar() {
		System.out.println("ID: " + getId());
		System.out.println("Nome: " + getNome());
		System.out.println("Tipo: CDs de Música");
		System.out.println("Preço: " + getPreco());
		System.out.println("Estilo musical: " + estiloMusical);
		System.out.println("Artista: " + artista);
	}
}