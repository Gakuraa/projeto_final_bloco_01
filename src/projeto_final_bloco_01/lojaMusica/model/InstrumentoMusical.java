package projeto_final_bloco_01.lojaMusica.model;

public class InstrumentoMusical extends ProdutoMusical {

	private String tipoInstrumento;

	public InstrumentoMusical(int id, String nome, double preco, int tipo, String tipoInstrumento) {
		super(id, nome, preco, tipo);
		this.tipoInstrumento = tipoInstrumento;
	}

	public String getTipoInstrumento() {
		return tipoInstrumento;
	}

	public void setTipoInstrumento(String tipoInstrumento) {
		this.tipoInstrumento = tipoInstrumento;
	}

	@Override
	public void visualizar() {
		System.out.println("ID: " + getId());
		System.out.println("Nome: " + getNome());
		System.out.println("Tipo: Instrumento Musical");
		System.out.println("Preço: " + getPreco());
		System.out.println("Tipo de Instrumento: " + tipoInstrumento);
	}
}
